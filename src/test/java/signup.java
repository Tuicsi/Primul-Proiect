import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class signup extends Baza {

   WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = Initialize();
    }

    @Test
    @DisplayName("Verifică titlul paginii principale")
    void testPageSignUp() {
       
        driver.get("https://thinking-tester-contact-list.herokuapp.com");
        String expectedTitle = "Contact List App";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle, "Titlul paginii nu este cel așteptat!");

        WebElement signupbutton = driver.findElement(By.id("signup"));
        signupbutton.click();

        WebElement fname = driver.findElement(By.id("firstName"));
        WebElement lname = driver.findElement(By.id("lastName"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement pass = driver.findElement(By.id("password"));
        
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