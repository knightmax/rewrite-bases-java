package fr.java.spring.ioc.version2.summer.context;

import fr.java.spring.ioc.SummerException;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.util.Set;

@SuppressWarnings("unchecked")
public class ApplicationContext {

    private final Set<Class<?>> componentBeans;

    public ApplicationContext(Class<?> applicationClass) {
        final Reflections reflections = new Reflections(applicationClass.getPackage().getName());
        this.componentBeans = null; // TODO Get component classes
    }

    public <T> T getBean(Class<T> clazz) {
        final Class<T> implementation = getImplementation(clazz);
        return createBean(implementation);
    }

    private <T> Class<T> getImplementation(Class<T> item) {
        /**
         * TODO Get all classes corresponding the Bean we want to instantiate.
         * We are going to use the corresponding interface to facilitate the classes filtering.
         */
        final Set<Class<?>> classes = null;

        if (classes.size() > 1) {
            throw new SummerException("There are more than 1 implementation for " + item.getName());
        }

        return (Class<T>) classes.stream()
              .findFirst()
              .orElseThrow(() -> new SummerException("No valid candidate for bean " + item));
    }

    private <T> T createBean(Class<T> implementation) {
        try {
            final Constructor<T> constructor = getConstructor(implementation);
            final Object[] parameters = getConstructorParameters(constructor);

            return constructor.newInstance(parameters);
        } catch (Exception e) {
            throw new SummerException("Exception occurred creating bean " + implementation.getName(), e);
        }
    }

    private <T> Constructor<T> getConstructor(Class<T> clazz) {
        final Constructor<T>[] constructors = (Constructor<T>[]) clazz.getConstructors();
        if (constructors.length == 1) {
            return constructors[0];
        }

        final Set<Constructor<T>> constructorsWithAnnotation = null; // TODO Get right constructor

        if (constructorsWithAnnotation.size() > 1) {
            throw new SummerException("More than 1 constructor for " + clazz.getName());
        }

        return constructorsWithAnnotation.stream()
              .findFirst()
              .orElseThrow(() -> new SummerException("Cannot find constructor for " + clazz.getName()));
    }

    private <T> Object[] getConstructorParameters(Constructor<T> constructor) {
        final Class<?>[] parameterTypes = constructor.getParameterTypes();
        return null; // TODO What do we need to do to instantiate Bean depending on another Bean ?
    }
}
