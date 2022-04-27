package step01_AOP_XML;

import org.springframework.aop.framework.AopContext;

public class MessageServiceImpl implements MessageService {

    @Override
    public void korHello() {
        System.out.println("MessageServiceImpl korHello() method invoked..");

        System.out.println("@@@@@@@@@@@@@@@@@@@");
        //engHello(); //AOP Proxy Server must directly call engHello() for it to apply advice on it
        System.out.println("@@@@@@@@@@@@@@@@@@@");

        //App ProxyServer가 engHello() 를 호출할 수 있도록 한다.
        MessageService service = (MessageService)AopContext.currentProxy();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void engHello() {
        System.out.println("MessageServiceImpl engHello() method invoked..");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String hello() {
        System.out.println("MessageServiceImpl hello() method invoked..");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello() success";
    }

    @Override
    public int hello(String name) {
        System.out.println("MessageServiceImpl hello(String name) method invoked..");
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
