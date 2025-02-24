import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ApiLogin {

    private static String authUrl = "https://thinking-tester-contact-list.herokuapp.com/users/login"; // Endpoint-ul de login
    private static String authToken; // Vom salva tokenul de autentificare

    // Detaliile de autentificare
    private static String username = "georgefranarul@gmail.com";
    private static String password = "georgefranarul";

    @Test
    public void testCreateContact() {
        // Pasul 1: Autentificare pentru a obține token-ul
        String authBody = "{"
                + "\"email\": \"" + username + "\","
                + "\"password\": \"" + password + "\""
                + "}";

        Response authResponse = RestAssured.given()
            .contentType(ContentType.JSON)
            .body(authBody)
            .post(authUrl); // Endpoint-ul de login pentru a obține token-ul

        // Verificăm dacă am obținut un răspuns 200 (OK)
        Assertions.assertEquals(200, authResponse.getStatusCode());

        // Preluăm token-ul din răspuns
        authToken = authResponse.jsonPath().getString("token");

        // Verificăm că am primit un token valid
        Assertions.assertNotNull(authToken, "Token-ul de autentificare nu a fost primit");

        // Mesaj de succes pentru autentificare
        System.out.println("Autentificare reusita. Token obtinut."); 
       
    }
}
