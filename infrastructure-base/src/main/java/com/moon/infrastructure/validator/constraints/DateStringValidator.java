package com.moon.infrastructure.validator.constraints;

import com.moon.infrastructure.validator.DateString;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateStringValidator implements ConstraintValidator<DateString, String>
{
	private String format;

	private boolean allowNull;

	@Override
	public void initialize(DateString constraintAnnotation)
	{
		allowNull = constraintAnnotation.allowNull();
		format = constraintAnnotation.format();
	}

	@Override
	public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext)
	{
		try
		{
			if (allowNull && StringUtils.isBlank(s))
			{
				return true;
			}
			if (StringUtils.isBlank(s))
			{
				return false;
			}
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			return simpleDateFormat.parse(s) != null;
		}
		catch (ParseException e)
		{
			return false;
		}
	}
}
