package sbs.com.java.board;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int lastArticleId = 0;

    System.out.println("== 텍스트 게시판 ==");

    System.out.println("== 게시판을 시작합니다. ==");

    while (true) {
      System.out.print("명령어 ) ");
      String cmd = sc.nextLine();

      if(cmd.equals("/usr/article/write")) {
        System.out.print("제목 : ");
        String subject = sc.nextLine();

        System.out.print("내용 : ");
        String content = sc.nextLine();

        int id = ++lastArticleId;

        Article article = new Article(id, subject, content);

        System.out.println("등록 된 게시물 객체 : " + article);
        System.out.printf("%d번 게시물이 등록되었습니다.\n", article.id);
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