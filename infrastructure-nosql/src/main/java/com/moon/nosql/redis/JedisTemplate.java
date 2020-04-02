package com.moon.nosql.redis;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.util.Pool;

@Component("infra.jedisTemplate")
public class JedisTemplate implements JedisOperations
{
	@Autowired
	@Qualifier("infra.jedisPool")
	private Pool<Jedis> jedisPool;

	@Override
	public void set(String key, String value, Long expire, TimeUnit timeUnit)
	{
		try(Jedis jedis = getJedis())
		{
			jedis.set(key, value);
			int tiemout = (int)timeUnit.toSeconds(expire);
			jedis.expire(key, tiemout);
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	@Override
	public String get(String key)
	{
		try(Jedis jedis = getJedis())
		{
			return jedis.get(key);
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	@Override
	public void del(String key)
	{
		try(Jedis jedis = getJedis())
		{
			jedis.del(key);
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	@Override
	public void expire(String key, Long expire, TimeUnit timeUnit)
	{
		try(Jedis jedis = getJedis())
		{

			int tiemout = (int)timeUnit.toSeconds(expire);
			jedis.expire(key, tiemout);
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	@Override
	public boolean exist(String key)
	{
		try(Jedis jedis = getJedis())
		{
			return jedis.exists(key);
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	private Jedis getJedis()
	{
		return jedisPool.getResource();
	}

	public Pool<Jedis> getJedisPool()
	{
		return jedisPool;
	}

	public void setJedisPool(Pool<Jedis> jedisPool)
	{
		this.jedisPool = jedisPool;
	}
}
