package step06_AOP_HW_XML.tv;

import step06_AOP_HW_XML.service.Player;

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
