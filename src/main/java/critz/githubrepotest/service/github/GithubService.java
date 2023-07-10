package critz.githubrepotest.service.github;

import critz.githubrepotest.entity.HTTPResponse;
import critz.githubrepotest.service.IGitService;
import critz.githubrepotest.service.IHTTPClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GithubService implements IGitService {

    private IHTTPClient client;
    public GithubService(@Autowired IHTTPClient client) {
        this.client = client;
    }

    @Override
    public JSONObject getRepoInfo(String owner, String repoName) {

        JSONObject result = new JSONObject();

        try {
            HTTPResponse response = client.get("https://api.github.com/repos/" + owner + "/" + repoName);
            if(response.getHttpStatus() != 200){
                result.put("error", "Github returned status " + response.getHttpStatus());
                return result;
            }

            result = GithubJSONMapper.map(response.getPayload());
            return result;

        } catch (Exception e) {
            result.put("error", "Connection error");
            return result;
        }
    }
}
