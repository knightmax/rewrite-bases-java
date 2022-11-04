package fr.java.spring.ioc.version3.summer.handler;

import fr.java.spring.ioc.common.exception.SummerException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProxyInvocationHandler implements InvocationHandler {

    private final CacheableHandler cacheableHandler;
    private final Object objectToHandle;

    public ProxyInvocationHandler(Object objectToHandle) {
        this.objectToHandle = objectToHandle;
        this.cacheableHandler = new CacheableHandler(objectToHandle);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        if (cacheableHandler.isSupported(method)) {
            return cacheableHandler.getFromCacheOrCompute(method, args, () -> invokeMethod(method, args));
        }

        return invokeMethod(method, args);
    }

    private Object invokeMethod(Method method, Object[] args) {
        try {
            return method.invoke(objectToHandle, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new SummerException("Error occurred in proxy", e);
        }
    }
}
