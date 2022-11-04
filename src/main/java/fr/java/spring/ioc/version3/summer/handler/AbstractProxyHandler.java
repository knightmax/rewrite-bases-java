package fr.java.spring.ioc.version3.summer.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AbstractProxyHandler {

    private static final Logger logger = LoggerFactory.getLogger(AbstractProxyHandlerSolution.class);

    private final Object objectToHandle;
    private final Class<? extends Annotation> annotation;

    public AbstractProxyHandler(final Object objectToHandle, final Class<? extends Annotation> annotation) {
        this.objectToHandle = objectToHandle;
        this.annotation = annotation;
    }

    public boolean isSupported(final Method method) {
        try {
            return objectToHandle.getClass().getMethod(method.getName(), method.getParameterTypes()).isAnnotationPresent(annotation);
        } catch (NoSuchMethodException e) {
            logger.error("Method is not supported", e);
            return false;
        }
    }

}
