import java.util.*;

public class Main {
  public static void main(String[] args) {
    Map<String, String> params = Util.getParamsFromUrl("/usr/article/write?id=20&subject=제목1&content=내용1&writerName=김철수&hitCount=20");
    System.out.println(params);
    System.out.println(params.get("id")); // 20
    System.out.println(params.get("subject")); // 제목1
    System.out.println(params.get("content")); // 내용1
    System.out.println(params.get("writerName")); // 김철수
    System.out.println(params.get("hitCount")); // 20
  }
}

class Util {
  static Map<String, String> getParamsFromUrl(String url) {
    Map<String, String> params = new HashMap<>();
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
}
