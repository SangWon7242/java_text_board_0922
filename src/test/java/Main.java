import java.util.*;

public class Main {
  public static void main(String[] args) {
    String queryString = "id=20&subject=제목1&content=내용1&writerName=김철수&hitCount=20";
    String[] queryStringBits = queryString.split("&");

    Map<String, Object> params = new LinkedHashMap<>();

    for (String bit : queryStringBits) {
      String[] bitBits = bit.split("=");
      params.put(bitBits[0], bitBits[1]);
    }

    System.out.println(params);

    System.out.println("== 원하는 것을 하나하나 가져와서 사용 ==");
    System.out.println("id : " + params.get("id"));
    System.out.println("subject : " + params.get("subject"));
    System.out.println("content : " + params.get("content"));
    System.out.println("writerName : " + params.get("writerName"));
    System.out.println("hitCount : " + params.get("hitCount"));

    System.out.println("== 반복문을 사용하여 순회 출력 ==");
    for(String paramName : params.keySet()) {
      Object paramValue = params.get(paramName);

      System.out.println(paramName + " : " + paramValue);
    }
  }
}
