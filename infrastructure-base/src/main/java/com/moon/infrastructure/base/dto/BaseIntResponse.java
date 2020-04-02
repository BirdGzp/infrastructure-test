package com.moon.infrastructure.base.dto;


import com.moon.infrastructure.base.resp.RespCode;

public class BaseIntResponse extends BaseResponse
{
	private static final long serialVersionUID = -5435500923798579007L;
	private int value;

	public BaseIntResponse()
	{
		super();
	}

	public BaseIntResponse(boolean success, String errorCode, String errorMsg)
	{
		super(success, errorCode, errorMsg);
	}

	public int getValue()
	{
		return value;
	}

	public void setValue(int value)
	{
		this.value = value;
	}

	public BaseIntResponse(RespCode respCode)
	{
		super(respCode);
	}

	public BaseIntResponse(RespCode respCode, String errorMsg)
	{
		super(respCode, errorMsg);
	}

	public BaseIntResponse(String errorCode, String errorMsg)
	{
		super(errorCode, errorMsg);
	}

	public BaseIntResponse(RespCode respCode, int value)
	{
		super(respCode);
		this.value = value;
	}
}
