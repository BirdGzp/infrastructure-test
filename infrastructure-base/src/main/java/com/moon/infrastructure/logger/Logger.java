package com.moon.infrastructure.logger;

public interface Logger
{

	/**
	 * 输出跟踪信息
	 *
	 * @param msg 信息内容
	 */
	void trace(String msg);

	/**
	 * 输出跟踪信息
	 *
	 * @param e 异常信息
	 */
	void trace(Throwable e);

	/**
	 * 输出跟踪信息
	 *
	 * @param msg 信息内容
	 * @param e 异常信息
	 */
	void trace(String msg, Throwable e);

	/**
	 * 输出跟踪信息
	 *
	 * @param format 信息内容
	 * @param arguments 参数
	 */
	void trace(String format, Object... arguments);


	/**
	 * 输出调试信息
	 *
	 * @param msg 信息内容
	 */
	void debug(String msg);

	/**
	 * 输出调试信息
	 *
	 * @param e 异常信息
	 */
	void debug(Throwable e);

	/**
	 * 输出调试信息
	 *
	 * @param msg 信息内容
	 * @param e 异常信息
	 */
	void debug(String msg, Throwable e);

	/**
	 * 输出调试信息
	 *
	 * @param format 信息内容
	 * @param arguments 参数
	 */
	void debug(String format, Object... arguments);


	/**
	 * 输出普通信息
	 *
	 * @param msg 信息内容
	 */
	void info(String msg);

	/**
	 * 输出普通信息
	 *
	 * @param e 异常信息
	 */
	void info(Throwable e);

	/**
	 * 输出普通信息
	 *
	 * @param msg 信息内容
	 * @param e 异常信息
	 */
	void info(String msg, Throwable e);

	/**
	 * 输出普通信息
	 *
	 * @param format 信息内容
	 * @param arguments 参数
	 */
	void info(String format, Object... arguments);


	/**
	 * 输出警告信息
	 *
	 * @param msg 信息内容
	 */
	void warn(String msg);

	/**
	 * 输出警告信息
	 *
	 * @param e 异常信息
	 */
	void warn(Throwable e);

	/**
	 * 输出警告信息
	 *
	 * @param msg 信息内容
	 * @param e 异常信息
	 */
	void warn(String msg, Throwable e);

	/**
	 * 输出警告信息
	 *
	 * @param format 信息内容
	 * @param arguments 参数
	 */
	void warn(String format, Object... arguments);

	/**
	 * 输出错误信息
	 *
	 * @param msg 信息内容
	 */
	void error(String msg);

	/**
	 * 输出错误信息
	 *
	 * @param e 异常信息
	 */
	void error(Throwable e);

	/**
	 * 输出错误信息
	 *
	 * @param msg 信息内容
	 * @param e 异常信息
	 */
	void error(String msg, Throwable e);

	/**
	 * 输出错误信息
	 *
	 * @param format 信息内容
	 * @param arguments 参数
	 */
	void error(String format, Object... arguments);

	/**
	 * 输出致命错误信息
	 *
	 * @param msg 信息内容
	 */
	void fatal(String msg);

	/**
	 * 输出致命错误信息
	 *
	 * @param e 异常信息
	 */
	void fatal(Throwable e);

	/**
	 * 输出致命错误信息
	 *
	 * @param msg 信息内容
	 * @param e 异常信息
	 */
	void fatal(String msg, Throwable e);

	/**
	 * 输出致命错误信息
	 *
	 * @param format 信息内容
	 * @param arguments 参数
	 */
	void fatal(String format, Object... arguments);

	/**
	 * 跟踪信息是否开启
	 *
	 * @return 是否开启
	 */
	boolean isTraceEnabled();

	/**
	 * 调试信息是否开启
	 *
	 * @return 是否开启
	 */
	boolean isDebugEnabled();

	/**
	 * 普通信息是否开启
	 *
	 * @return 是否开启
	 */
	boolean isInfoEnabled();

	/**
	 * 警告信息是否开启
	 *
	 * @return 是否开启
	 */
	boolean isWarnEnabled();

	/**
	 * 错误信息是否开启
	 *
	 * @return 是否开启
	 */
	boolean isErrorEnabled();
}
