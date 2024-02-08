package Requests;

import Users.User;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestsManager {
    private final String endpoint = "https://random-data-api.com/api/v2";
    private final String userEndpoint = String.format("%s/users", endpoint);
    private Gson gson = new Gson();

    private String getRequest(String endpoint) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endpoint)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            return response.body();

        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();

        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public User getUser() {
        String response = getRequest(userEndpoint);
        User user = null;

        if (response != null) {
            user = gson.fromJson(response, User.class);
        }

        return user;
    }
}
