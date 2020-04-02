package com.moon.infrastructure.exception;


import com.moon.infrastructure.base.resp.RespCode;

public class WebIllegalArgumentException extends IllegalArgumentException
{
	public WebIllegalArgumentException(String message)
	{
		super(message);
	}

	public WebIllegalArgumentException(RespCode errorCode)
	{
		super(errorCode);
	}

	public WebIllegalArgumentException(RespCode errorCode, String message)
	{
		super(errorCode, message);
	}
}
