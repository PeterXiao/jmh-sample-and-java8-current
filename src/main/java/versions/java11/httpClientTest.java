package versions.java11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xiaoy
 * @date 2020/05/14
 */
@Slf4j
public class httpClientTest {

    /**
     * @param args
     * @throws InterruptedException
     * @throws IOException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO Auto-generated method stub
        HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(5)).followRedirects(HttpClient.Redirect.ALWAYS).build();

        HttpRequest getRequest = HttpRequest.newBuilder().GET().uri(URI.create("http://www.flydean.com")).header(
            "User-Agent",
            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.122 Safari/537.36")
            .build();

        HttpRequest.BodyPublisher requestBody = HttpRequest.BodyPublishers.ofString("{ 我是body }");
        HttpRequest postRequest =
            HttpRequest.newBuilder().POST(requestBody).uri(URI.create("http://www.flydean.com")).build();

        HttpResponse<String> response = client.send(getRequest, HttpResponse.BodyHandlers.ofString());
        String respnseBody = response.body();
        log.info(respnseBody);

    }

    public void useAsyncHttp() {
        HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(5)).followRedirects(HttpClient.Redirect.ALWAYS).build();

        CompletableFuture<Void> completableFuture = checkUri(client, URI.create("http://www.flydean.com"));
        // 获取completableFuture的值
        completableFuture.join();
    }

    private CompletableFuture<Void> checkUri(HttpClient httpClient, URI uri) {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(uri).header("User-Agent",
            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.122 Safari/537.36")
            .build();

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::statusCode)
            .thenApply(statusCode -> statusCode == 200).exceptionally(ex -> false).thenAccept(valid -> {
                if (valid) {
                    log.info("uri {} is valid", uri);
                } else {
                    log.info("uri {} is not valid", uri);
                }
            });
    }

    public void getresponse(String uri) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        System.out.println(response.body());
    }

    public void getfile(String uri) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        HttpResponse<Path> response = client.send(request, BodyHandlers.ofFile(Paths.get("body.txt")));

        System.out.println("Response in file:" + response.body());
    }

    public CompletableFuture<String> ayncget(String uri) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        return client.sendAsync(request, BodyHandlers.ofString()).thenApply(HttpResponse::body);
    }

    public CompletableFuture<Path> get(String uri) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        return client.sendAsync(request, BodyHandlers.ofFile(Paths.get("body.txt"))).thenApply(HttpResponse::body);
    }

    public void post(String uri, String data) throws Exception {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).POST(BodyPublishers.ofString(data)).build();

        HttpResponse<?> response = client.send(request, BodyHandlers.discarding());
        System.out.println(response.statusCode());
    }

    // 并发请求
    // 将Java Streams和CompletableFuture API组合在一起以发出大量请求并等待它们的响应很容易。以下示例为列表中的每个URI发送GET请求，并将所有响应存储为字符串。

    /*    public void getURIs(List<URI> uris) {
        HttpClient client = HttpClient.newHttpClient();
        List<HttpRequest> requests =
            uris.stream().map(HttpRequest::newBuilder).map(reqBuilder -> reqBuilder.build()).collect(toList());
    
        CompletableFuture.allOf(requests.stream().map(request -> client.sendAsync(request, asString()))
            .toArray(CompletableFuture<?>[]::new)).join();
    }*/

    // 获取JSON
    // 在许多情况下，响应主体将采用更高级别的格式。可以使用便捷响应正文处理程序以及第三方库将响应正文转换为该格式。
    //
    // 以下示例演示了如何结合使用杰克逊库和BodyHandler::asString将JSON响应转换Map为String键/值对。

    /*    public CompletableFuture<Map<String, String>> JSONBodyAsMap(URI uri) {
        UncheckedObjectMapper objectMapper = new UncheckedObjectMapper();
    
        HttpRequest request = HttpRequest.newBuilder(uri).header("Accept", "application/json").build();
    
        return HttpClient.newHttpClient().sendAsync(request, asString()).thenApply(HttpResponse::body)
            .thenApply(objectMapper::readValue);
    }*/

    // 发布JSON
    // 在许多情况下，请求主体将采用某种更高级别的格式。可以使用便捷请求正文处理程序以及第三方库将请求正文转换为该格式。
    //
    // 以下示例演示了如何结合使用杰克逊库， BodyPublisher::fromString将 MapString键/值对转换为JSON。

    /*    public CompletableFuture<Void> postJSON(URI uri, Map<String, String> map) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
    
        HttpRequest request = HttpRequest.newBuilder(uri).header("Content-Type", "application/json")
            .POST(BodyPublisher.fromString(requestBody)).build();
    
        return HttpClient.newHttpClient().sendAsync(request, BodyHandler.asString()).thenApply(HttpResponse::statusCode)
            .thenAccept(System.out::println);
    }*/

    // 设置代理
    // 阿ProxySelector可在被配置成 HttpClient通过客户的 Builder::proxy方法。该ProxySelector API返回给定URI特定的代理。在许多情况下，单个静态代理就足够了。的
    // ProxySelector::of静态工厂方法可以用于产生这样的选择器。
    //
    // 响应主体为带有指定代理的字符串
    /*    public CompletableFuture<String> get(String uri) {
        HttpClient client = HttpClient.newBuilder()
              .proxy(ProxySelector.of(new InetSocketAddress("www-proxy.com", 8080)))
              .build();
    
        HttpRequest request = HttpRequest.newBuilder()
              .uri(URI.create(uri))
              .build();
    
        return client.sendAsync(request, asString())
              .thenApply(HttpResponse::body);
    }*/
    // 或者，可以使用系统范围的默认代理选择器，这是macOS上的默认选择器。
    //
    // HttpClient.newBuilder()
    // .proxy(ProxySelector.getDefault())
    // .build();
}

/*class UncheckedObjectMapper extends com.fasterxml.jackson.databind.ObjectMapper {
    *//** Parses the given JSON string into a Map. *//*
                                                         Map<String,String> readValue(String content) {
                                                         try {
                                                         return this.readValue(content, new TypeReference<>(){});
                                                         } catch (IOException ioe) {
                                                         throw new CompletionException(ioe);
                                                         }
                                                         }
                                                         }*/
