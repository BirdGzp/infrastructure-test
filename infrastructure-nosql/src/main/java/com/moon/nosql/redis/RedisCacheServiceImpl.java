package com.moon.nosql.redis;

import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.serializer.support.SerializationFailedException;
import org.springframework.stereotype.Component;

import com.google.gson.reflect.TypeToken;
import com.moon.infrastructure.exception.RedisOpsException;
import com.moon.infrastructure.logger.Logger;
import com.moon.infrastructure.logger.LoggerFactory;
import com.moon.infrastructure.util.GsonUtil;
import com.moon.nosql.CacheService;

@Component("infra.redisCacheServiceImpl")
public class RedisCacheServiceImpl implements CacheService
{
	private Logger logger = LoggerFactory.getLogger(RedisCacheServiceImpl.class);

	@Autowired
	@Qualifier("infra.jedisTemplate")
	private JedisTemplate jedisTemplate;

	@Override
	public <V> void put(String key, V value, Long expire, TimeUnit timeUnit)
	{
		if (key == null || value == null)
			return;
		try
		{
			String valueJosn = GsonUtil.toJson(value);
			jedisTemplate.set(key, valueJosn, expire, timeUnit);
		}
		catch (Exception e)
		{
			logger.error(e.getMessage(), e);
			throw new RedisOpsException(e);
		}
	}

	@Override
	public <V> V get(String key)
	{
		if (key == null)
			return null;
		try
		{
			String valueJson = jedisTemplate.get(key);
			Type jsonType = new TypeToken<V>()
			{
			}.getType();
			return GsonUtil.fromJson(valueJson, jsonType);
		}
		catch (SerializationFailedException e)
		{
			logger.error(e.getMessage(), e);
			delete(key);
			return null;
		}
		catch (Exception e)
		{
			logger.error(e.getMessage(), e);
			throw new RedisOpsException(e);
		}
	}

	@Override
	public <V> V get(String key, Class<V> clazz)
	{
		if (key == null)
			return null;
		try
		{
			String valueJson = jedisTemplate.get(key);
			if (StringUtils.isBlank(valueJson))
				return null;
			return GsonUtil.fromJson(valueJson, clazz);
		}
		catch (SerializationFailedException e)
		{
			logger.error(e.getMessage(), e);
			delete(key);
			return null;
		}
		catch (Exception e)
		{
			logger.error(e.getMessage(), e);
			throw new RedisOpsException(e);
		}
	}

	@Override
	public void delete(String key)
	{
		if (StringUtils.isBlank(key))
			return;
		try
		{
			jedisTemplate.del(key);
		}
		catch (Exception e)
		{
			logger.error(e.getMessage(), e);
			throw new RedisOpsException(e);
		}
	}

	@Override
	public boolean exists(String key)
	{
		if (key == null)
			return false;
		try
		{
			return jedisTemplate.exist(key);
		}
		catch (Exception e)
		{
			logger.error(e.getMessage(), e);
			return false;
		}
	}
}
