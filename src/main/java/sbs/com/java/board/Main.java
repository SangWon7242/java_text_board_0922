package sbs.com.java.board;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
  static void makeTestData(List<Article> articles) {
    IntStream.rangeClosed(1, 100)
        .forEach(i -> articles.add(new Article(i, "제목" + i, "내용" + i)));
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<Article> articles = new ArrayList<>();

    makeTestData(articles);

    int lastArticleId = articles.get(articles.size() - 1).id;

    System.out.println("== 텍스트 게시판 ==");
    System.out.println("== 게시판을 시작합니다. ==");

    while (true) {
      System.out.print("명령어 ) ");
      String cmd = sc.nextLine();

      Rq rq = new Rq(cmd);

      if (rq.getUrlPath().equals("/usr/article/write")) {
        actionUsrArticleWrite(sc, lastArticleId, articles);
        lastArticleId++;
      } else if (rq.getUrlPath().equals("/usr/article/list")) {
        actionUsrArticleList(rq, articles);
      } else if (rq.getUrlPath().equals("/usr/article/detail")) {
        actionUsrArticleDetail(rq, articles);
      } else if (rq.getUrlPath().equals("exit")) {
        System.out.println("== 게시판을 종료합니다. ==");
        break;
      } else {
        System.out.println("잘못 된 명령어입니다.");
      }
    }

    sc.close();
  }

  private static void actionUsrArticleDetail(Rq rq, List<Article> articles) {
    if (articles.isEmpty()) {
      System.out.println("게시물이 존재하지 않습니다.");
      return;
    }

    Map<String, String> params = rq.getParams();

    if (!params.containsKey("id")) {
      System.out.println("id 값을 입력해주세요.");
      return;
    }

    int id = 0;

    try {
      id = Integer.parseInt(params.get("id"));
    } catch (NumberFormatException e) {
      System.out.println("id를 정수형태로 입력해주세요.");
      return;
    }


    if (id > articles.size()) {
      System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
      return;
    }

    Article article = articles.get(id - 1);

    System.out.println("== 게시물 상세보기 ==");
    System.out.printf("번호 : %d\n", article.id);
    System.out.printf("제목 : %s\n", article.subject);
    System.out.printf("내용 : %s\n", article.content);
  }

  private static void actionUsrArticleWrite(Scanner sc, int lastArticleId, List<Article> articles) {
    System.out.println("== 게시물 작성 ==");
    System.out.print("제목 : ");
    String subject = sc.nextLine();

    System.out.print("내용 : ");
    String content = sc.nextLine();

    int id = ++lastArticleId;

    Article article = new Article(id, subject, content);

    articles.add(article);

    System.out.println("등록 된 게시물 객체 : " + article);
    System.out.printf("%d번 게시물이 등록되었습니다.\n", article.id);
  }

  static void actionUsrArticleList(Rq rq, List<Article> articles) {
    if (articles.isEmpty()) {
      System.out.println("게시물이 존재하지 않습니다.");
      return;
    }

    Map<String, String> params = rq.getParams();

    // articles : 정렬, 필터링이 거치지 않은 원본 코드
    List<Article> filteredArticles = articles;

    if (params.containsKey("searchKeyword")) {
      String searchKeyword = params.get("searchKeyword");

      filteredArticles = new ArrayList<>();

      for (Article article : articles) {
        boolean matched = article.subject.contains(searchKeyword) || article.content.contains(searchKeyword);

        if (matched) {
          filteredArticles.add(article);
        }
      }
    }

    List<Article> sortedArticles = filteredArticles;

    boolean orderByIdDesc = true;

    if (params.containsKey("orderBy") && params.get("orderBy").equals("idAsc")) {
      orderByIdDesc = false;
    }

    if (orderByIdDesc) {
      sortedArticles = Util.reverseList(sortedArticles);
    }

    System.out.println("== 게시물 리스트 ==");

    for (Article article : sortedArticles) {
      System.out.printf("%d | %s\n", article.id, article.subject);
    }
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

class Rq {
  String url;
  Map<String, String> params;
  String urlPath;

  Rq(String url) {
    this.url = url;
    this.params = Util.getParamsFromUrl(url);
    this.urlPath = Util.getUrlPathFromUrl(url);
  }

  public Map<String, String> getParams() {
    return params;
  }

  public String getUrlPath() {
    return urlPath;
  }
}

class Util {
  static Map<String, String> getParamsFromUrl(String url) {
    Map<String, String> params = new LinkedHashMap<>();
    String[] urlBits = url.split("\\?", 2);

    if (urlBits.length == 1) {
      return params;
    }

    String queryString = urlBits[1];

    for (String bit : queryString.split("&")) {
      String[] bits = bit.split("=");

      if (bits.length == 1) {
        continue;
      }

      params.put(bits[0], bits[1]);
    }

    return params;
  }

  static String getUrlPathFromUrl(String url) {
    return url.split("\\?", 2)[0];
  }

  // 이 함수는 원본리스트를 훼손하지 않고, 새 리스트를 만듭니다. 즉 정렬이 반대인 복사본리스트를 만들어서 반환합니다.
  public static <T> List<T> reverseList(List<T> list) {
    List<T> reverse = new ArrayList<>(list.size());

    for (int i = list.size() - 1; i >= 0; i--) {
      reverse.add(list.get(i));
    }
    return reverse;
  }
}
