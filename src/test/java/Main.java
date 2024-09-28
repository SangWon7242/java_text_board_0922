import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    String queryString = "a=1&b=2&c=3";
    // a=1, b=2, c=3
    String[] queryStringBits = queryString.split("&");
    System.out.println(Arrays.toString(queryStringBits));

    for(String bit : queryStringBits) {
      System.out.println(bit);
    }
  }
}
