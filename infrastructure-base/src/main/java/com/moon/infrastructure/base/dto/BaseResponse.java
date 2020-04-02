package com.moon.infrastructure.base.dto;

import com.moon.infrastructure.base.resp.RespCode;

import java.io.Serializable;


public class BaseResponse extends Dto implements Serializable
{
	private static final long serialVersionUID = -4970381659732411468L;

	/** 结果  */
	protected boolean success;
	/** 错误码 */
	protected String errorCode;
	/** 错误内容 */
	protected String errorMsg;

	private static final String SUCCESS_CODE = "0000";

	public BaseResponse(boolean success, String errorCode, String errorMsg)
	{
		this.success = success;
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public BaseResponse()
	{
	}

	public BaseResponse(RespCode respCode)
	{
		this.errorCode = respCode.getCode();
		this.errorMsg = respCode.getDesc();
		this.success = errorCode.endsWith(SUCCESS_CODE);
	}

	public BaseResponse(RespCode respCode, String errorMsg)
	{
		this.errorCode = respCode.getCode();
		this.errorMsg = errorMsg;
		this.success = errorCode.endsWith(SUCCESS_CODE);
	}

	public BaseResponse(String errorCode, String errorMsg)
	{
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.success = errorCode.endsWith(SUCCESS_CODE);
	}

	public boolean isSuccess()
	{
		return success;
	}

	public void setSuccess(boolean success)
	{
		this.success = success;
	}

	public String getErrorCode()
	{
		return errorCode;
	}

	public void setErrorCode(String errorCode)
	{
		this.errorCode = errorCode;
	}

	public String getErrorMsg()
	{
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg)
	{
		this.errorMsg = errorMsg;
	}

}
