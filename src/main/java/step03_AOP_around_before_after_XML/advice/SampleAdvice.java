package step03_AOP_around_before_after_XML.advice;

import org.aspectj.lang.JoinPoint;

//here, lets learn about all four methods of AOP aspect oriented programming
public class SampleAdvice {

    /*
        AOP : before
     */
     public void before(JoinPoint joinPoint) {
        //호출될 메소드(joinPoint) 의 인수를 가져오기
        String methodName = joinPoint.getSignature().getName();

        Object[] params = joinPoint.getArgs();
         System.out.println(methodName + " has parameters : count - " + params.length);
         if(params.length > 0) {
             for(Object o : params) {
                 System.out.println(methodName + "'s parameter : " + o);
             }
         }

         System.out.println(methodName + " method will run after this ... \n");

     }

    /*
        AOP : after-returning
            (after the JoinPoint method is processed successfully)

        @param : Object obj <- contains the result of the joinPoint method
    */
    public void afterReturning(JoinPoint joinPoint, Object obj) {
        String methodName = joinPoint.getSignature().getName();

        System.out.println(methodName + "'s return value : " + obj);
        System.out.println(methodName + " is processing after-returning w/o exception...");
    }

    /*
        AOP : after-throwing

                runs when an exception occurs as an exception occurs from the main logic method
        @param : to use error message during joinPoint 's method, insert Throwable e as a param
    */
    public void afterThrowing(Throwable e) {
        System.out.println("The Exception : " + e);
        System.out.println("After-Throwing is processing due to an exception(s)");
    }

    /*
        AOP : after
        runs no matter what results may come, exceptions or not
    */
    public void afterFinally() {
        System.out.println("After is processing disregarding exceptions if there is any");
    }

}
