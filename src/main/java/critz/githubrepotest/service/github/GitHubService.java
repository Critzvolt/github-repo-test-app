package critz.githubrepotest.service.github;

import critz.githubrepotest.entity.HttpResponse;
import critz.githubrepotest.service.IGitService;
import critz.githubrepotest.service.IHttpClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GitHubService implements IGitService {

    private final IHttpClient client;
    public GitHubService(@Autowired IHttpClient client) {
        this.client = client;
    }

    @Override
    public JSONObject getRepoInfo(String owner, String repoName) {

        JSONObject result = new JSONObject();

        HttpResponse response = client.get("https://api.github.com/repos/" + owner + "/" + repoName);
        if (response.getHttpStatus() != 200) {
            result.put("error", "Github returned status " + response.getHttpStatus());
            return result;
        }

        result = GitHubJsonMapper.map(response.getPayload());
        return result;

    }
}
