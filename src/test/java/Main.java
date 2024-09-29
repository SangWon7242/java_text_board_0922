import java.util.*;

public class Main {
  public static void main(String[] args) {
    Rq rq = new Rq("/usr/article/write?id=20&subject=제목1&content=내용1&writerName=김철수&hitCount=20");
    Map<String, String> params = rq.getParams();
    System.out.println(params);
    System.out.println(rq.getParams());
    System.out.println(rq.getParams());

    String urlPath = rq.getUrlPath();
    System.out.println(urlPath);
    System.out.println(rq.getUrlPath());
    System.out.println(rq.getUrlPath());
  }
}

class Rq {
  String url;

  Rq(String url) {
    this.url = url;
  }

  public Map<String, String> getParams() {
    return Util.getParamsFromUrl(url);
  }

  public String getUrlPath() {
    return Util.getUrlPathFromUrl(url);
  }
}

class Util {
  static Map<String, String> getParamsFromUrl(String url) {
    System.out.println("getParamsFromUrl 실행");
    Map<String, String> params = new LinkedHashMap<>();
    String[] urlBits = url.split("\\?", 2);

    if(urlBits.length == 1) {
      return params;
    }

    String queryString = urlBits[1];

    for(String bit : queryString.split("&")) {
      String[] bits = bit.split("=");

      if(bits.length == 1) {
        continue;
      }

      params.put(bits[0], bits[1]);
    }

    return params;
  }

  static String getUrlPathFromUrl(String url) {
    System.out.println("getUrlPathFromUrl 실행");
    return url.split("\\?", 2)[0];
  }
}
