package versions.java9.httpclient;

import static java.net.http.HttpRequest.newBuilder;

/**
 * @author xiaoy
 * @date 2020/05/13
 */
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

public class PostRequestTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        BodyPublisher body = BodyPublishers.ofString("{'id':1}");
        HttpRequest request = newBuilder().POST(body).uri(URI.create("http://httpbin.org/post")).build();

        HttpClient httpClient = HttpClientBuilderTest.createHttpClient();
        HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response: " + httpResponse.body());
    }
}
