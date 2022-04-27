package step07_AOP_HW_Annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import step06_AOP_HW_XML.advice.LogAdvice;
import step06_AOP_HW_XML.service.Player;


public class MainApp {
    public static void main(String[] args) {

        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/step06_AOP_HW_XML/applicationContext.xml");

        /*
            error:
            Bean named 'audioImpl' is expected to be of type 'step06_AOP_HW_XML.audio.AudioImpl' but was actually of type 'com.sun.proxy.$Proxy5'
             *** the interface should be used to receive the proxy object, so as to obtain the proxy object (if an interface exists) ***
         */
        Player audio = context.getBean("audioImpl", Player.class); //<< not AudioImpl.class
        Player tv = context.getBean("tvImpl", Player.class);
        Player video = context.getBean("videoImpl", Player.class);

        try {
            audio.start(10);
            audio.pause();
            audio.stop();

            tv.start(20);
            tv.pause();
            tv.stop();

            video.start(30);
            video.pause();
            video.stop();

            //close the FileWriter instance to complete log file
            LogAdvice.fw.close();

        }catch(Exception e) {
            e.printStackTrace();
        }

    }
}
