package test.demo.Repository;

import test.demo.Member;

public interface MemberRepository {

    public void save(Member member);
    Member findByMemberId(Long memberId);


}
