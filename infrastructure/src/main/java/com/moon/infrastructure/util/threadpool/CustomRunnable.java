package com.moon.infrastructure.util.threadpool;

import org.slf4j.MDC;

import java.util.Map;

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
