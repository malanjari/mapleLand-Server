package test.demo.Repository;

import test.demo.Member;

import java.util.List;

public interface Repository {

    public void save(Member member);
    public void save(List<Member> members);
}
