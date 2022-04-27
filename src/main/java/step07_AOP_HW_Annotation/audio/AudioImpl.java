package step07_AOP_HW_Annotation.audio;

import org.springframework.stereotype.Service;
import step07_AOP_HW_Annotation.service.Player;

@Service //bean id="audioImpl"
public class AudioImpl implements Player {
    @Override
    public void start(int volumn) {
        System.out.println("running AudioImpl start(int volumn)..");
    }

    @Override
    public String pause() {
        System.out.println("running AudioImpl pause()..");
        return "TvImpl return value";
    }

    @Override
    public void stop() {
        System.out.println("running AudioImpl stop()..");
    }
}
