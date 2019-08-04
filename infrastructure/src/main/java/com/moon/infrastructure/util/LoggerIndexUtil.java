package com.moon.infrastructure.util;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * LoggerIndexUtil
 * 日志脱敏工具
 * */
public class LoggerIndexUtil
{
	protected static String keyFromCode = "LOYIIG4H>,IF;Zklc%5uJGo0Z@JVe1t5IHx5";

	private static final String STAR = "*";

	public static String getStar(int num)
	{
		if (num <= 0)
		{
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for (; num > 0; num--)
		{
			sb.append(STAR);
		}
		return sb.toString();
	}

	public static String desensitization(String source)
	{
		StringBuffer newSource = new StringBuffer();
		int length = source.length();
		if (length >= 3)
		{
			newSource.append(source.substring(0, 1)).append(getStar(length - 2))
					.append(source.substring(length - 1));
		}
		else
		{
			return source;
		}
		return newSource.toString();
	}

	/**
	 * 生成隐私字段查询用的索引字段
	 * @param plainText
	 * @return
	 */
	public static String generateIndex(String plainText)
	{
		if (StringUtils.isBlank(plainText))
		{
			return plainText;
		}
		return getMd5(plainText + keyFromCode).toLowerCase();
	}

	public static String getMd5(String s)
	{
		return getMd5(s, "utf-8");
	}

	public static String getMd5(String s, String encode)
	{
		return generateDigest("MD5", s, encode);
	}

	private static String generateDigest(String algorithm, String s, String encode)
	{
		byte abyte0[] = null;
		MessageDigest messagedigest;
		try
		{
			messagedigest = MessageDigest.getInstance(algorithm);
		}
		catch (NoSuchAlgorithmException nosuchalgorithmexception)
		{
			throw new IllegalArgumentException("no " + algorithm + " support");
		}
		try
		{
			messagedigest.update(s.getBytes(encode));
		}
		catch (UnsupportedEncodingException e)
		{
			throw new RuntimeException(e);
		}
		abyte0 = messagedigest.digest();
		return byte2hex(abyte0);
	}

	public static String byte2hex(byte abyte0[])
	{
		StringBuffer stringbuffer = new StringBuffer(abyte0.length * 2);
		for (int i = 0; i < abyte0.length; i++)
		{
			if ((abyte0[i] & 0xff) < 16)
			{
				stringbuffer.append("0");
			}
			stringbuffer.append(Long.toString((long) abyte0[i] & (long) 255, 16));
		}

		return stringbuffer.toString().toUpperCase();
	}

}
