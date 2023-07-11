package critz.githubrepotest;

import critz.githubrepotest.entity.HttpResponse;
import critz.githubrepotest.service.HttpClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HttpClientTest {

    @Test
    public void get_ValidURL_ShouldReturn200WithPayload() {
        HttpClient client = new HttpClient();
        HttpResponse response = client.get("https://postman-echo.com/get");

        Assert.assertEquals(200, response.getHttpStatus());
        Assert.assertNotNull(response.getPayload());
    }

    @Test
    public void get_InvalidURL_ShouldReturn500() {
        HttpClient client = new HttpClient();
        HttpResponse response = client.get("lorem ipsum");

        Assert.assertEquals(500, response.getHttpStatus());
    }
}
