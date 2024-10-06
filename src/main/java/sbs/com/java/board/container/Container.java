package sbs.com.java.board.container;

import sbs.com.java.board.article.controller.ArticleController;
import sbs.com.java.board.member.controller.MemberController;

import java.util.Scanner;

public class Container {
  public static Scanner scanner;

  public static MemberController memberController;
  public static ArticleController articleController;

  static {
    scanner = new Scanner(System.in);

    memberController = new MemberController();
    articleController = new ArticleController();
  }
}
