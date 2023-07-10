package critz.githubrepotest.service;

import critz.githubrepotest.entity.HTTPResponse;

public interface IHTTPClient {

    public HTTPResponse get(String urlString) throws Exception;
}
