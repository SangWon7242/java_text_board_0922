package sbs.com.java.board.member.service;

import sbs.com.java.board.container.Container;
import sbs.com.java.board.member.repository.MemberRepository;

public class MemberService {
    private MemberRepository memberRepository;

    public MemberService() {
        memberRepository = Container.memberRepository;
    }

    public void join(String loginId, String loginPw, String name) {
        memberRepository.join(loginId, loginPw, name);
    }
}
