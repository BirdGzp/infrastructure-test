package com.moon.infrastructure.base;

import com.moon.infrastructure.base.annotation.LogIndex;
import com.moon.infrastructure.base.annotation.LogStar;
import com.moon.infrastructure.util.LoggerIndexUtil;
import com.moon.infrastructure.validator.CardNo;
import com.moon.infrastructure.validator.IdCard;
import com.moon.infrastructure.validator.Mobile;
import com.moon.infrastructure.validator.TrueName;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

;

public class CustomReflectionToStringBuilder<T> extends ReflectionToStringBuilder
{
	private static Logger logger = LoggerFactory.getLogger(CustomReflectionToStringBuilder.class);

	public static String customToString(Object object)
	{
		String result = "";
		try
		{
			CustomReflectionToStringBuilder customReflectionToStringBuilder = new CustomReflectionToStringBuilder(object, ToStringStyle.JSON_STYLE);
			result = customReflectionToStringBuilder.toString();
		}
		catch (NoSuchFieldError e)
		{
			CustomReflectionToStringBuilder customReflectionToStringBuilder = new CustomReflectionToStringBuilder(object, ToStringStyle.DEFAULT_STYLE);
			result = customReflectionToStringBuilder.toString();
		}
		catch (Throwable e)
		{
			logger.error("toString执行失败.", e);
		}
		return result;
	}

	@Override
	protected void appendFieldsIn(Class<?> clazz)
	{
		if (clazz.isArray()) {
			this.reflectionAppendArray(this.getObject());
			return;
		}
		final Field[] fields = clazz.getDeclaredFields();
		AccessibleObject.setAccessible(fields, true);
		for (final Field field : fields) {
			final String fieldName = field.getName();
			if (this.accept(field)) {
				try {
					Object fieldValue = this.getValue(field);
					if (field.getAnnotation(LogIndex.class) != null && field.getType() == String.class) {
						fieldValue = LoggerIndexUtil.generateIndex((String) fieldValue);
					}
					else if (field.getAnnotation(LogStar.class) != null && field.getType() == String.class) {
						fieldValue = LoggerIndexUtil.desensitization((String) fieldValue);
					}
					else if (field.getAnnotation(IdCard.class) != null && field.getType() == String.class) {
						fieldValue = LoggerIndexUtil.generateIndex((String) fieldValue);
					}
					else if (field.getAnnotation(Mobile.class) != null && field.getType() == String.class) {
						fieldValue = LoggerIndexUtil.generateIndex((String) fieldValue);
					}
					else if (field.getAnnotation(CardNo.class) != null && field.getType() == String.class) {
						fieldValue = LoggerIndexUtil.generateIndex((String) fieldValue);
					}
					else if (field.getAnnotation(TrueName.class) != null && field.getType() == String.class) {
						fieldValue = LoggerIndexUtil.generateIndex((String) fieldValue);
					}

					this.append(fieldName, fieldValue);
				} catch (final IllegalAccessException ex) {
					throw new InternalError("Unexpected IllegalAccessException: " + ex.getMessage());
				}
			}
		}
	}

	public CustomReflectionToStringBuilder(Object object)
	{
		super(object);
	}

	public CustomReflectionToStringBuilder(Object object, ToStringStyle style)
	{
		super(object, style);
	}

	public CustomReflectionToStringBuilder(Object object, ToStringStyle style,
                                           StringBuffer buffer)
	{
		super(object, style, buffer);
	}

	public CustomReflectionToStringBuilder(T object, ToStringStyle style,
                                           StringBuffer buffer, Class<? super T> reflectUpToClass, boolean outputTransients, boolean outputStatics)
	{
		super(object, style, buffer, reflectUpToClass, outputTransients, outputStatics);
	}
}
