import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;

public class newcontact extends Baza{

    @BeforeEach
    void setUp() {
        driver = Initialize();
        login();
    };

      @AfterEach
    void tearDown() {
        driver.quit();
    }

    void login() {
        System.out.println("[INFO] Deschis pagina de login.");
        driver.get("https://thinking-tester-contact-list.herokuapp.com");
        WebElement email = driver.findElement(By.id("email"));
        WebElement pass = driver.findElement(By.id("password"));
        email.sendKeys("twixuldrept@gmail.com");
        pass.sendKeys("twixuldrept");
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        System.out.println("[INFO] Logare efectuata cu success.");
    }

    @Test
    @DisplayName("Creeaza un nou contact")
    void newcontactpage() {
        driver.get("https://thinking-tester-contact-list.herokuapp.com/contactList");
        String expectedtitle = "My Contacts";
        String actualtitle = driver.getTitle();
        assertEquals(expectedtitle, actualtitle, "Titlul paginii nu este cel asteptat");

        System.out.println("[INFO] Accesare formular pentru adaugarea unui contact.");
        WebElement addcontact = driver.findElement(By.id("add-contact"));
        addcontact.click();
        
        WebElement submitbtn = driver.findElement(By.id("submit"));
        System.out.println("[INFO] Formular pentru adaugarea contactului deschis.");

        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        WebElement birthdate = driver.findElement(By.id("birthdate"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement phone = driver.findElement(By.id("phone"));
        WebElement street1 = driver.findElement(By.id("street1"));
        WebElement street2 = driver.findElement(By.id("street2"));
        WebElement city = driver.findElement(By.id("city"));
        WebElement stateProvince = driver.findElement(By.id("stateProvince"));
        WebElement postalCode = driver.findElement(By.id("postalCode"));
        WebElement country = driver.findElement(By.id("country"));

        firstName.sendKeys("Alexandrescu");
        lastName.sendKeys("Oicescu");
        birthdate.sendKeys("2003-11-19");
        email.sendKeys("alexandrescu.oicescu@gmail.com");
        phone.sendKeys("07222231123");
        street1.sendKeys("Aleea Pasarea in Vazduh nr 3");
        street2.sendKeys(" ");
        city.sendKeys("Buguresti");
        stateProvince.sendKeys("Romania");
        postalCode.sendKeys("011001");
        country.sendKeys("Tot pacolo");

        submitbtn.click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/table/tr[1]")));


        WebElement newContact = driver.findElement(By.xpath("/html/body/div/div/table/tr[1]"));
        assertTrue(newContact.isDisplayed(), "Contactul nu a fost găsit pe pagină!");
        System.out.println("[PASS] Contactul a fost adaugat cu succes!");
        
    }

};


