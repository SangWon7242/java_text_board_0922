package sbs.com.java.board.member.service;

import sbs.com.java.board.container.Container;
import sbs.com.java.board.member.dto.Member;
import sbs.com.java.board.member.repository.MemberRepository;

import java.util.stream.IntStream;

public class MemberService {
    private MemberRepository memberRepository;

    public MemberService() {
        memberRepository = Container.memberRepository;

        makeTestData();
    }

    void makeTestData() {
        IntStream.rangeClosed(1, 3)
                .forEach(i -> join("user" + i, "user" + i, "회원" + i));
    }

    public void join(String loginId, String loginPw, String name) {
        memberRepository.join(loginId, loginPw, name);
    }

    public Member findByLoginId(String loginId) {
        return memberRepository.findByLoginId(loginId);
    }
}
