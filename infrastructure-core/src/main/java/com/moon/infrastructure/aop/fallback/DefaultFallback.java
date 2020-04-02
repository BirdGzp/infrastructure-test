package com.moon.infrastructure.aop.fallback;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DefaultFallback {
}