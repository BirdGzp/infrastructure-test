package com.moon.infrastructure.redis.cache.aop;

import com.moon.infrastructure.logger.Logger;
import com.moon.infrastructure.logger.LoggerFactory;
import com.moon.infrastructure.redis.RedisService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RedisEvitAop {
    Logger log = LoggerFactory.getLogger(RedisEvitAop.class);

    @Autowired
    RedisService redisService;

    @Around(value = "execution(public * com..service.impl..*.update*(..)) && @annotation(com.moon.infrastructure.redis.cache.RedisEvit)")
    public Object rediseEvit(ProceedingJoinPoint proceedingJoinPoint){

        return null;
    }
}