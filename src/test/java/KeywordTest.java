import java.util.ArrayList;
import java.util.List;

public class KeywordTest {
  public static void main(String[] args) {
    List<Article> articles = new ArrayList<>();
    articles.add(new Article(1, "제목1", "내용1"));
    articles.add(new Article(2, "제목2", "내용2"));
    articles.add(new Article(3, "제목3", "내용3"));
    articles.add(new Article(4, "자바는 무엇인가요?", "자바는 객체지향 프로그래밍 언어입니다."));
    articles.add(new Article(5, "ㅋㅋㅋㅋㅋㅋ", "ㅎㅎㅎㅎ"));
    articles.add(new Article(6, "반가워", "어서와"));

    System.out.println(articles);

    String searchKeyword = "자바";
    List<Article> filteredArticles = new ArrayList<>();

    for(Article article : articles) {
      if(article.subject.contains(searchKeyword)) {
        filteredArticles.add(article);
      }
    }

    System.out.println(filteredArticles);
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