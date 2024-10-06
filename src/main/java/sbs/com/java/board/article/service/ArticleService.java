package sbs.com.java.board.article.service;

import sbs.com.java.board.article.dto.Article;
import sbs.com.java.board.article.repository.ArticleRepository;
import sbs.com.java.board.container.Container;

import java.util.List;
import java.util.stream.IntStream;

public class ArticleService {
  private ArticleRepository articleRepository;

  public ArticleService() {
    articleRepository = Container.articleRepository;

    makeTestData();
  }

  void makeTestData() {
    IntStream.rangeClosed(1, 100)
        .forEach(i -> write("제목" + i, "내용" + i));
  }

  public int write(String subject, String content) {
    return articleRepository.write(subject, content);
  }

  public List<Article> getArticles(String searchKeyword, String orderBy) {
    return articleRepository.getArticles(searchKeyword, orderBy);
  }

  public void modify(int id, String subject, String content) {
    articleRepository.modify(id, subject, content);
  }

  public void remove(int id) {
    articleRepository.remove(id);
  }

  public Article findByArticleId(int id) {
    return articleRepository.findByArticleId(id);
  }
}
