import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ApiDeleteContact extends BazaApi {
    
    protected static String baseurl = "https://thinking-tester-contact-list.herokuapp.com/contacts";
    protected static String firstContactId;

    @BeforeEach
    public void setupBefore() {
    System.out.println("Incepem procesul de autentificare...");
        authenticate(); 
        
    }

    @Test
    public void deleteFirstContact() {
    
        System.out.println("Se trimite cererea GET pentru obtinerea contactelor...");
        Response getResponse = RestAssured.given()
            .contentType(ContentType.JSON)
            .header("Authorization", "Bearer " + authToken)
            .get(baseurl);

        
        Assertions.assertEquals(200, getResponse.getStatusCode(), "Eroare la obținerea contactelor");

        
        firstContactId = getResponse.jsonPath().getString("[0]._id");

        
        Assertions.assertNotNull(firstContactId, "[FAIL] Primul contact nu a fost găsit!");

        System.out.println("Se trimite cererea DELETE pentru stergerea contactului cu ID-ul: ");
        Response deleteResponse = RestAssured.given()
            .contentType(ContentType.JSON)
            .header("Authorization", "Bearer " + authToken)
            .delete(baseurl + "/" + firstContactId); // Ștergem contactul cu ID-ul obținut

        // Verificăm dacă ștergerea a fost realizată cu succes (status code 204)
        Assertions.assertEquals(200, deleteResponse.getStatusCode(), "[FAIL] Eroare la ștergerea contactului");
        System.out.println("Contactul cu ID-ul " + firstContactId + " a fost sters cu succes!");
    }
}
