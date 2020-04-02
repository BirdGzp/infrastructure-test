package com.moon.infrastructure.exception;

import com.moon.infrastructure.base.resp.BaseResp;
import com.moon.infrastructure.base.resp.RespCode;

public class IllegalArgumentException extends BaseException
{
	public IllegalArgumentException(String message)
	{
		super(message);
		this.errorCode = BaseResp.PARAM_ILLEGAL;
	}

	public IllegalArgumentException(RespCode errorCode)
	{
		super(errorCode.getDesc());
		this.errorCode = errorCode;
	}

	public IllegalArgumentException(RespCode errorCode, String message)
	{
		super(message);
		this.errorCode = errorCode;
	}

}
