package com.moon.infrastructure.base;


public class ToStringObject
{
	@Override
	public String toString()
	{
		return CustomReflectionToStringBuilder.customToString(this);
	}
}
