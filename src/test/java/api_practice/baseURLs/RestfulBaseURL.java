package api_practice.baseURLs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class RestfulBaseURL {
    protected RequestSpecification spec;

    @Before
    public void setUp(){
        String restfulBaseURL = "https://restful-booker.herokuapp.com";
        spec = new RequestSpecBuilder().
                setBaseUri(restfulBaseURL).
                build();
    }
}