package com.moon.infrastructure.exception;


import com.moon.infrastructure.base.resp.BaseResp;

public class RedisOpsException extends BaseException
{
	public RedisOpsException()
	{
		super();
		this.errorCode = BaseResp.REDIS_OPERATION_ERROR;
	}

	public RedisOpsException(Exception exception)
	{
		super(exception);
		this.errorCode = BaseResp.REDIS_OPERATION_ERROR;
	}

	public RedisOpsException(String msg)
	{
		super(msg);
		this.errorCode = BaseResp.REDIS_OPERATION_ERROR;
	}

	public RedisOpsException(String msg, Exception e)
	{
		super(msg, e);
		this.errorCode = BaseResp.REDIS_OPERATION_ERROR;
	}
}
