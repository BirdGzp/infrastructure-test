package com.moon.infrastructure.redis.cache;

import java.lang.annotation.*;

/**
 * @Author: zhipeng gong
 * @Date: 2018/12/17 19:20
 * @Description:
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RedisEvit {
}