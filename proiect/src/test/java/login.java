import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

<<<<<<< HEAD

import static org.junit.jupiter.api.Assertions.assertEquals;
=======
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
>>>>>>> 8c82b824e9cb6017d95042bd250053ebc1d6b35f

public class login extends Baza{
    
    WebDriver driver;

    @BeforeEach
    void setUp() {
    driver = Initialize();
}

<<<<<<< HEAD
=======
  @AfterEach
    void tearDown() {
        driver.quit();
    }

>>>>>>> 8c82b824e9cb6017d95042bd250053ebc1d6b35f
    @Test
    @DisplayName("Verifică titlul paginii principale")
    void testPageSignIn() {
       
        driver.get("https://thinking-tester-contact-list.herokuapp.com");
<<<<<<< HEAD
        String expectedTitle = "Contact List App";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle, "Titlul paginii nu este cel așteptat!");
=======
        System.out.println("[INFO] Deschis pagina de login.");
        String expectedTitle = "Contact List App";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle, "[ERROR] Titlul paginii nu este cel asteptat!");
>>>>>>> 8c82b824e9cb6017d95042bd250053ebc1d6b35f

        WebElement email = driver.findElement(By.id("email"));
        WebElement pass = driver.findElement(By.id("password"));

<<<<<<< HEAD
        email.sendKeys("georgefranarul@gmail.com");
        pass.sendKeys("georgefranarul");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        
=======
        email.sendKeys("twixuldrept@gmail.com");
        pass.sendKeys("twixuldrept");
        
        System.out.println("[INFO] Am introdus datele pentru login.");
        
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        System.out.println("[INFO] Am apasat pe butonul de login.");
        
        try {
            Thread.sleep(2000);  // Așteaptă 2 secunde pentru a da timp să se încarce pagina
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String titludupalogin = driver.getTitle();
        String titlup = "My Contacts";

        if (titludupalogin.equals(titlup)) {
                System.out.println("[PASS] Login reusit!");
            } else {
                System.out.println("[FAIL] Nu s-a facut redirect catre pagina contactList.");
                fail("Test esuat: Nu s-a facut redirect.");
            }
>>>>>>> 8c82b824e9cb6017d95042bd250053ebc1d6b35f
        
        };  
    }

