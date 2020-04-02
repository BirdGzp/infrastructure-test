package com.moon.nosql.redis;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.util.Pool;

@Configuration
public class RedisConfig
{
	@Value("${infra_config|redis.host:localhost}")
	private String host;

	@Value("${infra_config|redis.port:6379}")
	private int port;

	@Value("${infra_config|redis.password:}")
	private String password;

	@Value("${infra_config|redis.timeout:2000}")
	private int timeout;

	@Value("${infra_config|redis.database:0}")
	private int database;

	@Value("${infra_config|redis.maxTotal:1000}")
	private int maxTotal;

	@Value("${infra_config|redis.maxIdle:10}")
	private int maxIdle;

	@Value("${infra_config|redis.minIdle:1}")
	private int minIdle;

	@Value("${infra_config|redis.timeBetweenEvictionRunsMillis:30000}")
	private int timeBetweenEvictionRunsMillis;

	@Value("${infra_config|redis.testWhileIdle:true}")
	private boolean testWhileIdle;

	@Value("${infra_config|redis.timeBetweenEvictionRunsMillis:60000}")
	private int minEvictableIdleTimeMillis;

	@Value("${infra_config|redis.sentinels:}")
	private String sentinels;

	@Value("${infra_config|redis.master:ew6001}")
	private String sentinelMaster;

	@Value("${infra_config|redis.testOnBorrow:true}")
	private boolean testOnBorrow;

	@Value("${infra_config|redis.testOnReturn:true}")
	private boolean testOnReturn;

	@Bean
	@Qualifier("infra.jedisPool")
	public Pool<Jedis> jedisPool()
	{
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setTestOnBorrow(testOnBorrow);
		poolConfig.setTestOnReturn(testOnReturn);
		poolConfig.setMaxIdle(maxIdle);
		poolConfig.setMaxTotal(maxTotal);
		poolConfig.setMinIdle(minIdle);
		poolConfig.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		poolConfig.setTestWhileIdle(testWhileIdle);
		poolConfig.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);

		if (StringUtils.isEmpty(sentinels))
		{
			return new redis.clients.jedis.JedisPool(poolConfig, host, port, timeout,
					password, database, null);
		}
		else
		{
			String[] sentinel = sentinels.split("\\s*,\\s*");
			Set<String> sentinelSet = new HashSet<>(CollectionUtils.arrayToList(sentinel));
			return new redis.clients.jedis.JedisSentinelPool(sentinelMaster, sentinelSet, poolConfig, timeout,
					password);
		}

	}

}
