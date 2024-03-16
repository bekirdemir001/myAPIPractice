package api_practice.getrequests.restfulApi;

import api_practice.baseURLs.RestfulBaseURL;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetAllBookingIdsFilterByCheckinCheckoutDate extends RestfulBaseURL {
    /*
    Given
        https://restful-booker.herokuapp.com/booking?checkin=2018-01-01&checkout=2019-01-01
    When
        Send a Get request to the URL
    Then
        Status Code should be 200
    And
        Response Body has a "bookingid" variable
    And
        Response Body has 6 records
     */

    @Test
    public void getAllBookingIdsFilterByCheckinCheckoutDate(){
        //Set the URL
        spec.pathParam("first", "booking").queryParams("checkin", "2018-01-01", "checkout", "2019-01-01");

        //Set the expected data
            //There is no data given to the database by API

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //Assert the response
            //Status Code should be 200
        assertEquals(200, response.statusCode());
            //Response Body has a "bookingid" variable
        assertTrue(response.asString().contains("bookingid"));
            //Response Body has 6 records
        assertEquals(6, response.jsonPath().getList("bookingid").size());
    }
}