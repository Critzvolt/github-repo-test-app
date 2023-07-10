package critz.githubrepotest.service;

import org.json.JSONObject;

public interface IGitService {

    JSONObject getRepoInfo(String Owner, String RepoName);

}
