package versions.java8.ver;

/**
 * @author xiaoy
 * @date 2020/05/13
 */
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class UrlEncoderExample {
    public static void main(String[] args) {
        String url = "http://github.com/petershow";
        String encodedUrl = Base64.getUrlEncoder().encodeToString(url.getBytes(StandardCharsets.UTF_8));
        System.out.println("encodedUrl = " + encodedUrl);
    }
}
