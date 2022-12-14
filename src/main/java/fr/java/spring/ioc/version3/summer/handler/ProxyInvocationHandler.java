package fr.java.spring.ioc.version3.summer.handler;

import fr.java.spring.ioc.common.exception.SummerException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProxyInvocationHandler implements InvocationHandler {

    private final Object objectToHandle;
    // TODO Store cacheable handler

    public ProxyInvocationHandler(Object objectToHandle) {
        this.objectToHandle = objectToHandle;
        // TODO Instantiate cacheable handler
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        // TODO third step, call the right handler
        // TODO is cache supported + cache

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
