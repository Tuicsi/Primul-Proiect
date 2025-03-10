import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;

public class login extends Baza{
    
    WebDriver driver;

    @BeforeEach
    void setUp() {
    driver = Initialize();
}

  @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Verifică titlul paginii principale")
    void testPageSignIn() {
       
        driver.get("https://thinking-tester-contact-list.herokuapp.com");
        System.out.println("[INFO] Deschis pagina de login.");
        String expectedTitle = "Contact List App";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle, "[ERROR] Titlul paginii nu este cel asteptat!");

        WebElement email = driver.findElement(By.id("email"));
        WebElement pass = driver.findElement(By.id("password"));

        email.sendKeys("georgefranarul@gmail.com");
        pass.sendKeys("georgefranarul");
        
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
        
        };  
    }

