package com.moon.nosql.redis.lock.redisson;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedissonService
{
	private final static Log log = LogFactory.getLog(RedissonService.class);

	private static String masterName;
	private static String password;
	private static String slaveConnectionPoolSize;
	private static String slaveConnectionMinimumIdleSize;
	private static String masterConnectionPoolSize;
	private static String masterConnectionMinimumIdleSize;
	private static String idleNonnectionTimeout;
	private static String connectTimeout;
	private static String timeout;
	private static String sentinelAddr;
	private static String retryAttempts;
	private static String retryInterval;

	private static RedissonClient redissonClient;

	public void init()
	{
		getRedissonClient();
	}

	public static RedissonClient getRedissonClient()
	{
		if (redissonClient == null)
		{
			synchronized (RedissonService.class)
			{
				if (redissonClient == null)
				{
					redissonClient = Redisson.create(buildRedssionConfig());
				}
			}
		}
		return redissonClient;
	}

	private static Config buildRedssionConfig()
	{
		log.info("redis地址为 ： " + sentinelAddr);
		Config config = new Config();
		config.useSentinelServers().setMasterName(masterName).setPassword(password)
				.setSlaveConnectionPoolSize(Integer.parseInt(slaveConnectionPoolSize))
				.setSlaveConnectionMinimumIdleSize(Integer.parseInt(slaveConnectionMinimumIdleSize))
				.setMasterConnectionPoolSize(Integer.parseInt(masterConnectionPoolSize))
				.setMasterConnectionMinimumIdleSize(Integer.parseInt(masterConnectionMinimumIdleSize))
				.setIdleConnectionTimeout(Integer.parseInt(idleNonnectionTimeout))
				.setConnectTimeout(Integer.parseInt(connectTimeout)).setTimeout(Integer.parseInt(timeout))
				.setRetryAttempts(Integer.parseInt(retryAttempts)).setRetryInterval(Integer.parseInt(retryInterval))
				.addSentinelAddress(sentinelAddr.split(","));

		return config;
	}

	public void setMasterName(String masterName)
	{
		RedissonService.masterName = masterName;
	}

	public void setPassword(String password)
	{
		RedissonService.password = password;
	}

	public void setSlaveConnectionPoolSize(String slaveConnectionPoolSize)
	{
		RedissonService.slaveConnectionPoolSize = slaveConnectionPoolSize;
	}

	public void setSlaveConnectionMinimumIdleSize(String slaveConnectionMinimumIdleSize)
	{
		RedissonService.slaveConnectionMinimumIdleSize = slaveConnectionMinimumIdleSize;
	}

	public void setMasterConnectionPoolSize(String masterConnectionPoolSize)
	{
		RedissonService.masterConnectionPoolSize = masterConnectionPoolSize;
	}

	public void setMasterConnectionMinimumIdleSize(String masterConnectionMinimumIdleSize)
	{
		RedissonService.masterConnectionMinimumIdleSize = masterConnectionMinimumIdleSize;
	}

	public void setIdleNonnectionTimeout(String idleNonnectionTimeout)
	{
		RedissonService.idleNonnectionTimeout = idleNonnectionTimeout;
	}

	public void setConnectTimeout(String connectTimeout)
	{
		RedissonService.connectTimeout = connectTimeout;
	}

	public void setTimeout(String timeout)
	{
		RedissonService.timeout = timeout;
	}

	public void setSentinelAddr(String sentinelAddr)
	{
		RedissonService.sentinelAddr = sentinelAddr;
	}

	public void setRetryAttempts(String retryAttempts)
	{
		RedissonService.retryAttempts = retryAttempts;
	}

	public void setRetryInterval(String retryInterval)
	{
		RedissonService.retryInterval = retryInterval;
	}

	private RedissonService()
	{
	}
}
