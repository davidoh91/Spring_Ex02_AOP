package step02_AOP_Annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

/*
    공통의 기능: 사전 + 사후 처리 (around 방식)

    -사전처리: 현재시간을 구한다.
    -사후처리: 현재시간을 구한다 (사후시간 - 사전시간 = 총 소요시간)

        -JointPoint : 실제타겟 대상의 즉 메소드에 대한 정보를 가져올 수 있는 메소드를 제공한다.
        -ProceedingJoinPoint : JointPoint 의 확장개념으로 메소드에 대한 정보도 제공하고 타겟대상을 .proceed() 로 호출할 수 있는 메소드를 제공한다.
            ^ around 방식에서 사용
                (1) ProceedingJoinPoint 를 around 메소드의 param 으로 입력
                (2) ProceedingJoinPoint 객체의 proceed() 메소드를 호출
                (3) ProceedingJointPoint 객체의 proceed() 메소드 결과값인 Object 를 리턴
 */


@Service("advice") //생성
@Aspect
public class TimerAdvice {

    //<aop:around method="around" pointcut="execution(public * step01_AOP_XML.*Service.*ello(..))"/>
    @Around("execution(public * step01_AOP_XML.*Service.*ello(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName(); //타겟 대상의 메소드 이름을 가져온다

        System.out.println("[LOG] " + methodName + "호출되기전 사전 처리 중...");

        //사전처리
        StopWatch sw = new StopWatch(); //use Spring util to measure time
        sw.start();

        //실제 타겟대상을 호출
        Object obj = joinPoint.proceed();

        //사후처리
        sw.stop();

        System.out.println("[LOG]" + methodName + "의 리턴값 obj = " + obj);
        System.out.println("[LOG]" + methodName + "의 총 실행 ms : " + sw.getTotalTimeMillis());
        System.out.println("[LOG]" + methodName + "의 호출 완료 후 사후 처리완료...\n");

        return obj;

    }

}


