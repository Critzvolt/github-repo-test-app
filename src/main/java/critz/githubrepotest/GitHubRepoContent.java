package critz.githubrepotest;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class GitHubRepoContent {

    public static JSONObject getGitHubRepoContent(String urlString) throws Exception {
        URL url = new URL(urlString);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String response = reader.lines().collect(Collectors.joining());
                return new JSONObject(response);
            }
        } else {
            throw new Exception("Failed to retrieve data. Response code: " + responseCode);
        }
    }
}
