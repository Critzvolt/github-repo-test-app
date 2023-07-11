package critz.githubrepotest.service;

import critz.githubrepotest.entity.HttpResponse;

public interface IHttpClient {

    HttpResponse get(String urlString);
}
