import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BazaApi {
    
    protected static String authToken;
    private static String authUrl = "https://thinking-tester-contact-list.herokuapp.com/users/login"; // Endpoint-ul de login
   
    private static String username = "twixuldrept@gmail.com";
    private static String password = "twixuldrept";


    protected void authenticate() {
        String loginData = "{"
                + "\"email\": \"" + username + "\","
                + "\"password\": \"" + password + "\""
                + "}";

        Response authResponse = RestAssured.given()
            .contentType(ContentType.JSON)
            .body(loginData)
            .post(authUrl);
            

    if (authResponse.getStatusCode() == 200) {
            authToken = authResponse.jsonPath().getString("token"); 
        System.out.println("Autentificare reusita! Token-ul obtinut: " + authToken);
    } else {
        System.err.println("Autentificare esuata!");
    }

       
    }
}
