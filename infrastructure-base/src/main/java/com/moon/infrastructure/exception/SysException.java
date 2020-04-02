package com.moon.infrastructure.exception;


import com.moon.infrastructure.base.resp.BaseResp;

@SuppressWarnings("serial")
public class SysException extends BaseException
{
	public SysException()
	{
		super();
		this.errorCode = BaseResp.SYSTEM_ERROR;
	}

	public SysException(Exception exception)
	{
		super(exception);
		this.errorCode = BaseResp.SYSTEM_ERROR;
	}

	public SysException(String msg)
	{
		super(msg);
		this.errorCode = BaseResp.SYSTEM_ERROR;
	}

	public SysException(String msg, Exception e)
	{
		super(msg, e);
		this.errorCode = BaseResp.SYSTEM_ERROR;
	}
}