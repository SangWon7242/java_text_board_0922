package sbs.com.java.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static void makeTestData(List<Article> articles) {
    IntStream.rangeClosed(1, 3)
        .forEach(i -> articles.add(new Article(i, "제목" + i, "내용" + i)));
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Article lastArticle = null;
    List<Article> articles = new ArrayList<>();

    makeTestData(articles);

    // 0, 1, 2
    int lastArticleId = articles.get(articles.size() - 1).id;

    System.out.println("== 텍스트 게시판 ==");
    System.out.println("== 게시판을 시작합니다. ==");

    while (true) {
      System.out.print("명령어 ) ");
      String cmd = sc.nextLine();

      if(cmd.equals("/usr/article/write")) {
        System.out.println("== 게시물 작성 ==");
        System.out.print("제목 : ");
        String subject = sc.nextLine();

        System.out.print("내용 : ");
        String content = sc.nextLine();

        int id = ++lastArticleId;

        Article article = new Article(id, subject, content);
        lastArticle = article;

        articles.add(article);

        System.out.println("등록 된 게시물 객체 : " + article);
        System.out.printf("%d번 게시물이 등록되었습니다.\n", article.id);
      }
      else if(cmd.equals("/usr/article/list")) {
        if(articles.isEmpty()) {
          System.out.println("게시물이 존재하지 않습니다.");
          continue;
        }

        System.out.println("== 게시물 리스트 ==");

        for(int i = articles.size() - 1; i >= 0; i--) {
          Article article = articles.get(i);
          System.out.printf("%d | %s\n", article.id, article.subject);
        }

      }
      else if(cmd.equals("/usr/article/detail")) {
        Article article = lastArticle;

        if(article == null) {
          System.out.println("게시물이 존재하지 않습니다.");
          continue;
        }

        System.out.println("== 게시물 상세보기 ==");
        System.out.printf("번호 : %d\n", article.id);
        System.out.printf("제목 : %s\n", article.subject);
        System.out.printf("내용 : %s\n", article.content);
      }
      else if(cmd.equals("exit")) {
        System.out.println("== 게시판을 종료합니다. ==");
        break;
      }
      else {
        System.out.println("잘못 된 명령어입니다.");
      }
    }

    sc.close();
  }
}

class Article {
  int id;
  String subject;
  String content;

  Article(int id, String subject, String content) {
    this.id = id;
    this.subject = subject;
    this.content = content;
  }

  @Override
  public String toString() {
    return "{id : %d, subject : \"%s\", content : \"%s\"}".formatted(id, subject, content);
  }
}