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
        // TODO Second step, the abstract level, we verify the annotation is supported
        // TODO Verify that the method, directly on the instance, supports the annotation handled (isAnnotationPresent)
        return false;
    }

}
