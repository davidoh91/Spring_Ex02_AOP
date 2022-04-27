package step06_AOP_HW_XML.audio;

import step06_AOP_HW_XML.service.Player;

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
