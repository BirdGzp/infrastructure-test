package com.moon.infrastructure.util;

import java.util.regex.Pattern;

public class MobilePhoneUtil
{
	public static boolean isMobile(String mobile)
	{
		Pattern p1 = Pattern.compile("^(86|0)?1\\d{10}$");// 验证是数字
		if (mobile == null || mobile.equals(""))
		{
			return false;
		}
		else
		{
			if (p1.matcher(mobile.trim()).matches())
			{
				return true;
			}
			return false;
		}
	}
}
