package com.moon.infrastructure.base.dto;


import com.moon.infrastructure.base.resp.RespCode;

/**
 * 包含一个Boolean型变量的返回值
 * @author: suhao
 * @create: 2018-01-30
 **/
public class BaseBooleanResponse extends BaseResponse
{
	private Boolean bizResult = null;

	public BaseBooleanResponse()
	{
	}

	public BaseBooleanResponse(boolean success, String errorCode, String errorMsg, Boolean bizResult)
	{
		super(success, errorCode, errorMsg);
		this.bizResult = bizResult;
	}

	public BaseBooleanResponse(RespCode respCode)
	{
		super(respCode);
	}

	public BaseBooleanResponse(RespCode respCode, Boolean bizResult)
	{
		super(respCode);
		this.bizResult = bizResult;
	}

	public BaseBooleanResponse(RespCode respCode, String errorMsg)
	{
		super(respCode, errorMsg);
	}

	public BaseBooleanResponse(String errorCode, String errorMsg)
	{
		super(errorCode, errorMsg);
	}

	public Boolean getBizResult()
	{
		return bizResult;
	}

	public void setBizResult(Boolean bizResult)
	{
		this.bizResult = bizResult;
	}

}
