package com.moon.infrastructure.threadpool;

import java.util.Map;
import java.util.concurrent.Callable;

import org.slf4j.MDC;

public abstract class CustomCallable<V> implements Callable<V>
{

	private final Map mdcContext = MDC.getCopyOfContextMap();

	/**
	 * Computes a result, or throws an exception if unable to do so.
	 *
	 * @return computed result
	 * @throws Exception if unable to compute a result
	 */
	@Override
	public V call() throws Exception
	{
		if (mdcContext != null)
		{
			MDC.setContextMap(mdcContext);
		}
		try
		{
			return callTask();
		}
		finally
		{
			MDC.clear();
		}
	}

	protected abstract V callTask();
}
