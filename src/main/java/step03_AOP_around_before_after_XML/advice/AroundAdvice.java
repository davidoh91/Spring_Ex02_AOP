package step03_AOP_around_before_after_XML.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {

    /*
        AOP : around method (before + after processing)

        needs a special JoinPoint instance as a param (because it needs to return the target method's result back)
     */
     public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("AOP : around pre-processing...");

        Object obj = joinPoint.proceed();

        System.out.println("AOP : around post-processing...");

        return obj;
     }

}
