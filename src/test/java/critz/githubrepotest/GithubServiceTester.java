package critz.githubrepotest;

import critz.githubrepotest.service.HTTPClient;
import critz.githubrepotest.service.IHTTPClient;
import critz.githubrepotest.service.github.GithubService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GithubServiceTester {

    private GithubService githubService;
    private HTTPClient httpClient;

    @Before
    public void setUp() {
        httpClient = mock(HTTPClient.class);
        githubService = new GithubService(httpClient);
    }

    @Test
    public void test() {
        //httpclient.HTTPResponse bierze url, wypluwa response code i JSONobject - jeśli JSONobject nie jest pusty to się udało (było HTTP_OK)
        //GithubService.getRepoInfo bierze 2 parametry, konstruuje z nich url, rzuca zapytanie do httpclienta i zwraca albo poprawny JSONobject albo errorowy
        //najpierw sprawdz HTTPresponse (200 + niepusty payload vs inny kod i pusty payload)
        //potem sprawdź czy result ma pole "error" czy nie

        when(httpClient.get("https://api.github.com/repos/Critzvolt/crime-report-system").thenReturn(200));

        Assert.has
    }

}
