package step04_AOP_around_before_after_Annotation.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import step04_AOP_around_before_after_Annotation.service.MemberService;

public class MainApp {
    public static void main(String[] args) {

        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/step04_AOP_around_before_after_Annotation/main/applicationContext.xml");

        MemberService service = context.getBean("target", MemberService.class);
        System.out.println("===========================");
        service.insert();

        System.out.println("===========================");
        service.select(99);

        System.out.println("===========================");
        service.update("dave-id55", "dave55");



    }
}
