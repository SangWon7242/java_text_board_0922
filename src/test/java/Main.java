public class Main {
  public static void main(String[] args) {
    Article article = new Article();
    article.id = 1;
    article.subject = "제목1";
    article.content = "내용1";

    System.out.println(article);
  }
}

class Article {
  int id;
  String subject;
  String content;

  @Override
  public String toString() {
    return "{id : %d, subject : %s, content : %s}".formatted(id, subject, content);
  }
}
