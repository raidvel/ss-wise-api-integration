package main.java;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

public final class Main {

    private static final String token = Util.getToken("READ_TOKEN");
    private static final String url = Util.getToken("URL");

    private Main() {
    }

    public static void main(String[] args) throws Exception {

        var httpClient = HttpClient.newBuilder().build();
        var host = url + "/v2/profiles";

        ObjectMapper mapper = new ObjectMapper();

        var request = HttpRequest.newBuilder()
                .uri(URI.create(host))
                .header("Authorization", "Bearer " + token)
                .header("Accept", "application/json")
                .GET()
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        
        try {
            JsonNode jsonNode = mapper.readTree(body);
            String pretty = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
            System.out.println(pretty);

        } catch (Exception e) {
            System.out.println(body);
        }
    }
}
