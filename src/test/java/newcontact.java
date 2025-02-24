import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class newcontact {

   WebDriver driver;

    @BeforeEach
    void setUp() {
        // Setează locația driver-ului Chrome și configurațiile
        System.setProperty("webdriver.chrome.driver", "E:\\webdrivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions().setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        driver = new ChromeDriver(options);
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        
    };

    @Test
    @DisplayName("Creeaza un nou contact")
    void newcontactpage() {
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        String expectedtitle = "Contact List App";
        String actualtitle = driver.getTitle();
        assertEquals(expectedtitle, actualtitle, "Titlul paginii nu este cel asteptat");

        WebElement addcontact = driver.findElement(By.id("add-contact"));
        addcontact.click();
            
        
    }

};


