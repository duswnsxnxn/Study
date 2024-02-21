package hello.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Transactional
    @Test
    void memberTest() {
        Member member = new Member("memberA", "hello");
        memberRepository.initTable();
        memberRepository.save(member);

        Member findMember = memberRepository.find("memberA");
        assertEquals(findMember.getMemberId(), member.getMemberId());
        assertEquals(findMember.getName(), member.getName());
    }

}