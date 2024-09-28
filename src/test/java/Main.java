import java.util.*;

public class Main {
  public static void main(String[] args) {
    String url = "/usr/article/write?id=20&subject=제목1&content=내용1&writerName=김철수&hitCount=20";
    Map<String, String> params = Util.getParamsFromUrl(url);
    System.out.println(params);

    String urlPath = Util.getUrlPathFromUrl(url);
    System.out.println(urlPath);
  }
}

class Util {
  static Map<String, String> getParamsFromUrl(String url) {
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
    return url.split("\\?", 2)[0];
  }
}
