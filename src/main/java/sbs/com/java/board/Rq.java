package sbs.com.java.board;

import lombok.Getter;
import sbs.com.java.board.util.Util;

import java.util.Map;

public class Rq {
  private String url;
  @Getter
  private Map<String, String> params;

  @Getter
  private String urlPath;

  Rq(String url) {
    this.url = url;
    this.params = Util.getParamsFromUrl(url);
    this.urlPath = Util.getUrlPathFromUrl(url);
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
}