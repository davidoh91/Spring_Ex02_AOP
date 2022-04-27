package step02_AOP_Annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {

        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/step01_AOP/applicationContext.xml");

        //get MessageServiceImpl bean via interface, MessageService
        /*
           AOP Proxy Server 는 J2SE 방식으로 서버를 생성한다 :
            - "interface의 구현객체를 joinPoint 대상으로 설정할 때
               반드시 interface를 통해 타겟대상을 호출해야한다는 규칙"

           하지만, J2SE 방식을 CGLIB 방식으로 변경을 하면 interface 기반 또는
           구현객체를 통해 호출을 해도 에러가 나지 않는다.
         */
        MessageService service = context.getBean("target", MessageService.class);

        System.out.println("----------------------");
        service.korHello();

        System.out.println("----------------------");
        service.engHello();

        System.out.println("----------------------");
        String resultStr = service.hello();
        System.out.println("result : " + resultStr);


        System.out.println("----------------------");
        int resultInt = service.hello("dave");
        System.out.println("result : " + resultInt);


        System.out.println("======================");
        UserService service2 = context.getBean("service", UserService.class);
        String resultStr2 = service2.testHello();
        System.out.println("result = " + resultStr2);
        service2.insertHello(99, 55);


        System.out.println("======================");


    }
}
