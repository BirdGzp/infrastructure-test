package com.moon.infrastructure.util;

import org.apache.commons.lang3.StringUtils;


public class StringBuilderUtil
{
	/** 默认分隔符 */
	public static final String DEFAULT_SPLIT = "|";

	public static StringBuilder appendString(StringBuilder stringBuilder, String appendString)
	{
		return appendStringWithSplit(stringBuilder, appendString, DEFAULT_SPLIT);
	}

	/**
	 * 根据指定的分隔符添加字符串
	 * @param stringBuilder
	 * @param appendString
	 * @param split
	 * @return
	 */
	public static StringBuilder appendStringWithSplit(StringBuilder stringBuilder, String appendString, String split)
	{
		if (StringUtils.isBlank(appendString))
		{
			return stringBuilder == null ? new StringBuilder() : stringBuilder;
		}
		if (stringBuilder == null)
		{
			stringBuilder = new StringBuilder();
		}
		if (StringUtils.isBlank(split))
		{
			split = DEFAULT_SPLIT;
		}

		if (stringBuilder.length() <= 0)
		{
			stringBuilder.append(appendString);
		}
		else
		{
			stringBuilder.append(split).append(appendString);
		}

		return stringBuilder;
	}
}
