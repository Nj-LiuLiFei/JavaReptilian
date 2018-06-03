package util;

import com.alibaba.fastjson.JSONArray;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class getRequestUrl {
    private static CloseableHttpClient httpclient = HttpClients.createDefault();

    public static String getRequest(String url){
        try {
            TimeUnit.MINUTES.sleep(1);//分
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpget);
            if(response == null) {
                System.out.println("商品价格请求失败");
                return new JSONArray().toString();
            }
            String responseBody = httpclient.execute(httpget, new ResponseHandlerUtil<String>());
            response.close();
            return responseBody;
        } catch (IOException e) {
            System.out.println(url);
            getRequest(url);
            e.printStackTrace();
        }finally {

        }
        return new JSONArray().toString();
    }
}
