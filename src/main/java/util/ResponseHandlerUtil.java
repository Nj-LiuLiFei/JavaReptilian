package util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ResponseHandlerUtil<String> implements ResponseHandler<String> {
    @Override
    public String handleResponse(final HttpResponse httpResponse) throws ClientProtocolException, IOException {
        int status = httpResponse.getStatusLine().getStatusCode();
        if (status >= 200 && status < 300) {
            HttpEntity entity = httpResponse.getEntity();
            return entity != null ? (String) EntityUtils.toString(entity, "GBK") : null;
        } else {
            throw new ClientProtocolException("Unexpected response status: " + status);
        }
    }
}
