package com.moon.infrastructure.validator;

import com.moon.infrastructure.validator.constraints.EnumerateStringValidator;

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
 * @Title EnumerateString
 * @Description 字符串枚举值限定
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { EnumerateStringValidator.class })
public @interface EnumerateString
{

	String message() default "参数值不在限定范围内";

	String[] enumValue();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/**
	 * Defines several {@code @EnumerateString} annotations on the same element.
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List
	{
		EnumerateString[] value();
	}
}