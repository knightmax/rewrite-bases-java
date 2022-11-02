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
        // TODO Verify that the method supports the annotation handled (isAnnotationPresent)
        return false;
    }

}
