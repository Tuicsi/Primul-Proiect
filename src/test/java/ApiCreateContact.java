import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

    public class ApiCreateContact extends ApiLogin {
        
        private static String baseurl = "https://thinking-tester-contact-list.herokuapp.com/contacts";
        protected static String createdContactId;
    @Test
    public void createContact() {
        
        authenticate();

    String requestBody = "{"
        + "\"firstName\": \"Ion\","
        + "\"lastName\": \"Popescu\","
        + "\"birthdate\": \"2003-11-20\","
        + "\"email\": \"ion.popescu@example.com\","
        + "\"phone\": \"0722222221\","
        + "\"street1\": \"ceva\","
        + "\"street2\": \"ceva ceva\","
        + "\"city\": \"undevreu\","
        + "\"stateProvince\": \"Bucuresti\","
        + "\"postalCode\": \"0110001\","
        + "\"country\": \"Rumenia\""
    + "}";

    Response createResponse = RestAssured.given()
        .contentType(ContentType.JSON)
        .header("Authorization","Bearer " + authToken)
        .body(requestBody)
        .post(baseurl);

    System.out.println("Status code:" + createResponse.getStatusCode());
    System.out.println("Response body:" + createResponse.prettyPrint());

    Assertions.assertEquals(201, createResponse.getStatusCode(), "Eroare la incercarea de creare a contactului");

    String createdContactId = createResponse.jsonPath().getString("_id");
    Assertions.assertNotNull(createdContactId, "ID-ul contactului nu a fost gasit");

    }
}
