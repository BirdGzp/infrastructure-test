package com.moon.infrastructure.threadpool;

import java.util.Map;

import org.slf4j.MDC;

public abstract class CustomRunnable implements Runnable
{
	private final Map mdcContext = MDC.getCopyOfContextMap();

	@Override
	public void run()
	{
		if (mdcContext != null)
		{
			MDC.setContextMap(mdcContext);
		}
		try
		{
			runTask();
		}
		finally
		{
			MDC.clear();
		}
	}

	protected abstract void runTask();
}
