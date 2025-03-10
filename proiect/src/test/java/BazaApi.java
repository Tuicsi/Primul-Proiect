import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BazaApi {
    
    protected static String authToken;
    private static String authUrl = "https://thinking-tester-contact-list.herokuapp.com/users/login"; // Endpoint-ul de login
   
<<<<<<< HEAD
    private static String username = "georgefranarul@gmail.com";
    private static String password = "georgefranarul";


    protected void authenticate() {
        // Autentificare pentru a obține token-ul
=======
    private static String username = "twixuldrept@gmail.com";
    private static String password = "twixuldrept";


    protected void authenticate() {
>>>>>>> 8c82b824e9cb6017d95042bd250053ebc1d6b35f
        String loginData = "{"
                + "\"email\": \"" + username + "\","
                + "\"password\": \"" + password + "\""
                + "}";

        Response authResponse = RestAssured.given()
            .contentType(ContentType.JSON)
            .body(loginData)
            .post(authUrl);
            

    if (authResponse.getStatusCode() == 200) {
<<<<<<< HEAD
            authToken = authResponse.jsonPath().getString("token");  // presupunem că token-ul se află în câmpul "token"
        System.out.println("Autentificare reușită! Token-ul obținut: " + authToken);
    } else {
        System.err.println("Autentificare eșuată!");
=======
            authToken = authResponse.jsonPath().getString("token"); 
        System.out.println("Autentificare reusita! Token-ul obtinut: " + authToken);
    } else {
        System.err.println("Autentificare esuata!");
>>>>>>> 8c82b824e9cb6017d95042bd250053ebc1d6b35f
    }

       
    }
}
