package com.moon.infrastructure.util.threadpool;

import com.moon.infrastructure.logger.Logger;
import com.moon.infrastructure.logger.LoggerFactory;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomRejectedExecutionHandler implements RejectedExecutionHandler
{
	private final static Logger log = LoggerFactory.getLogger(CustomRejectedExecutionHandler.class);

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor)
	{
		log.info("thread pool is full and be blocked!"
				+ " corePoolSize=" + executor.getCorePoolSize()
				+ ", maxPoolSize=" + executor.getMaximumPoolSize()
				+ ", keepAliveTime="
				+ executor.getKeepAliveTime(TimeUnit.SECONDS)
				+ ", poolSize=" + executor.getPoolSize()
				+ ", activeCount=" + executor.getActiveCount()
				+ ", taskCount=" + executor.getTaskCount()
				+ ", largestPoolSize=" + executor.getLargestPoolSize()
				+ ", completedTaskCount="
				+ executor.getCompletedTaskCount());
	}
}
