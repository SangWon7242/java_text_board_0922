package sbs.com.java.board;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("== 텍스트 게시판 ==");

    System.out.println("== 게시판을 시작합니다. ==");

    while (true) {
      System.out.print("명령어 ) ");
      String cmd = sc.nextLine();

      if(cmd.equals("exit")) {
        System.out.println("== 게시판을 종료합니다. ==");
        break;
      }

      System.out.printf("입력받은 명령어 : %s\n", cmd);
    }

    sc.close();
  }
}