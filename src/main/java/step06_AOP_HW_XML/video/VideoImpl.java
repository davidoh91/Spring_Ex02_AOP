package step06_AOP_HW_XML.video;

import step06_AOP_HW_XML.service.Player;

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
