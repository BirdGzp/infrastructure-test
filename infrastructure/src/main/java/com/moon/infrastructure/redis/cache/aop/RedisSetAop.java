package com.moon.infrastructure.redis.cache.aop;

import com.alibaba.fastjson.JSON;
import com.moon.infrastructure.redis.RedisService;
import com.moon.infrastructure.util.FastJsonUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Type;


/**
 * @Author: zhipeng gong
 * @Date: 2018/12/17 19:21
 * @Description: Redis查询缓存切面
 */
@Aspect
@Component
public class RedisSetAop {
    Logger log = LoggerFactory.getLogger(RedisSetAop.class);

    /** redis中保存的时间 */
    public static final long EXPIRE = 1000 * 60;

    /** 空对象 */
    private final static Object NULL_OBJECT = new Object();

    @Autowired
    RedisService redisService;

    @Around("@annotation(com.moon.infrastructure.redis.cache.RedisSet)")
    public Object redisSet(ProceedingJoinPoint proceedingJoinPoint){
        Signature signature = proceedingJoinPoint.getSignature();
        Object[] args = proceedingJoinPoint.getArgs();

        /** 生成缓存的key */
        String key = generateKey(signature, args);
        System.out.println("generateKey:" + key);

        Object cacheResult = redisService.getValue(key);
        //redis 不存在值,执行方法，拿到值，并缓存起来
        if(cacheResult == null){
            Object methodResult  = null;
            try {
                //执行方法
                methodResult = proceedingJoinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }

            //数据库不存在, 避免缓存穿透
            if(methodResult == null){
                log.info("redis 中不存在， 查询数据库返回结果，且查询结果为 null");
                redisService.setValue(key, FastJsonUtil.toJSONString(NULL_OBJECT), EXPIRE);
                    return methodResult;
            }

            log.info("redis 中不存在，数据库存在查询结果");
            redisService.setValue(key, JSON.toJSONString(methodResult), EXPIRE);
            return methodResult;
        }

        log.info("redis 中命中结果");
        System.out.println(JSON.parse(cacheResult.toString()).toString());
        return JSON.parse(cacheResult.toString());
    }

    private String generateKey(Signature signature, Object ... args){
        //拿到service 名字的前缀——POJO对象名
        StringBuilder stringBuilder = new StringBuilder(signature.getDeclaringTypeName());
        stringBuilder.append("_").append(signature.getName());
        for(Object object:args) {
            stringBuilder.append("_").append(object);
        }
        return stringBuilder.toString();
    }

}
