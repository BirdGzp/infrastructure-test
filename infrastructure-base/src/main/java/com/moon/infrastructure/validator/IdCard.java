package com.moon.infrastructure.validator;


import com.moon.infrastructure.validator.constraints.IdCardValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <p>
 *     length = 18 则只判断是否为合法18位证件
 *     不传，则会检查15或18位长度的证件
 *		length = 15, 会转换成18位进行校验
 * </p>
 *
 * @Title IdCard
 * @Description 身份证校验标签
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { IdCardValidator.class })
public @interface IdCard
{
	String message() default "身份证号格式错误";

	/** 允许为空 */
	boolean allowNull() default true;

	/** 指定验证长度 （比如 length=18，该处证件号只允许为18位） */
	int length() default 0;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/**
	 * Defines several {@code @IdCard} annotations on the same element.
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List
	{
		IdCard[] value();
	}
}