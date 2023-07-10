package critz.githubrepotest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;
import org.json.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RepoController {

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

    @GetMapping("/")
    public String ReturnInfo(){
        return "To obtain info on a given repository from \"https://api.github.com/repos/{owner}/{repository-name}\", please call this service with GET request to \"/repositories/{owner}/{repository-name}\".";
    }

    @GetMapping("/repositories/{owner}/{repository-name}")
    public String ReturnRepoInfo(@PathVariable ("owner") String Owner, @PathVariable ("repository-name") String RepoName) {
    String result = "";

        try {
            JSONObject repoContent = getGitHubRepoContent("https://api.github.com/repos/" + Owner + "/" + RepoName);

            result = "{\"fullName\":\"" + repoContent.get("full_name").toString() +"\","
                    + "\"description\":\"" + repoContent.get("description").toString() +"\","
                    + "\"cloneUrl\":\"" + repoContent.get("clone_url").toString() +"\","
                    + "\"stars\":\"" + repoContent.getInt("stargazers_count") +"\","
                    + "\"createdAt\":\"" + repoContent.get("created_at").toString() +"\"" + "}";

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return "Repository not found";
        }
    }

}
