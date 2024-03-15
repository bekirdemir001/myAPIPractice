package api_practice.getrequests.restfulApi;

import api_practice.baseURLs.RestfulBaseURL;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetAllBookingIdsFilterByName extends RestfulBaseURL {
     /*
    Given
        https://restful-booker.herokuapp.com/booking?firstname=Sally&lastname=Brown
    When
        Send a Get request to the URL
    Then
        Status Code should be 200
    And
        Response Body has a "bookingid" variable
    And
        Response Body has 5 records
     */

    @Test
    public void getAllBookingIdsFilterByName(){
        //Set the URL
        spec.pathParam("first", "booking").queryParams("firstname", "Sally", "lastname", "Brown");

        //Set the expected data
            //There is no data given to the database by API

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}");
        //response.prettyPrint();

        //Assert the response
            //Status Code should be 200
        assertEquals(200, response.statusCode());
            //Response Body has a "bookingid" variable
        assertTrue(response.asString().contains("bookingid"));
            //Response Body has 6 records
        List<String> bookingidList = response.jsonPath().getList("bookingid");
        assertEquals(6, bookingidList.size());
    }
}