package com.moon.infrastructure.util;


import com.esotericsoftware.reflectasm.MethodAccess;
import com.moon.infrastructure.logger.Logger;
import com.moon.infrastructure.logger.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ReflectionUtil
{
	private static Logger logger = LoggerFactory.getLogger(ReflectionUtil.class);

	private static Map<Class, MethodAccess> methodAccessMap = new ConcurrentHashMap<>();


	public static Object executeMethod(Object object, Method method, Object[] params)
	{
		MethodAccess ma = getMethodAccess(object.getClass());
		return ma.invoke(object, method.getName(), method.getParameterTypes(), params);
	}

	public static Object executeMethod(Object object, String methodName, Class[] parameterTypes, Object[] params)
	{
		MethodAccess ma = getMethodAccess(object.getClass());
		return ma.invoke(object, methodName, parameterTypes, params);
	}

	private static MethodAccess getMethodAccess(Class clazz)
	{
		if (methodAccessMap.get(clazz) == null)
		{
			synchronized (clazz)
			{
				if (methodAccessMap.get(clazz) == null)
				{
					MethodAccess ma = MethodAccess.get(clazz);
					methodAccessMap.put(clazz, ma);
				}
			}
		}
		return methodAccessMap.get(clazz);
	}

	/**
	 * 获取指定属性
	 * @param clazz
	 * @param instance
	 * @param fieldName
	 * @return
	 */
	public static Object getSpecificedField(Class clazz, Object instance, String fieldName)
	{
		Object object = null;
		try
		{
			Field field = clazz.getDeclaredField(fieldName);
			field.setAccessible(true);
			object = field.get(instance);
		}
		catch (Exception e)
		{
			logger.error("Reflection get filed excption!", e);
		}
		return object;
	}
}
