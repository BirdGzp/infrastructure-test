package com.moon.nosql.redis;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.moon.infrastructure.logger.Logger;
import com.moon.infrastructure.logger.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.util.Pool;

@Component
public class RedisShutdownHook
{
	private Logger logger = LoggerFactory.getLogger(RedisShutdownHook.class);

	@Autowired
	@Qualifier("infra.jedisPool")
	private Pool<Jedis> jedisPool;


	@PostConstruct
	public void redisPoolDestroy()
	{
		Runtime.getRuntime().addShutdownHook(new Hook(jedisPool));
	}

	class Hook extends Thread
	{
		private Pool<Jedis> jedisPool;
		@Override
		public void run()
		{
			if (jedisPool != null)
			{
				logger.info("[infra]redis连接池销毁...");
				jedisPool.destroy();
			}
		}

		public Hook(Pool<Jedis> jedisPool)
		{
			this.jedisPool = jedisPool;
		}
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
