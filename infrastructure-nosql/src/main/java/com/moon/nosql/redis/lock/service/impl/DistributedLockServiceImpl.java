package com.moon.nosql.redis.lock.service.impl;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.redisson.api.RLock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.moon.nosql.exception.RedisTryLockWaitTimeoutException;
import com.moon.nosql.redis.lock.DistributedLockUtil;
import com.moon.nosql.redis.lock.redisson.RedissonService;
import com.moon.nosql.redis.lock.service.DistributedLockService;


@Service("commonDistributedLockService")
@Transactional(propagation = Propagation.NEVER)
public class DistributedLockServiceImpl implements DistributedLockService
{
	private Log log = LogFactory.getLog(getClass());

	private static final String EPAY_REDIS_LOCK_PREFIX = "epay_dislock_";
	private static final String PAY_LOCK_PREFIX = "pay_";
	public static final String REDIS_LOCK_CONFIG = "REDIS_LOCK_CONFIG";
	/** redisson分布式锁 支付场景 等锁时间 */
	public static final String RLOCK_PAY_WAIT_TIME_MS = "RLOCK_PAY_WAIT_TIME_MS";
	/** redisson分布式锁 支付场景过期时间 */
	public static final String RLOCK_PAY_EXPIRE_TIME_MS = "RLOCK_PAY_EXPIRE_TIME_MS";


	/**
	 * 若返回了Rlock，需显示 unlock
	 * @param key 一般为业务号
	 * @param waitLockTime  等锁时间 单位毫秒
	 * @param relateLockTime 锁自动释放时间
	 * @return lock，成功上锁后返回，否则返回 null
	 */
	@Override
	public RLock lock(String key, long waitLockTime, long relateLockTime)
	{
		if (!DistributedLockUtil.isRedisDistributeLockWork())
		{
			return null;
		}
		String lockKey = EPAY_REDIS_LOCK_PREFIX + key;
		if (log.isDebugEnabled())
		{
			log.debug("开始获取锁，" + lockKey);
		}
		try
		{
			RLock lock = RedissonService.getRedissonClient().getLock(lockKey);
			if (lock.tryLock(waitLockTime, relateLockTime, TimeUnit.MILLISECONDS))
			{
				if (log.isDebugEnabled())
				{
					log.debug("获取到锁，" + lockKey);
				}
				return lock;
			}
			else
			{
				if (log.isDebugEnabled())
				{
					log.debug("没获取到锁，" + lockKey);
				}
				log.warn("redis分布式锁tryLock-wait超时，key:" + lockKey);
				throw new RedisTryLockWaitTimeoutException("redis Lock wait timeout");
			}
		}
		catch (RedisTryLockWaitTimeoutException e)
		{
			throw e;
		}
		catch (Exception e)
		{
			log.error("redis分布式锁tryLock异常，key:" + lockKey, e);
			return null;
		}
	}

	@Override
	public void unlock(RLock lock)
	{
		try
		{
			if (lock != null)
			{
				lock.unlock();
			}
		}
		catch (Exception e)
		{
			log.error("redisson释放分布式锁异常", e);
		}
	}

	@Override
	public void init()
	{

	}

}
