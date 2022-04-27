package step07_AOP_HW_Annotation.tv;

import org.springframework.stereotype.Service;
import step07_AOP_HW_Annotation.service.Player;

@Service //bean id="tvImpl"
public class TvImpl implements Player {
    @Override
    public void start(int volumn) {
        System.out.println("running TvImpl start(int volumn)..");
    }

    @Override
    public String pause() {
        System.out.println("running TvImpl pause()..");
        return "TvImpl return value";
    }

    @Override
    public void stop() {
        System.out.println("running TvImpl stop()..");
    }
}

