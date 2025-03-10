<<<<<<< HEAD
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class signup extends Baza {

   WebDriver driver;
 
   
=======
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.*;


public class signup extends Baza {

    WebDriver driver;

>>>>>>> 8c82b824e9cb6017d95042bd250053ebc1d6b35f
    @BeforeEach
    void setUp() {
        driver = Initialize();
    }

<<<<<<< HEAD
    @Test
    @DisplayName("Verifică titlul paginii principale")
    void testPageSignUp() {
       
        driver.get("https://thinking-tester-contact-list.herokuapp.com");
        String expectedTitle = "Contact List App";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle, "Titlul paginii nu este cel așteptat!");

        WebElement signupbutton = driver.findElement(By.id("signup"));
        signupbutton.click();
=======
    @AfterEach
    void tearDown() {
        driver.quit();
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
>>>>>>> 8c82b824e9cb6017d95042bd250053ebc1d6b35f

        WebElement fname = driver.findElement(By.id("firstName"));
        WebElement lname = driver.findElement(By.id("lastName"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement pass = driver.findElement(By.id("password"));
<<<<<<< HEAD
        
        fname.sendKeys("George");       
        lname.sendKeys("Franarul");        
        email.sendKeys("georgefranarul@gmail.com");        
        pass.sendKeys("georgefranarul");  

        WebElement signupsubmit = driver.findElement(By.id("submit"));      
        signupsubmit.click();

        if (driver.getCurrentUrl().contains("contactList")) {
            System.out.println("Signup reusit!");
        } else {
            System.out.println("Signup a zis nuu azi");
        }

        };  
    }

=======

        fname.sendKeys("Twixul");
        lname.sendKeys("Drept");
        email.sendKeys("twixuldrept@gmail.com");
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
>>>>>>> 8c82b824e9cb6017d95042bd250053ebc1d6b35f
