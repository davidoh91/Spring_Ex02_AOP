package step03_AOP_around_before_after_XML.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import step03_AOP_around_before_after_XML.service.MemberService;

public class MainApp {
    public static void main(String[] args) {

        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/step03_AOP_around_before_after_/main/applicationContext.xml");

        MemberService service = context.getBean("target", MemberService.class);
        System.out.println("===========================");
        service.insert();

        System.out.println("===========================");
        service.select(99);

        System.out.println("===========================");
        service.update("dave-id55", "dave55");



    }
}
