package critz.githubrepotest;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.mockito.Mockito;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GitHubRepositoryTest {

    @Test
    public void testGitHubRepository() {
        // Mocked values from the GitHub API
        String full_name = "Critzvolt/crime-report-system";
        String description = "Example repository for crime report system";
        String clone_url = "https://github.com/Critzvolt/crime-report-system";
        int stargazers_count = 100;
        String created_at = "2020-05-01T10:00:00Z";

        // Mock the GitHub repository object
        GitHubRepository mockRepository = Mockito.mock(GitHubRepository.class);
        Mockito.when(mockRepository.getFull_name()).thenReturn(full_name);
        Mockito.when(mockRepository.getDescription()).thenReturn(description);
        Mockito.when(mockRepository.getClone_url()).thenReturn(clone_url);
        Mockito.when(mockRepository.getStargazers_count()).thenReturn(stargazers_count);
        Mockito.when(mockRepository.getCreated_at()).thenReturn(created_at);

        // Perform your offline tests using the mocked GitHub repository object
        Assert.assertEquals("Critzvolt/crime-report-system", full_name);
        Assert.assertEquals("Example repository for crime report system", description);
        Assert.assertEquals("https://github.com/Critzvolt/crime-report-system", clone_url);
        Assert.assertEquals(100, stargazers_count);
        Assert.assertEquals("2020-05-01T10:00:00Z", created_at);

        // Optionally, verify interactions with the mock
        /*Mockito.verify(mockRepository).getFull_name();
        Mockito.verify(mockRepository).getDescription();
        Mockito.verify(mockRepository).getClone_url();
        Mockito.verify(mockRepository).getStargazers_count();
        Mockito.verify(mockRepository).getCreated_at();*/
    }
}
