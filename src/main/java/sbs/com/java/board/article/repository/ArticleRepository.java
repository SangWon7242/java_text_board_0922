package sbs.com.java.board.article.repository;

import sbs.com.java.board.article.dto.Article;
import sbs.com.java.board.util.Util;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
  private List<Article> articles;
  private int lastId;

  public ArticleRepository() {
    articles = new ArrayList<>();
    lastId = 0;
  }

  public int write(String subject, String content) {
    int id = ++lastId;

    Article article = new Article(id, subject, content);

    articles.add(article);

    return id;
  }

  private List<Article> getSortedArticles(String orderBy) {
    List<Article> sortedArticles = articles;

    if (orderBy.equals("idAsc")) {
      return articles;
    }

    if (orderBy.equals("idDesc")) {
      sortedArticles = Util.reverseList(articles);
    }

    return sortedArticles;
  }

  public List<Article> getArticles(String searchKeyword, String orderBy) {
    List<Article> filteredArticles = getSortedArticles(orderBy);

    if (!searchKeyword.trim().isEmpty()) {

      filteredArticles = new ArrayList<>();

      for (Article article : articles) {
        boolean matched = article.getSubject().contains(searchKeyword) || article.getContent().contains(searchKeyword);

        if (matched) {
          filteredArticles.add(article);
        }
      }
    }

    return filteredArticles;
  }

  public void modify(int id, String subject, String content) {
    Article article = findByArticleId(id);

    if(article != null); {
      article.setSubject(subject);
      article.setContent(content);
    }
  }

  public void remove(int id) {
    Article article = findByArticleId(id);

    if(article != null); {
      articles.remove(article);
    }
  }

  public Article findByArticleId(int id) {
    for(Article article : articles) {
      if(article.getId() == id) {
        return article;
      }
    }

    return null;
  }
}
