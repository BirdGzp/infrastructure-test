package com.moon.infrastructure.exception;

import com.moon.infrastructure.base.resp.BaseResp;
import com.moon.infrastructure.base.resp.RespCode;

/**
 * @Author: gongzhipeng
 * @Date: 2020/3/17 4:12 下午
 * @Description:
 * @Project: infrastructure-test
 * @Package com.moon.infrastructure.exception
 */
public class IoRuntimeException extends BaseException
{
	public IoRuntimeException(String message)
	{
		super(message);
		this.errorCode = BaseResp.IO_RUNTIME_EXCEPTION;
	}

	public IoRuntimeException(RespCode errorCode)
	{
		super(errorCode.getDesc());
		this.errorCode = errorCode;
	}

	public IoRuntimeException(RespCode errorCode, String message)
	{
		super(message);
		this.errorCode = errorCode;
	}

	public IoRuntimeException(String msg, Throwable cause)
	{
		super(msg, cause);
		this.errorCode = BaseResp.IO_RUNTIME_EXCEPTION;
	}
}
