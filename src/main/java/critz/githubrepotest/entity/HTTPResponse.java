package critz.githubrepotest.entity;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;

public class HTTPResponse {

    public HTTPResponse(int httpStatus, JSONObject payload) {
        this.httpStatus = httpStatus;
        this.payload = payload;
    }

    private int httpStatus;
    private JSONObject payload;

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public JSONObject getPayload() {
        return payload;
    }

    public void setPayload(JSONObject payload) {
        this.payload = payload;
    }



}
