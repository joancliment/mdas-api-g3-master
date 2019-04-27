package tv.codely.java_bootstrap;

import com.sun.deploy.net.HttpRequest;
import okhttp3.internal.http.HttpMethod;
import sun.net.www.http.HttpClient;


public class HTTPProtocol {

    String rootUrl = "https://pokeapi.co/api/v2/";

    HttpClientBuilder clientBuilder = HttpClientBuilder.getInstance();

    // additional configuration of client builder
        clientBuilder.addRequestFilter(new UserRequestFilter());
        clientBuilder.addResponseFilter(new UserResponseFilter());

    // additional connection option
    ConnectionOption<Integer> timeoutOption = new ConnectionOption<>("Timeout", 2000);
        clientBuilder.addConnectionOptions(timeoutOption);

    // configured client instance
    // client instance is the main entry point which is used for preparing client requests.
    HttpClient client = clientBuilder.build();

    // construct request builder
    HttpRequestBuilder requestBuilder = client.build("http://example.org");
        requestBuilder.setHeader(HttpHeader.ACCEPT, "text/plain");
        requestBuilder.setMethod(HttpMethod.GET);

    // prepared client request is ready for execution
    HttpRequest request = requestBuilder.build();

}

