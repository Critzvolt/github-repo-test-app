package critz.githubrepotest;

import critz.githubrepotest.entity.HttpResponse;
import critz.githubrepotest.service.IHttpClient;
import critz.githubrepotest.service.github.GitHubService;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@RunWith(MockitoJUnitRunner.class)
public class GitHubServiceTest {

    private GitHubService githubService;
    private IHttpClient httpClient;

    @Before
    public void setUp() {
        httpClient = mock(IHttpClient.class);
        githubService = new GitHubService(httpClient);
    }

    @Test
    public void getRepoInfo_ValidOwnerAndRepoName_ShouldReturnRepoInfo() {

        when(httpClient.get(anyString())).thenReturn(new HttpResponse(
                200, readGitHubResponseJson()));

        JSONObject expected = new JSONObject();
        expected.put("fullName", "Critzvolt/crime-report-system");
        expected.put("cloneUrl", "https://github.com/Critzvolt/crime-report-system.git");
        expected.put("stars", 0);
        expected.put("createdAt", "2022-11-25T13:37:28Z");

        JSONObject actual = githubService.getRepoInfo("test1", "test2");

        Assert.assertEquals(expected.getString("fullName"), actual.getString("fullName"));
        Assert.assertEquals("null", actual.getString("description"));
        Assert.assertEquals(expected.getString("cloneUrl"), actual.getString("cloneUrl"));
        Assert.assertEquals(expected.getInt("stars"), actual.getInt("stars"));
        Assert.assertEquals(expected.getString("createdAt"), actual.getString("createdAt"));
    }

    @Test
    public void getRepoInfo_HTTPError_ShouldReturnErrorAndHTTPCode() {

        when(httpClient.get(anyString())).thenReturn(new HttpResponse(
                500, null));

        JSONObject expected = new JSONObject();
        expected.put("error", "Github returned status 500");

        JSONObject actual = githubService.getRepoInfo("test1", "test2");

        Assert.assertEquals(expected.getString("error"), actual.getString("error"));
    }


    private JSONObject readGitHubResponseJson() {
        JSONObject json = new JSONObject();
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("github_response.json");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String response = reader.lines().collect(Collectors.joining());
            json = new JSONObject(response);
            return json;
        }
        catch (Exception e) {
            e.printStackTrace();
            return json;
        }
    }
}
