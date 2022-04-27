package step07_AOP_HW_Annotation.video;

import org.springframework.stereotype.Service;
import step07_AOP_HW_Annotation.service.Player;

@Service //bean id="videoImpl"
public class VideoImpl implements Player {
    @Override
    public void start(int volumn) {
        System.out.println("running VideoImpl start(int volumn)..");
    }

    @Override
    public String pause() {
        System.out.println("running VideoImpl pause()..");
        return "VideoImpl return value";
    }

    @Override
    public void stop() {
        System.out.println("running VideoImpl stop()..");
    }
}
