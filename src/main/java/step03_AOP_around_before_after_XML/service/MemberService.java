package step03_AOP_around_before_after_XML.service;

public interface MemberService {
    public abstract int insert();
    public abstract String select(int i);
    public abstract void update(String id, String name);
}
