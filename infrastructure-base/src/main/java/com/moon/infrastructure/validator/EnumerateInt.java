package com.moon.infrastructure.validator;

import com.moon.infrastructure.validator.constraints.EnumerateIntValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <p></p>
 *
 * @Title EnumerateInteger
 * @Description Int枚举值限定
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { EnumerateIntValidator.class })
public @interface EnumerateInt
{
	String message() default "参数值不在限定范围内";

	int[] enumValue();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/**
	 * Defines several {@code @EnumerateInt} annotations on the same element.
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List
	{
		EnumerateInt[] value();
	}
}
