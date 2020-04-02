package com.moon.infrastructure.util;

import com.moon.infrastructure.logger.Logger;
import com.moon.infrastructure.logger.LoggerFactory;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

public class Base64Util
{
	private static final Logger log = LoggerFactory.getLogger(Base64Util.class);

	private static final String DEFAULT_ENCODE = "UTF-8";

	public static String decodeBase64(String message)
	{
		return decodeBase64(message, DEFAULT_ENCODE);
	}

	public static String decodeBase64(String message, String encode)
	{
		String result;
		try
		{
			byte[] base64Message = Base64.decodeBase64(message);
			result = new String(base64Message, DEFAULT_ENCODE);
			return result;
		}
		catch (IOException e)
		{
			log.error("decode fail,message:" + message, e);
		}
		return StringUtils.EMPTY;
	}

	public static String encodeBase64(String message)
	{
		return encodeBase64(message, DEFAULT_ENCODE);
	}

	public static String encodeBase64(String message, String encode)
	{
		String result;
		try
		{
			result = Base64.encodeBase64String(message.getBytes(encode)).replaceAll("\r|\n", "");
			return result;
		}
		catch (Exception e)
		{
			log.error("encode fail,message:" + message, e);
		}
		return StringUtils.EMPTY;
	}

	public static String encodeBase64Bytes(byte[] bytes)
	{
		String result;
		try
		{
			result = Base64.encodeBase64String(bytes).replaceAll("\r|\n", "");
			return result;
		}
		catch (Exception e)
		{
			log.error("encode fail", e);
		}
		return StringUtils.EMPTY;
	}
}
