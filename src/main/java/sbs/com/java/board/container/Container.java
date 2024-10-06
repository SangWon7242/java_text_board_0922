package sbs.com.java.board.container;

import sbs.com.java.board.article.controller.ArticleController;
import sbs.com.java.board.article.repository.ArticleRepository;
import sbs.com.java.board.article.service.ArticleService;
import sbs.com.java.board.member.controller.MemberController;
import sbs.com.java.board.member.repository.MemberRepository;
import sbs.com.java.board.member.service.MemberService;
import sbs.com.java.board.session.Session;

import java.util.Scanner;

public class Container {
  public static Scanner scanner;
  public static Session session;

  public static MemberRepository memberRepository;
  public static ArticleRepository articleRepository;

  public static MemberService memberService;
  public static ArticleService articleService;

  public static MemberController memberController;
  public static ArticleController articleController;

  static {
    scanner = new Scanner(System.in);
    session = new Session();

    memberRepository = new MemberRepository();
    articleRepository = new ArticleRepository();

    memberService = new MemberService();
    articleService = new ArticleService();

    memberController = new MemberController();
    articleController = new ArticleController();
  }
}
