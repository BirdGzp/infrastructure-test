package com.moon.infrastructure.logger;

import java.io.Serializable;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.spi.AbstractLogger;
import org.apache.logging.log4j.spi.ExtendedLoggerWrapper;

public class Log4j2Logger extends ExtendedLoggerWrapper implements Logger, Serializable
{
	private static final long serialVersionUID = -668052519033209896L;

	private ExtendedLoggerWrapper extendedLogger;

	private final static String EXCEPTION = "EXCEPTION";

	private String FQCN = Log4j2Logger.class.getName();

	public Log4j2Logger(org.apache.logging.log4j.Logger logger)
	{
		super((AbstractLogger) logger, logger.getName(), logger.getMessageFactory());
		this.extendedLogger = this;
	}

	public Log4j2Logger(org.apache.logging.log4j.Logger logger, String fqcn)
	{
		super((AbstractLogger) logger, logger.getName(), logger.getMessageFactory());
		this.extendedLogger = this;
		this.FQCN = fqcn;
	}

	/**
	 * 输出跟踪信息
	 *
	 * @param msg 信息内容
	 */
	@Override
	public void trace(String msg)
	{
		extendedLogger.logIfEnabled(FQCN, Level.TRACE, null, msg);
	}

	/**
	 * 输出跟踪信息
	 *
	 * @param e 异常信息
	 */
	@Override
	public void trace(Throwable e)
	{
		extendedLogger.logIfEnabled(FQCN, Level.TRACE, null, EXCEPTION, e);
	}

	/**
	 * 输出跟踪信息
	 *  @param msg 信息内容
	 * @param e 异常信息
	 */
	@Override
	public void trace(String msg, Throwable e)
	{
		extendedLogger.logIfEnabled(FQCN, Level.TRACE, null, msg, e);
	}

	/**
	 * 输出跟踪信息
	 *  @param format 信息内容
	 * @param arguments 参数
	 */
	@Override
	public void trace(String format, Object... arguments)
	{
		extendedLogger.logIfEnabled(FQCN, Level.TRACE, null, format, arguments);
	}

	/**
	 * 输出调试信息
	 *
	 * @param msg 信息内容
	 */
	@Override
	public void debug(String msg)
	{
		extendedLogger.logIfEnabled(FQCN, Level.DEBUG, null, msg);
	}

	/**
	 * 输出调试信息
	 *
	 * @param e 异常信息
	 */
	@Override
	public void debug(Throwable e)
	{
		extendedLogger.logIfEnabled(FQCN, Level.DEBUG, null, EXCEPTION, e);
	}

	/**
	 * 输出调试信息
	 *  @param msg 信息内容
	 * @param e 异常信息
	 */
	@Override
	public void debug(String msg, Throwable e)
	{
		extendedLogger.logIfEnabled(FQCN, Level.DEBUG, null, msg, e);
	}

	/**
	 * 输出调试信息
	 *  @param format 信息内容
	 * @param arguments 参数
	 */
	@Override
	public void debug(String format, Object... arguments)
	{
		extendedLogger.logIfEnabled(FQCN, Level.DEBUG, null, format, arguments);
	}

	/**
	 * 输出普通信息
	 *
	 * @param msg 信息内容
	 */
	@Override
	public void info(String msg)
	{
		extendedLogger.logIfEnabled(FQCN, Level.INFO, null, msg);
	}

	/**
	 * 输出普通信息
	 *
	 * @param e 异常信息
	 */
	@Override
	public void info(Throwable e)
	{
		extendedLogger.logIfEnabled(FQCN, Level.INFO, null, EXCEPTION, e);
	}

	/**
	 * 输出普通信息
	 *  @param msg 信息内容
	 * @param e 异常信息
	 */
	@Override
	public void info(String msg, Throwable e)
	{
		extendedLogger.logIfEnabled(FQCN, Level.INFO, null, msg, e);
	}

	/**
	 * 输出普通信息
	 *  @param format 信息内容
	 * @param arguments 参数
	 */
	@Override
	public void info(String format, Object... arguments)
	{
		extendedLogger.logIfEnabled(FQCN, Level.INFO, null, format, arguments);
	}

	/**
	 * 输出警告信息
	 *
	 * @param msg 信息内容
	 */
	@Override
	public void warn(String msg)
	{
		extendedLogger.logIfEnabled(FQCN, Level.WARN, null, msg);
	}

	/**
	 * 输出警告信息
	 *
	 * @param e 异常信息
	 */
	@Override
	public void warn(Throwable e)
	{
		extendedLogger.logIfEnabled(FQCN, Level.WARN, null, EXCEPTION, e);
	}

	/**
	 * 输出警告信息
	 *  @param msg 信息内容
	 * @param e 异常信息
	 */
	@Override
	public void warn(String msg, Throwable e)
	{
		extendedLogger.logIfEnabled(FQCN, Level.WARN, null, msg, e);
	}

	/**
	 * 输出警告信息
	 *  @param format 信息内容
	 * @param arguments 参数
	 */
	@Override
	public void warn(String format, Object... arguments)
	{
		extendedLogger.logIfEnabled(FQCN, Level.WARN, null, format, arguments);
	}

	/**
	 * 输出错误信息
	 *
	 * @param msg 信息内容
	 */
	@Override
	public void error(String msg)
	{
		extendedLogger.logIfEnabled(FQCN, Level.ERROR, null, msg);
	}

	/**
	 * 输出错误信息
	 *
	 * @param e 异常信息
	 */
	@Override
	public void error(Throwable e)
	{
		extendedLogger.logIfEnabled(FQCN, Level.ERROR, null, EXCEPTION, e);
	}

	/**
	 * 输出错误信息
	 *  @param msg 信息内容
	 * @param e 异常信息
	 */
	@Override
	public void error(String msg, Throwable e)
	{
		extendedLogger.logIfEnabled(FQCN, Level.ERROR, null, msg, e);
	}

	/**
	 * 输出错误信息
	 *  @param format 信息内容
	 * @param arguments 参数
	 */
	@Override
	public void error(String format, Object... arguments)
	{
		extendedLogger.logIfEnabled(FQCN, Level.ERROR, null, format, arguments);
	}

	/**
	 * 输出致命错误信息
	 *
	 * @param msg 信息内容
	 */
	@Override
	public void fatal(String msg)
	{
		extendedLogger.logIfEnabled(FQCN, Level.FATAL, null, msg);
	}

	/**
	 * 输出致命错误信息
	 *
	 * @param e 异常信息
	 */
	@Override
	public void fatal(Throwable e)
	{
		extendedLogger.logIfEnabled(FQCN, Level.FATAL, null, EXCEPTION, e);
	}

	/**
	 * 输出致命错误信息
	 *  @param msg 信息内容
	 * @param e 异常信息
	 */
	@Override
	public void fatal(String msg, Throwable e)
	{
		extendedLogger.logIfEnabled(FQCN, Level.FATAL, null, msg, e);
	}

	/**
	 * 输出致命错误信息
	 *  @param format 信息内容
	 * @param arguments 参数
	 */
	@Override
	public void fatal(String format, Object... arguments)
	{
		extendedLogger.logIfEnabled(FQCN, Level.FATAL, null, format, arguments);
	}

	/**
	 * 跟踪信息是否开启
	 *
	 * @return 是否开启
	 */
	@Override
	public boolean isTraceEnabled()
	{
		return extendedLogger.isTraceEnabled();
	}

	/**
	 * 调试信息是否开启
	 *
	 * @return 是否开启
	 */
	@Override
	public boolean isDebugEnabled()
	{
		return super.isDebugEnabled();
	}

	/**
	 * 普通信息是否开启
	 *
	 * @return 是否开启
	 */
	@Override
	public boolean isInfoEnabled()
	{
		return super.isInfoEnabled();
	}

	/**
	 * 警告信息是否开启
	 *
	 * @return 是否开启
	 */
	@Override
	public boolean isWarnEnabled()
	{
		return super.isWarnEnabled();
	}

	/**
	 * 错误信息是否开启
	 *
	 * @return 是否开启
	 */
	@Override
	public boolean isErrorEnabled()
	{
		return super.isErrorEnabled();
	}
}
