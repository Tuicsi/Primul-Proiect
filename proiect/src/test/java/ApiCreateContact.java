import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

    public class ApiCreateContact extends BazaApi {
        
        protected static String baseurl = "https://thinking-tester-contact-list.herokuapp.com/contacts";
        protected static String createdContactId;
    
    @BeforeEach
    public void setupbefore(){
    System.out.println("Incepem procesul de autentificare...");
        authenticate();
    }
    
    @Test
    public void createContact() {
        System.out.println("Se defineste contactul pentru creare...");

        String contactData = "{"
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
    System.out.println("Datele contactului: " + contactData);


    System.out.println("Se trimite cererea POST pentru crearea contactului...");
    Response createResponse = RestAssured.given()
        .contentType(ContentType.JSON)
        .header("Authorization","Bearer " + authToken)
        .body(contactData)
        .post(baseurl);

    System.out.println("Raspunsul serverului: Status code = " + createResponse.getStatusCode());

    Assertions.assertEquals(201, createResponse.getStatusCode(), "Eroare la incercarea de creare a contactului");
    System.out.println("Contactul a fost creat cu succes! Status code: " + createResponse.getStatusCode());
    }
}
