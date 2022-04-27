package step04_AOP_around_before_after_Annotation.service;

public interface MemberService {
    public abstract int insert();
    public abstract String select(int i);
    public abstract void update(String id, String name);
}
