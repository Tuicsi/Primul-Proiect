import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ApiUpdateContact extends ApiCreateContact {

    private static String baseurl = "https://thinking-tester-contact-list.herokuapp.com/contacts";

    @BeforeEach
    public void setupBeforeUpdate() {
        // Asigurăm că autentificarea și crearea contactului sunt realizate înainte de update
        if (createdContactId == null) {
            createContact(); // Dacă contactul nu este deja creat, îl creăm
        }
        authenticate(); // Autentificare o singură dată
    }

    @Test
    public void updateContact() {

        // Verificăm că ID-ul contactului este disponibil
        Assertions.assertNotNull(createdContactId, "ID-ul contactului pentru update nu este disponibil!");

        // Datele de actualizare
        String updateContact = "{"
                + "\"firstName\": \"Ionel\","
                + "\"lastName\": \"Popescu\","
                + "\"phone\": \"072222233\","
                + "\"city\": \"Bucuresti\""
                + "}";

        // Trimitem cererea de actualizare a contactului
        Response updateResponse = RestAssured.given()
            .contentType(ContentType.JSON)
            .header("Authorization", "Bearer " + authToken)
            .body(updateContact)
            .patch(baseurl + "/" + createdContactId);

        // Verificăm statusul și răspunsul
        System.out.println("Status code update: " + updateResponse.getStatusCode());
        System.out.println("Response body update (formatat):\n" + updateResponse.prettyPrint());

        // Verificăm că statusul este 200 (success)
        Assertions.assertEquals(200, updateResponse.getStatusCode(), "Eroare la actualizarea contactului!");

        // Verificăm că datele au fost actualizate corect
        String updatedFirstName = updateResponse.jsonPath().getString("firstName");
        String updatedPhone = updateResponse.jsonPath().getString("phone");

        // Confirmăm că valorile sunt corecte
        Assertions.assertEquals("Ionel", updatedFirstName, "Prenumele nu a fost actualizat!");
        Assertions.assertEquals("072222233", updatedPhone, "Telefonul nu a fost actualizat!");

        System.out.println("Contactul a fost actualizat cu succes!");
    }
}
