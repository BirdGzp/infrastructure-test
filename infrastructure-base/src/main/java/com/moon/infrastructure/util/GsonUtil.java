package com.moon.infrastructure.util;

import java.lang.reflect.Type;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.moon.infrastructure.logger.Logger;
import com.moon.infrastructure.logger.LoggerFactory;

/**
 * gson util

 * @Description:TODO]

 * @date:2016年8月23日
 */
public class GsonUtil
{

	protected final static Logger log = LoggerFactory.getLogger(GsonUtil.class);
	
	protected final static String DEFAULT_ELEMENT_NAME_SPLIT = "\\.";
	
	private static final Gson gson;
	
	private static final Gson gson_date_adapter;
	
	private static final Gson escapingGson;
	
	private static final JsonParser parser;

	static
	{
		gson = new Gson();
		gson_date_adapter = new GsonBuilder().registerTypeAdapter(Date.class, new DateAdapter()).create();
		escapingGson = new GsonBuilder().disableHtmlEscaping().create();
		parser = new JsonParser();
	}

	/**
	 * 对象转json
	 * @param src
	 * @return
	 */
	public static String toJson(Object src)
	{
		return gson.toJson(src);
	}


	/**
	 * 对象转json
	 * @param src
	 * @return
	 */
	public static String toJsonEscaping(Object src)
	{
		return escapingGson.toJson(src);
	}

	/**
	 * json转对象
	 * @param json
	 * @param classOfT
	 * @return
	 */
	public static <T> T fromJson(String json, Class<T> classOfT)
	{
		return gson.fromJson(json, classOfT);
	}

	public static <T> T fromJson(JsonElement element, Class<T> classOfT)
	{
		return gson.fromJson(element, classOfT);
	}
	
	/**
	 * json转对象
	 * @param json
	 * @param typeOfT
	 * @return
	 */
	public static <T> T fromJson(String json, Type typeOfT)
	{
		return gson.fromJson(json, typeOfT);
	}

	public static String getJsonElementValue(String json, String elementName, String elementNameSplit)
	{
		if (StringUtils.isEmpty(elementName) || StringUtils.isEmpty(json))
		{
			return null;
		}
		if (StringUtils.isEmpty(elementNameSplit))
		{
			elementNameSplit = DEFAULT_ELEMENT_NAME_SPLIT;
		}
		String[] elementNameArray = elementName.split(elementNameSplit);

		//基本名称jianc
		for (String tempName : elementNameArray)
		{
			if (StringUtils.isEmpty(tempName))
			{
				log.error("Json element name empty! 请检查，elementName:" + elementName);
				return null;
			}
		}

		JsonObject jsonObject = fromJson(json, JsonObject.class);
		if (jsonObject == null)
		{
			return null;
		}
		int len = elementNameArray.length;
		JsonElement jsonElement = null;

		//迭代key 获取属性
		for (int i = 0; i < len; i++)
		{
			jsonElement = jsonObject.get(elementNameArray[i]);
			if (jsonElement == null)
			{
				log.error("Json element name note exist! 请检查，elementName:" + elementName + ",note exist element name:"
						+ elementNameArray[i]);
				return null;
			}
			
			if (jsonElement.isJsonObject())//非最后一层，继续循环
			{
				jsonObject = jsonElement.getAsJsonObject();
				continue;
			}
			else
			//最后一层，直接获取原始值
			{
				return jsonElement.getAsString();
			}
		}
		return null;
	}
	
	
	public static <T> T fromJson(String json, String memberName, Class<T> clazz)
	{
		JsonObject jsonObject = parser.parse(json).getAsJsonObject();
		return gson.fromJson(jsonObject.get(memberName), clazz);
	}
	
	private static class DateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date>
	{

		@Override
		public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException
		{
			if(null != json)
			{
				Date date = new Date();
				date.setTime(json.getAsLong());
				return date;
			}
			return null;
		}

		@Override
		public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context)
		{
			if (null != src)
			{
				return new JsonPrimitive(src.getTime());
			}
			return null;
		}
	}

	public static Gson getGsonDateAdapter()
	{
		return gson_date_adapter;
	}

	public static boolean isGoodJson(String json) {
		if (StringUtils.isBlank(json)) {
			return false;
		}
		try {
			parser.parse(json);
			return true;
		} catch (JsonParseException e) {
			return false;
		}
	}

}
