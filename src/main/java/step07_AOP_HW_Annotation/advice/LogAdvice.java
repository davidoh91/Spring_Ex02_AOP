package step07_AOP_HW_Annotation.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.io.FileWriter;
import java.io.IOException;

@Service //bean id="logAdvice"
@Aspect
//@Order(1);
public class LogAdvice {

    public static FileWriter fw;

    public LogAdvice() throws IOException {
        System.out.println("running LogAdvice constructor..");

        //init FileWriter instance
        fw = new FileWriter("C:\\Users\\computer\\Desktop\\logInfo.txt");
        System.out.println("************" + fw);
    }

    @Around("execution(public * step07_AOP_HW_Annotation.*.*Impl.*(..))") //<aop:pointcut id="pointCut" expression="execution(public * step07_AOP_HW_Annotation.*.*Impl.*(..))"/>
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("running LogAdvice.around(ProceedingJoinPoint joinPoint)..");

        //1. before - use Spring StopWatch class .start(), .stop(), .gettotalmili..()
        // to measure the execution time of joinpoint method
        System.out.println("LogAdvice logging started..");
        StopWatch sw = new StopWatch();
        sw.start();

        //2. run target - run joinpoint method
        Object obj = joinPoint.proceed();


        //3. after
        /*
            - generate log file
            - return obj (the result of joinpoint method)

           method name : joinPoint.getSignature().getName()
           param count : joinPoint.getArgs().length
           method result : obj

           use fw.write(String + "\n") to log
           fw.close() to close FileWriter
         */
        sw.stop();

        String methodName = joinPoint.getSignature().getName();
        int paramCount = joinPoint.getArgs().length;
        long execTime = sw.getTotalTimeMillis();

        fw.write(methodName+"호출" + "/ 인수 개수 : " + paramCount + "/" + "리턴 값 : " + obj + " / 총 실행시간 : " + execTime + "ms\n");

        //fw.close(); << where to close the file writer..??

        System.out.println("LogAdvice logging ended..");
        System.out.println("-------------------");

        return obj;
    }

}
