import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.*;


public class signup extends Baza {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = Initialize();
    }

  

    @Test
    @DisplayName("Test Signup - Verificare succes sau fail")
    void testPageSignUp() {
        driver.get("https://thinking-tester-contact-list.herokuapp.com");
        System.out.println("[INFO] Deschis pagina de signup.");

        String expectedTitle = "Contact List App";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle, "[ERROR] Titlul paginii nu este cel asteptat!");
        System.out.println("[PASS] Titlul paginii este corect.");

        WebElement signupbutton = driver.findElement(By.id("signup"));
        signupbutton.click();
        System.out.println("[INFO] Am accesat formularul de Inregistrare.");

        WebElement fname = driver.findElement(By.id("firstName"));
        WebElement lname = driver.findElement(By.id("lastName"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement pass = driver.findElement(By.id("password"));

        fname.sendKeys("Twixul2");
        lname.sendKeys("Drept2");
        email.sendKeys("twixuldrept2@gmail.com");
        pass.sendKeys("twixuldrept");

        WebElement signupsubmit = driver.findElement(By.id("submit"));
        signupsubmit.click();
        System.out.println("[INFO] Am apasat pe butonul de inregistrare.");

     
        try {
            Thread.sleep(2000); 
            WebElement errorMsg = driver.findElement(By.id("error")); 
            String errorText = errorMsg.getText();
            System.out.println("[FAIL] Eroare detectată: " + errorText);
            fail("Test eșuat: " + errorText);
        } catch (Exception e) {
            if (driver.getCurrentUrl().contains("contactList")) {
                System.out.println("[PASS] Signup reusit! Utilizator inregistrat.");
            } else {
                System.out.println("[FAIL] Nu s-a facut redirect catre pagina contactList.");
                fail("Test esuat: Nu s-a facut redirect.");
            }
        }
    }
}
