package com.moon.infrastructure.exception;

import com.moon.infrastructure.base.resp.BaseResp;
import com.moon.infrastructure.base.resp.RespCode;

public class IllegalBusinessArgumentException extends IllegalArgumentException
{

	public IllegalBusinessArgumentException(String message)
	{
		super(message);
		this.errorCode = BaseResp.PARAM_ILLEGAL;
	}

	public IllegalBusinessArgumentException(RespCode errorCode)
	{
		super(errorCode);
	}

	public IllegalBusinessArgumentException(RespCode errorCode,
			String message)
	{
		super(errorCode, message);
	}
}
