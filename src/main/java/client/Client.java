package client;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.net.URI;

public class Client {
    public static void main(String[] args) throws Exception {
        URIBuilder builder = new URIBuilder();
        builder.setScheme("http").
                setHost("localhost").
                setPath("odd").
                setPort(8080)
                .setParameter("number", "4");
        URI uri = builder.build();

        // create and execute the request
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(uri);
        HttpResponse response = httpClient.execute(request);

        assert response.getStatusLine().getStatusCode()==200;

        String content = EntityUtils.toString(response.getEntity());
        System.out.println("Is 4 odd?" + content);

    }
}
