package fr.java.spring.ioc.version3.summer.context;

import fr.java.spring.ioc.common.annotation.Autowired;
import fr.java.spring.ioc.common.annotation.Component;
import fr.java.spring.ioc.common.exception.SummerException;
import fr.java.spring.ioc.version3.summer.handler.ProxyInvocationHandler;

import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class ApplicationContext {
    
    private final Set<Class<?>> componentBeans;
    
    public ApplicationContext(Class<?> applicationClass) {
        final Reflections reflections = new Reflections(applicationClass.getPackage().getName());
        this.componentBeans = new HashSet<>(reflections.getTypesAnnotatedWith(Component.class));
    }
    
    public <T> T getBean(Class<T> clazz) {
        final Class<T> implementation = getImplementation(clazz);
        return createBean(clazz, implementation);
    }
    
    private <T> Class<T> getImplementation(Class<T> item) {
        final Set<Class<?>> classes = componentBeans.stream()
                .filter(componentBean -> List.of(componentBean.getInterfaces()).contains(item))
                .collect(Collectors.toSet());
        
        if (classes.size() > 1) {
            throw new SummerException("There are more than 1 implementation for " + item.getName());
        }
        
        return (Class<T>) classes.stream()
                .findFirst()
                .orElseThrow(() -> new SummerException("No valid candidate for bean " + item));
    }
    
    private <T> T createBean(Class<T> clazz, Class<T> implementation) {
        try {
            final Constructor<T> constructor = getConstructor(implementation);
            final Object[] parameters = getConstructorParameters(constructor);
            final T bean = constructor.newInstance(parameters);
            
            /**
             * TODO create the proxy (Proxy.newProxyInstance) with : - the classloader - the class we want to implement - and the wrapper of our
             * implementation
             */
            final Object proxy = Proxy.newProxyInstance(this.getClass().getClassLoader(),
                    new Class[]{ clazz }, 
                    new ProxyInvocationHandler(bean));
            
            return clazz.cast(proxy);
            
        } catch (Exception e) {
            throw new SummerException("Exception occurred creating bean " + implementation.getName(), e);
        }
    }
    
    private <T> Constructor<T> getConstructor(Class<T> clazz) {
        final Constructor<T>[] constructors = (Constructor<T>[]) clazz.getConstructors();
        if (constructors.length == 1) {
            return constructors[0];
        }
        
        final Set<Constructor<T>> constructorsWithAnnotation = Arrays.stream(constructors)
                .filter(constructor -> constructor.isAnnotationPresent(Autowired.class))
                .collect(Collectors.toSet());
        
        if (constructorsWithAnnotation.size() > 1) {
            throw new SummerException("More than 1 constructor for " + clazz.getName());
        }
        
        return constructorsWithAnnotation.stream()
                .findFirst()
                .orElseThrow(() -> new SummerException("Cannot find constructor for " + clazz.getName()));
    }
    
    private <T> Object[] getConstructorParameters(Constructor<T> constructor) {
        final Class<?>[] parameterTypes = constructor.getParameterTypes();
        return Arrays.stream(parameterTypes)
                .map(this::getBean)
                .toArray(Object[]::new);
    }
}
