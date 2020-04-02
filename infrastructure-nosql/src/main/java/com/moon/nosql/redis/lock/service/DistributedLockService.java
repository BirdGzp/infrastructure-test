package com.moon.nosql.redis.lock.service;

import org.redisson.api.RLock;

public interface DistributedLockService
{

	/**
	 * @param key
	 * @param waitLockTime
	 * @param relateLockTime
	 * @return
	 */
	RLock lock(String key, long waitLockTime, long relateLockTime);

	/**
	 * @param lock
	 */
	void unlock(RLock lock);

	void init();

}
