package step04_AOP_around_before_after_Annotation.advice;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
    This class defines PointCut (regex) for AOP JoinPoints methods
 */
public class PointCutClass {
    /*
        PointCut : Logging
     */
    @Pointcut("execution(public * step04_AOP_around_before_after_Annotation.*Impl.*(..))")
    public void aa() {

    }


    /*
        PointCut : Transaction
     */
    @Pointcut("execution(public * step04_AOP_around_before_after_Annotation.*Impl.insert(..))")
    public void bb() {}

     /*
        PointCut : Session
     */
    @Pointcut("execution(public * step04_AOP_around_before_after_Annotation.*Impl.select(..))")
    public void cc() {}

}
