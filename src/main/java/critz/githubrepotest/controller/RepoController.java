package critz.githubrepotest.controller;

import critz.githubrepotest.service.IGitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RepoController {

    private final IGitService gitService;

    public RepoController(@Autowired IGitService gitService) {
        this.gitService = gitService;
    }

    @GetMapping("/")
    public String ReturnInfo(){
        return "To obtain info on a given repository from \"https://api.github.com/repos/{owner}/{repository-name}\", please call this service with GET request to \"/repositories/{owner}/{repository-name}\".";
    }

    @GetMapping("/repositories/{owner}/{repository-name}")
    public String ReturnRepoInfo(@PathVariable ("owner") String owner, @PathVariable ("repository-name") String repoName) {

    return gitService.getRepoInfo(owner, repoName).toString();
    }

}
