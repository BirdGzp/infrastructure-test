package com.moon.infrastructure.base.dto;


import javax.validation.constraints.NotNull;

public class BaseStringNotBlankRequest extends BaseRequest
{
	@NotNull
	private String value;

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public BaseStringNotBlankRequest(String value)
	{
		this.value = value;
	}
}
