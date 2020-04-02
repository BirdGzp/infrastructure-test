package com.moon.nosql;

import java.util.concurrent.TimeUnit;

public interface CacheService
{
	<V> void put(String key, V value, Long expire, TimeUnit timeUnit);

	<V> V get(String key);

	<V> V get(String key, Class<V> clazz);

	void delete(String key);

	boolean exists(String key);
}
