import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Baza {
   protected WebDriver driver;

    public WebDriver Initialize() {

        // Setează locația driver-ului Chrome și configurațiile
        
        System.setProperty("webdriver.chrome.driver", "E:\\webdrivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions().setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        driver = new ChromeDriver(options);
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        return driver;
    }
}