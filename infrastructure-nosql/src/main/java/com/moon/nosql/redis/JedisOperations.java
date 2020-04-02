package com.moon.nosql.redis;

import java.util.concurrent.TimeUnit;


public interface JedisOperations
{
	void set(String key, String value, Long expire, TimeUnit timeUnit);

	String get(String key);

	void del(String key);

	void expire(String key, Long expire, TimeUnit timeUnit);

	boolean exist(String key);
}
