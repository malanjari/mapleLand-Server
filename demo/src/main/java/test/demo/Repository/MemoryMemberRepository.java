package test.demo.Repository;

import test.demo.Member;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryMemberRepository implements MemberRepository {


    private static Map<Long, Member> members = new ConcurrentHashMap<>();



    @Override
    public void save(Member member) {
        members.put(member.getId(), member);
    }

    @Override
    public Member findByMemberId(Long memberId) {
        return members.get(memberId);
    }
}
