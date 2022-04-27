package step04_AOP_around_before_after_Annotation.service;

import org.springframework.stereotype.Service;

@Service("target") //id="target" because it's the AOP target
public class MemberServiceImpl implements MemberService {
    @Override
    public int insert() {
        System.out.println("running MemberServiceImpl insert()");
        return 50;
    }

    @Override
    public String select(int i) {
        System.out.println("running MemberServiceImpl select()");
        return "studying AOP";
    }

    @Override
    public void update(String id, String name) {
        System.out.println("running MemberServiceImpl update()");
    }
}
