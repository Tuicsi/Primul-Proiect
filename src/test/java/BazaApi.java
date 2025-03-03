import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BazaApi {
    
    protected static String authToken;
    private static String authUrl = "https://thinking-tester-contact-list.herokuapp.com/users/login"; // Endpoint-ul de login
   
    private static String username = "georgefranarul@gmail.com";
    private static String password = "georgefranarul";


    protected void authenticate() {
        // Autentificare pentru a obține token-ul
        String loginData = "{"
                + "\"email\": \"" + username + "\","
                + "\"password\": \"" + password + "\""
                + "}";

        Response authResponse = RestAssured.given()
            .contentType(ContentType.JSON)
            .body(loginData)
            .post(authUrl);
            

    if (authResponse.getStatusCode() == 200) {
            authToken = authResponse.jsonPath().getString("token");  // presupunem că token-ul se află în câmpul "token"
        System.out.println("Autentificare reușită! Token-ul obținut: " + authToken);
    } else {
        System.err.println("Autentificare eșuată!");
    }

       
    }
}