package step01_AOP_XML;

public class UserService {

    public String testHello() {
        System.out.println("UserService testHello() method invoked..");
        try {
            Thread.sleep(1500);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }

        return "Hello, this is UserService Class";
    }

    public void insertHello(int i, int j) {
        System.out.println("insertHello(int i, int j) method invoked..");
        try {
            Thread.sleep(2000);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }


}
