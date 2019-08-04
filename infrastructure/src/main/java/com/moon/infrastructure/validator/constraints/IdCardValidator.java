package com.moon.infrastructure.validator.constraints;

import com.moon.infrastructure.util.IdentityUtil;
import com.moon.infrastructure.validator.IdCard;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdCardValidator implements ConstraintValidator<IdCard, String>
{

	private int length;

	private boolean allowNull;
	/**
	 * Initializes the validator in preparation for
	 * {@link #isValid(Object, ConstraintValidatorContext)} calls.
	 * The constraint annotation for a given constraint declaration
	 * is passed.
	 * <p/>
	 * This method is guaranteed to be called before any use of this instance for
	 * validation.
	 *
	 * @param constraintAnnotation annotation instance for a given constraint declaration
	 */
	@Override
	public void initialize(IdCard constraintAnnotation) {
		length = constraintAnnotation.length();
		allowNull = constraintAnnotation.allowNull();
	}

	/**
	 * Implements the validation logic.
	 * The state of {@code value} must not be altered.
	 * <p/>
	 * This method can be accessed concurrently, thread-safety must be ensured
	 * by the implementation.
	 *
	 * @param value   object to validate
	 * @param context context in which the constraint is evaluated
	 * @return {@code false} if {@code value} does not pass the constraint
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context)
	{
		if (allowNull && StringUtils.isBlank(value))
		{
			return true;
		}
		if (value == null || (value.length() != 18 && value.length() != 15))
		{
			return false;
		}
		if (length == 18){
			return IdentityUtil.verify18(value);
		}
		return IdentityUtil.verify(value);
	}
}
