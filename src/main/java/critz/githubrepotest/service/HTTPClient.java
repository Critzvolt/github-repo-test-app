package critz.githubrepotest.service;

import critz.githubrepotest.entity.HTTPResponse;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

@Service
public class HTTPClient implements IHTTPClient {

    @Override
    public HTTPResponse get(String urlString) throws Exception {
        URL url = new URL(urlString);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        JSONObject payload = new JSONObject();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String response = reader.lines().collect(Collectors.joining());
                payload = new JSONObject(response);
            }
        }
        connection.disconnect();
        return new HTTPResponse(responseCode, payload);
    }
}
