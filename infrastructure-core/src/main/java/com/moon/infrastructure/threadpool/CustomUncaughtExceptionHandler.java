package com.moon.infrastructure.threadpool;


import com.moon.infrastructure.logger.Logger;
import com.moon.infrastructure.logger.LoggerFactory;

public class CustomUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler
{
	private final static Logger logger = LoggerFactory.getLogger(
			CustomUncaughtExceptionHandler.class);

	@Override
	public void uncaughtException(Thread t, Throwable e)
	{
		logger.error("Custom-Thread " + t.getName() + " catch one exception", e);
	}
}
