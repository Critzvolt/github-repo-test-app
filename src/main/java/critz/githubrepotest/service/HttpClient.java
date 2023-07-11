package critz.githubrepotest.service;

import critz.githubrepotest.entity.HttpResponse;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

@Service
public class HttpClient implements IHttpClient {

    @Override
    public HttpResponse get(String urlString) {
        try {
            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            JSONObject payload = new JSONObject();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String response = reader.lines().collect(Collectors.joining());
                payload = new JSONObject(response);

            }
            connection.disconnect();
            return new HttpResponse(responseCode, payload);
        }

        catch(Exception e) {
            JSONObject json = new JSONObject();
            json.put("error", e.getMessage());
            return new HttpResponse(500, json);
        }

    }
}
