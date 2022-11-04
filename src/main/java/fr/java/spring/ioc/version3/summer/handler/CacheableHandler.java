package fr.java.spring.ioc.version3.summer.handler;

import fr.java.spring.ioc.common.annotation.Cacheable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class CacheableHandler extends AbstractProxyHandler {

    private static final Logger logger = LoggerFactory.getLogger(CacheableHandler.class);

    private final Map<List<Object>, Object> cacheContainers = new ConcurrentHashMap<>();

    public CacheableHandler(final Object objectToHandle) {
        super(objectToHandle, Cacheable.class);
    }

    public Object getFromCacheOrCompute(final Method method, Object[] args, final Supplier<Object> resultSupplier) {
        var mapKey = List.of(method, List.of(args));

        return cacheContainers.computeIfAbsent(mapKey, key -> {
            logger.info("This is not cached yet.");
            return resultSupplier.get();
        });
    }

}
