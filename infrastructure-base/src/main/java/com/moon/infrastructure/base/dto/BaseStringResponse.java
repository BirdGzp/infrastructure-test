package com.moon.infrastructure.base.dto;


import com.moon.infrastructure.base.resp.RespCode;

public class BaseStringResponse extends BaseResponse
{
	private static final long serialVersionUID = -4235430244875558634L;
	private String value;

	public BaseStringResponse()
	{
		super();
	}

	public BaseStringResponse(boolean success, String errorCode, String errorMsg)
	{
		super(success, errorCode, errorMsg);
	}

	public BaseStringResponse(RespCode respCode)
	{
		super(respCode);
	}

	public BaseStringResponse(RespCode respCode, String errorMsg)
	{
		super(respCode, errorMsg);
	}

	public BaseStringResponse(String errorCode, String errorMsg)
	{
		super(errorCode, errorMsg);
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

}
