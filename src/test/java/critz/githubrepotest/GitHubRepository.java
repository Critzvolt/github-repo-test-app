package critz.githubrepotest;
import org.json.JSONObject;


public class GitHubRepository {

    String full_name;
    String description;
    String clone_url;
    Integer stargazers_count;
    String created_at;

    public String getFull_name() {return full_name;}
    public void setFull_name(String full_name) {this.full_name = full_name;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public String getClone_url() {return clone_url;}
    public void setClone_url(String clone_url) {this.clone_url = clone_url;}
    public Integer getStargazers_count() {return stargazers_count;}
    public void setStargazers_count(Integer stargazers_count) {this.stargazers_count = stargazers_count;}
    public String getCreated_at() {return created_at;}
    public void setCreated_at(String created_at) {this.created_at = created_at;}

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("full_name", full_name);
        json.put("description", description);
        json.put("clone_url", clone_url);
        json.put("stargazers_count", stargazers_count);
        json.put("created_at", created_at);
        return json;
    }

}
