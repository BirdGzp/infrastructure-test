package com.moon.infrastructure.util.threadpool;

import java.util.concurrent.atomic.AtomicLong;

public class CustomThreadFactory implements java.util.concurrent.ThreadFactory
{

	private String threadName;
	private AtomicLong atomicLong = new AtomicLong(0L);

	@Override
	public Thread newThread(Runnable r)
	{
		Thread thread = new Thread(r);
		thread.setName(threadName + "-" + atomicLong.getAndIncrement());
		thread.setUncaughtExceptionHandler(new CustomUncaughtExceptionHandler());
		return thread;
	}

	public CustomThreadFactory(String threadName)
	{
		this.threadName = threadName;
	}

	public CustomThreadFactory()
	{
	}
}
