package critz.githubrepotest.service.github;

import org.json.JSONObject;

public class GitHubJsonMapper {

    public static JSONObject map (JSONObject source){
        JSONObject destination = new JSONObject();

        destination.put("fullName", source.get("full_name").toString());
        destination.put("description", source.get("description").toString());
        destination.put("cloneUrl", source.get("clone_url").toString());
        destination.put("stars", source.get("stargazers_count"));
        destination.put("createdAt", source.get("created_at").toString());

        return destination;

    }
}
