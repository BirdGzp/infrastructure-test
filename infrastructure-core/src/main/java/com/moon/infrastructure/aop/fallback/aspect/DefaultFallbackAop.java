package com.moon.infrastructure.aop.fallback.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.moon.infrastructure.logger.Logger;
import com.moon.infrastructure.logger.LoggerFactory;


@Aspect
@Component
public class DefaultFallbackAop {
    Logger log = LoggerFactory.getLogger(DefaultFallbackAop.class);

    @Around(value = "execution(public * com..feign..fallback..*.*(..))&& @annotation(com.moon.infrastructure.aop.fallback.DefaultFallback)")
    public Object defaultFallback(ProceedingJoinPoint proceedingJoinPoint) {
        Signature signature = proceedingJoinPoint.getSignature();
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        if (result != null) {
            return result;
        }
        Object[] args = proceedingJoinPoint.getArgs();
        StringBuilder stringBuilder = null;
        if (args != null && args.length > 0) {
            //拿到service 名字的前缀——POJO对象名
            stringBuilder = new StringBuilder(signature.getDeclaringTypeName() + "#" + signature.getName() + " : ");
            for (Object object : args) {
                stringBuilder.append(" ").append(object);
            }
        }
        log.error(" 远程调用接口执行失败" + stringBuilder.toString());


        return result;
    }
}