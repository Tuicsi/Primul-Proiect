import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ApiUpdateContact extends ApiCreateContact {


@BeforeEach
    public void setupBeforeUpdate() {
        
        if (createdContactId == null) {
            createContact(); 
        }
    }

    public void createContact() {
        // Dacă contactul a fost deja creat, nu mai facem nimic
        if (createdContactId != null) {
            System.out.println("Contact-ul este deja creat, uite aici ID-ul: " + createdContactId);
            return; // Nu mai creăm contactul
        }

        // Datele pentru crearea contactului
        String contactData = "{"
                + "\"firstName\": \"John\","
                + "\"lastName\": \"Doe\","
                + "\"phone\": \"0721112233\","
                + "\"city\": \"Bucuresti\""
                + "}";

        // Trimitem cererea de creare a contactului
        Response createResponse = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + authToken)
                .body(contactData)
                .post(baseurl);

        // Verificăm dacă răspunsul este 201 (Created)
        Assertions.assertEquals(201, createResponse.getStatusCode(), "Crearea contactului a eșuat!");

        // Obținem ID-ul contactului creat
        createdContactId = createResponse.jsonPath().getString("_id");

        // Verificăm că ID-ul este valid
        Assertions.assertNotNull(createdContactId, "ID-ul contactului nu a fost setat corect!");

        System.out.println("Contactul a fost creat cu ID-ul: " + createdContactId);
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
