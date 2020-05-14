package versions.java9.httpclient;

/**
 * @author xiaoy
 * @date 2020/05/13
 */
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// jdk 11 modefy
// HttpResponse.BodyHandlers.ofString() as a replacement for HttpResponse.BodyHandler.asString() and
// HttpRequest.BodyPublishers.ofString(String) as a replacement for HttpRequest.BodyProcessor.fromString(String)
public class HttpClientTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://httpbin.org/uuid")).GET().build();

        String syncResponse = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString()).body();

        System.out.println("Sync response: " + syncResponse);

        HttpClient.newHttpClient().sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(HttpResponse::body).thenAccept(response -> System.out.println("Async response: " + response));

        /*
        .responseAsync() // CompletableFuture
        .thenAccept(httpResponse ->
        System.out.println(httpResponse.body(HttpResponse.asString()))
        );*/
        Thread.sleep(5000);
    }
}

/*public class HttpClientTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://httpbin.org/uuid")).GET().build();

        String syncResponse = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandler..asString()).body();

        System.out.println("Sync response: " + syncResponse);

        HttpClient.newHttpClient().sendAsync(request, HttpResponse.BodyHandler.asString()).thenApply(HttpResponse::body)
            .thenAccept(response -> System.out.println("Async response: " + response));

        
        .responseAsync() // CompletableFuture
        .thenAccept(httpResponse ->
        System.out.println(httpResponse.body(HttpResponse.asString()))
        );
        Thread.sleep(5000);
    }
}*/