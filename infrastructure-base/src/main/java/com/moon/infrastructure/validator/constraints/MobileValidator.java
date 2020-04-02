package com.moon.infrastructure.validator.constraints;

import com.moon.infrastructure.util.MobilePhoneUtil;
import com.moon.infrastructure.validator.Mobile;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobileValidator implements ConstraintValidator<Mobile, String>
{

	private boolean allowNull;

	@Override
	public void initialize(Mobile constraintAnnotation)
	{
		allowNull = constraintAnnotation.allowNull();
	}

	@Override
	public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext)
	{
		if (allowNull && StringUtils.isBlank(s))
		{
			return true;
		}
		return MobilePhoneUtil.isMobile(s);
	}
}
