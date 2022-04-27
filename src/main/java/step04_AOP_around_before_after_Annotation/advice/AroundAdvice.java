package step04_AOP_around_before_after_Annotation.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service //id="aroundAdvice"
@Aspect
@Order(1)
public class AroundAdvice {

    /*
        AOP : around method (before + after processing)

        needs a special JoinPoint instance as a param (because it needs to return the target method's result back)
     */
    //@Around("execution(public * step04_AOP_around_before_after_Annotation.*Impl.*(..))")
     @Around("PointCutClass.aa()")
     public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("AOP : around pre-processing...");

        Object obj = joinPoint.proceed();

        System.out.println("AOP : around post-processing...");

        return obj;
     }

}
