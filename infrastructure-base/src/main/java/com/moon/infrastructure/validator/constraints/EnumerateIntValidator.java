package com.moon.infrastructure.validator.constraints;

import com.moon.infrastructure.validator.EnumerateInt;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;


public class EnumerateIntValidator implements ConstraintValidator<EnumerateInt, Integer>
{

	private Set<Integer> set;

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
	public void initialize(EnumerateInt constraintAnnotation)
	{
		set = new HashSet();
		int[] elements = constraintAnnotation.enumValue();
		for (int i = 0, size = elements.length; i < size; i++)
		{
			set.add(elements[i]);
		}
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
	public boolean isValid(Integer value, ConstraintValidatorContext context)
	{
		return set.contains(value);
	}

}
