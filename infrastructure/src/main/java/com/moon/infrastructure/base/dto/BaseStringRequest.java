package com.moon.infrastructure.base.dto;

public class BaseStringRequest extends BaseRequest
{
	private String value;

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public BaseStringRequest(String value)
	{
		this.value = value;
	}
}
