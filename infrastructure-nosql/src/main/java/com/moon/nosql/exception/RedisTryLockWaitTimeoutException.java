package com.moon.nosql.exception;

import com.moon.infrastructure.base.resp.BaseResp;
import com.moon.infrastructure.base.resp.RespCode;
import com.moon.infrastructure.exception.BaseException;

public class RedisTryLockWaitTimeoutException extends BaseException
{

	public RedisTryLockWaitTimeoutException(String msg)
	{
		super(msg);
		this.errorCode = BaseResp.REDIS_TRY_LOCK_TIME_OUT;
	}

	public RedisTryLockWaitTimeoutException(RespCode errorCode)
	{
		super(errorCode.getDesc());
		this.errorCode = errorCode;
	}

	public RedisTryLockWaitTimeoutException(RespCode errorCode, String message)
	{
		super(message);
		this.errorCode = errorCode;
	}

}
