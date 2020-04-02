package com.moon.infrastructure.util;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.moon.infrastructure.logger.Logger;
import com.moon.infrastructure.logger.LoggerFactory;

public class IdentityUtil
{
	private static Logger log = LoggerFactory.getLogger(IdentityUtil.class);
	// wi =2(n-1)(mod 11) 
	private final static int[] wi =
	{ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 };
	// verify digit 
	private final static int[] vi =
	{ 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 };

	private final static String LAKALA_REAL_NAME_REGEX = "^[\u2E80-\uFE4F·]{2,20}(?<!·)$";


	private static Map<String,String> provinceMap = new HashMap<String,String>();
	static 
	{
		provinceMap.put("11", "北京");
		provinceMap.put("12", "天津");
		provinceMap.put("13", "河北");
		provinceMap.put("14", "山西");
		provinceMap.put("15", "内蒙古");
		provinceMap.put("21", "辽宁");
		provinceMap.put("22", "吉林");
		provinceMap.put("23", "黑龙江");
		provinceMap.put("31", "上海");
		provinceMap.put("32", "江苏");
		provinceMap.put("33", "浙江");
		provinceMap.put("34", "安徽");
		provinceMap.put("35", "福建");
		provinceMap.put("36", "江西");
		provinceMap.put("37", "山东");
		provinceMap.put("41", "河南");
		provinceMap.put("42", "湖北");
		provinceMap.put("43", "湖南");
		provinceMap.put("44", "广东");
		provinceMap.put("45", "广西");
		provinceMap.put("46", "海南");
		provinceMap.put("50", "重庆");
		provinceMap.put("51", "四川");
		provinceMap.put("52", "贵州");
		provinceMap.put("53", "云南");
		provinceMap.put("54", "西藏");
		provinceMap.put("61", "陕西");
		provinceMap.put("62", "甘肃");
		provinceMap.put("63", "青海");
		provinceMap.put("64", "宁夏");
		provinceMap.put("65", "新疆");
		provinceMap.put("71", "台湾");
		provinceMap.put("81", "香港");
		provinceMap.put("82", "澳门");
		provinceMap.put("91", "国外");
	}
	
	private IdentityUtil()
	{
	}

	//verify 
	public static boolean verify(String idcard)
	{
		if(StringUtils.isBlank(idcard))
		{
			return false;
		}
		if (idcard.length() == 15)
		{
			//added by hzjiangxue,增加对非数字字符的判断
			if (!StringUtils.isNumeric(idcard))
			{
				return false;
			}
			idcard = uptoeighteen(idcard);
		}
		return verify18(idcard);
	}

	/**
	 * 只支持18位身份证
	 * @param idcard
	 * @return
	 * boolean
	 *
	 */
	public static boolean verify18(String idcard)
	{
		if(StringUtils.isBlank(idcard))
		{
			return false;
		}
		if (idcard.length() != 18)
		{
			return false;
		}
		//判断前两位省份是否正确 
		if(provinceMap.get(idcard.substring(0, 2)) == null || "".equals(provinceMap.get(idcard.substring(0, 2))))
		{
			return false;
		}
		//added by hzjiangxue,增加对非数字字符的判断(排除18位身份证最后一位是X的情况)
		if (!StringUtils.isNumeric(idcard.substring(0, idcard.length() - 1)))
		{
			return false;
		}
		String verify = idcard.substring(17, 18);
		if (verify.equalsIgnoreCase(getVerify(idcard)))
		{
			return true;
		}
		return false;
	}

	//get verify 
	private static String getVerify(String eightcardid)
	{
		int[] ai = new int[18];
		int remaining = 0;
		if (eightcardid.length() == 18)
		{
			eightcardid = eightcardid.substring(0, 17);
		}
		if (eightcardid.length() == 17)
		{
			int sum = 0;
			for (int i = 0; i < 17; i++)
			{
				String k = eightcardid.substring(i, i + 1);
				ai[i] = Integer.parseInt(k);
			}
			for (int i = 0; i < 17; i++)
			{
				sum = sum + wi[i] * ai[i];
			}
			remaining = sum % 11;
		}
		return remaining == 2 ? "X" : String.valueOf(vi[remaining]);
	}

	//15 update to 18 
	public static String uptoeighteen(String fifteencardid)
	{
		String eightcardid = fifteencardid.substring(0, 6);
		eightcardid = eightcardid + "19";
		eightcardid = eightcardid + fifteencardid.substring(6, 15);
		eightcardid = eightcardid + getVerify(eightcardid);
		return eightcardid;
	}
	
	/**
	 * 判断两个身份证是否符合升位规律
	 * @return
	 */
	public static boolean isMatch(String oldIdentityNo, String newIdentityNo)
	{
		if (StringUtils.isEmpty(oldIdentityNo) || StringUtils.isEmpty(newIdentityNo))
			return false;
		if (StringUtils.equalsIgnoreCase(oldIdentityNo, newIdentityNo))
			return true;
		if(oldIdentityNo.length()>newIdentityNo.length())
		{
			return isMatch(newIdentityNo, oldIdentityNo);
		}
		if (oldIdentityNo.length() == 15
				&& newIdentityNo.length() == 18
				&& StringUtils.equalsIgnoreCase(uptoeighteen(oldIdentityNo).substring(0, 14),
						newIdentityNo.substring(0, 14)))
		{
			return true;
		}
		return false;
	}

	/**
	 * 从身份证获取性别
	 * @param identityNo
	 * @return 1：男，0：女
	 */
	public static int getSex(String identityNo)
	{
		try
		{
			if (identityNo.length() == 15)
			{
				identityNo = uptoeighteen(identityNo);
			}
			return Integer.valueOf(identityNo.substring(16, 17)) % 2;
		}catch(Exception e)
		{
			log.warn("身份证获取性别异常。cardNo:" + identityNo, e);
		}
		return 1; 
	}

	/**
	 * 计算身份证的有效期
	 *  ● 46周岁以上，默认为长期
		● 26周岁—45周岁（含45周岁），有效期至其45周岁那年，不论到期日是否在2020年后，系统必须设定为2020年后(不到2020年的加5年)，用户可修改，以用户修改为准
		● 16周岁—25周岁（含25周岁），有效期至其25周岁那年，不论到期日是否在2020年后，系统必须设定为2020年后(不到2020年的加5年)，用户可修改，以用户修改为准
	 * @param identityNo
	 * @return null 表示长期，否则为到期时间
	 */
	public static Timestamp calculateDefaultValidDate(String identityNo)
	{
		try
		{
			if (identityNo.length() == 15)
			{
				identityNo = uptoeighteen(identityNo);
			}
			Timestamp minTime = DateUtil.formatToTimestamp("20200101", DateUtil.FMT_DATE_SPECIAL);
			Timestamp now = DateUtil.getCurrentTimestamp();
			Timestamp birthTime = DateUtil.formatToTimestamp(identityNo.substring(6, 14), DateUtil.FMT_DATE_SPECIAL);
			if (now.after(DateUtil.getIntervalYear(birthTime, 45)))
			{
				return null;
			}
			else if (now.after(DateUtil.getIntervalYear(birthTime, 25)))
			{
				Timestamp endTime = DateUtil.getIntervalYear(birthTime, 45);
				return endTime.before(minTime) ? DateUtil.getIntervalYear(endTime, 5) : endTime;
			}
			else if (now.after(DateUtil.getIntervalYear(birthTime, 16)))
			{
				Timestamp endTime = DateUtil.getIntervalYear(birthTime, 25);
				return endTime.before(minTime) ? DateUtil.getIntervalYear(endTime, 5) : endTime;
			}
			else
			{
				log.warn("不满16周岁的身份证");
				return null;
			}
		}
		catch (Exception e)
		{
			log.warn("计算身份证到期时间异常。cardNo:" + identityNo, e);
		}
		return null;
	}

}
