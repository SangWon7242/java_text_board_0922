package sbs.com.java.board.member.controller;

import sbs.com.java.board.container.Container;
import sbs.com.java.board.member.service.MemberService;

import java.util.Scanner;

public class MemberController {
  private MemberService memberService;
  private Scanner scanner;

  public MemberController() {
    memberService = Container.memberService;
    scanner = Container.scanner;
  }

  public void doJoin() {
    String loginId;
    String loginPw;
    String loginPwConfirm;
    String name;

    System.out.println("== 회원 가입 ==");

    // 로그인 아이디
    while (true) {
      System.out.print("로그인 아이디 : ");
      loginId = scanner.nextLine();

      if (loginId.trim().isEmpty()) {
        System.out.println("로그인 아이디를 입력해주세요.");
        continue;
      }

      break;
    }

    // 로그인 패스워드
    while (true) {
      System.out.print("로그인 패스워드 : ");
      loginPw = scanner.nextLine();

      if(loginPw.trim().isEmpty()) {
        System.out.println("비밀번호를 입력해주세요.");
        continue;
      }

      while (true) {
        System.out.print("비밀번호 확인 : ");
        loginPwConfirm = scanner.nextLine();

        if(loginPwConfirm.trim().isEmpty()) {
          System.out.println("비밀번호 확인을입력해주세요.");
          continue;
        }

        if(!loginPwConfirm.equals(loginPw)) {
          System.out.println("비밀번호가 틀렸습니다. 다시 확인해주세요.");
          continue;
        }

        break;
      }

      break;
    }

    // 이름
    while (true) {
      System.out.print("이름 : ");
      name = scanner.nextLine();

      if (name.trim().isEmpty()) {
        System.out.println("이름 입력해주세요.");
        continue;
      }

      break;
    }

    memberService.join(loginId, loginPw, name);

    System.out.println("회원 가입 되었습니다.");
  }
}
