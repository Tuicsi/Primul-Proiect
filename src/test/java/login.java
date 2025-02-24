import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class login {

   WebDriver driver;

    @BeforeEach
    void setUp() {
        // Setează locația driver-ului Chrome și configurațiile
        System.setProperty("webdriver.chrome.driver", "E:\\webdrivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions().setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        driver = new ChromeDriver(options);
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        
    }

    @Test
    @DisplayName("Verifică titlul paginii principale")
    void testPageSignUp() {
       
        driver.get("https://thinking-tester-contact-list.herokuapp.com");
        String expectedTitle = "Contact List App";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle, "Titlul paginii nu este cel așteptat!");

        WebElement email = driver.findElement(By.id("email"));
        WebElement pass = driver.findElement(By.id("password"));

        email.sendKeys("georgefranarul@gmail.com");
        pass.sendKeys("georgefranarul");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        
        
        };  
    }

