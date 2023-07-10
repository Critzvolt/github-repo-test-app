package critz.githubrepotest;

import org.json.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RepoController {

    @GetMapping("/")
    public String ReturnInfo(){
        return "To obtain info on a given repository from \"https://api.github.com/repos/{owner}/{repository-name}\", please call this service with GET request to \"/repositories/{owner}/{repository-name}\".";
    }

    @GetMapping("/repositories/{owner}/{repository-name}")
    public String ReturnRepoInfo(@PathVariable ("owner") String Owner, @PathVariable ("repository-name") String RepoName) {
    String result = "";

        try {
            JSONObject repoContent = GitHubRepoContent.getGitHubRepoContent("https://api.github.com/repos/" + Owner + "/" + RepoName);

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
