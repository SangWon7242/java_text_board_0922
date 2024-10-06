package sbs.com.java.board;

import lombok.Getter;
import sbs.com.java.board.container.Container;
import sbs.com.java.board.session.Session;
import sbs.com.java.board.util.Util;

import java.util.Map;

public class Rq {
  private String url;
  @Getter
  private Map<String, String> params;

  @Getter
  private String urlPath;

  private Session session;
  private String loginedMember = "loginedMember";

  Rq(String url) {
    this.url = url;
    this.params = Util.getParamsFromUrl(url);
    this.urlPath = Util.getUrlPathFromUrl(url);

    session = Container.session;
  }

  public String getParam(String paramName, String defaultValue) {
    if(!params.containsKey(paramName)) {
      return defaultValue;
    }

    return params.get(paramName);
  }

  public int getIntParam(String paramName, int defaultValue) {
    if(!params.containsKey(paramName)) {
      return defaultValue;
    }

    try {
      return Integer.parseInt(params.get(paramName));
    } catch (NumberFormatException e) {
      return defaultValue;
    }
  }

  public boolean isLogined() {
    return hasSessionAttr(loginedMember);
  }

  public boolean isLogout() {
    return !isLogined();
  }

  public Object getSessionAttr(String attrName) {
    return session.getAttribute(attrName);
  }

  public void setSessionAttr(String attrName, Object value) {
    session.setAttribute(attrName, value);
  }

  public boolean hasSessionAttr(String attrName) {
    return session.hasAttribute(attrName);
  }

  public void removeSessionAttr(String attrName) {
    session.removeAttribute(attrName);
  }
}