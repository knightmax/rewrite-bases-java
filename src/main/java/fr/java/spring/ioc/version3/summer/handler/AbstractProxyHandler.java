package fr.java.spring.ioc.version3.summer.handler;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AbstractProxyHandler {
    
    private final Object objectToHandle;
    private final Class<? extends Annotation> annotation;
    
    public AbstractProxyHandler(final Object objectToHandle, final Class<? extends Annotation> annotation) {
        this.objectToHandle = objectToHandle;
        this.annotation = annotation;
    }
    
    public boolean isSupported(final Method method) {
        try {
            return objectToHandle.getClass()
                    .getMethod(method.getName(), method.getParameterTypes())
                    .isAnnotationPresent(annotation);
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
