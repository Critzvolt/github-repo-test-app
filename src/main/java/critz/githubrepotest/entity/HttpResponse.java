package critz.githubrepotest.entity;

import org.json.JSONObject;

public class HttpResponse {

    public HttpResponse(int httpStatus, JSONObject payload) {
        this.httpStatus = httpStatus;
        this.payload = payload;
    }

    private final int httpStatus;
    private final JSONObject payload;

    public int getHttpStatus() {
        return httpStatus;
    }

    public JSONObject getPayload() {
        return payload;
    }


}
