package sbs.com.java.board;

import sbs.com.java.board.article.controller.ArticleController;
import sbs.com.java.board.container.Container;
import sbs.com.java.board.member.controller.MemberController;
import sbs.com.java.board.member.dto.Member;
import sbs.com.java.board.session.Session;

import java.util.Scanner;

public class App {
  public ArticleController articleController;
  public MemberController memberController;

  public App() {
    articleController = Container.articleController;
    memberController = Container.memberController;
  }

  void run() {
    Scanner sc = Container.scanner;

    System.out.println("== 텍스트 게시판 ==");
    System.out.println("== 게시판을 시작합니다. ==");

    while (true) {
      Session session = Container.session;

      Member loginedMember = (Member) session.getAttribute("loginedMember");

      String promptName = "명령어";

      if(loginedMember != null) {
        promptName = loginedMember.getName();
      }

      System.out.printf("%s ) ", promptName);

      String cmd = sc.nextLine();

      Rq rq = new Rq(cmd);

      if (rq.getUrlPath().equals("/usr/article/write")) {
        articleController.doWrite();
      } else if (rq.getUrlPath().equals("/usr/article/list")) {
        articleController.showList(rq);
      } else if (rq.getUrlPath().equals("/usr/article/detail")) {
        articleController.showDetail(rq);
      } else if (rq.getUrlPath().equals("/usr/article/modify")) {
        articleController.doModify(rq);
      } else if (rq.getUrlPath().equals("/usr/article/delete")) {
        articleController.doDelete(rq);
      } else if (rq.getUrlPath().equals("/usr/member/join")) {
        memberController.doJoin();
      } else if (rq.getUrlPath().equals("/usr/member/login")) {
        memberController.doLogin(rq);
      } else if (rq.getUrlPath().equals("/usr/member/logout")) {
        memberController.doLogout(rq);
      } else if (rq.getUrlPath().equals("exit")) {
        System.out.println("== 게시판을 종료합니다. ==");
        break;
      } else {
        System.out.println("잘못 된 명령어입니다.");
      }
    }

    sc.close();
  }
}
