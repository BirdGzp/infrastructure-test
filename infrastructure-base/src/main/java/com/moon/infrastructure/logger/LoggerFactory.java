package com.moon.infrastructure.logger;

import org.apache.logging.log4j.LogManager;

public class LoggerFactory
{
	public static Logger getLogger(String name)
	{
		return new Log4j2Logger(LogManager.getLogger(name));
	}

	public static Logger getLogger(Class<?> clazz)
	{
		return new Log4j2Logger(LogManager.getLogger(clazz));
	}

	public static Logger getLogger(String name, String fqcn)
	{
		return new Log4j2Logger(LogManager.getLogger(name), fqcn);
	}

	public static Logger getLogger(Class<?> clazz, String fqcn)
	{
		return new Log4j2Logger(LogManager.getLogger(clazz), fqcn);
	}
}
