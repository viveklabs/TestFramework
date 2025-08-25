package Interview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SeleniumPractice {

    WebDriver driver;
    private final String downloadPath = "/Users/vivekpeak";

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--safebrowsing-disable-download-protection");
        options.addArguments("--no-sandbox");

        Map<String,Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", new File(downloadPath).getAbsolutePath());
        prefs.put("download.prompt_for_download", false);
        prefs.put("plugins.always_open_pdf_externally", true);
        options.setExperimentalOption("prefs",prefs);
        driver = new ChromeDriver(options);
    }

    @Test
    public void checkTabs() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        driver.switchTo().frame("iframeResult");
        WebElement button = driver.findElement(By.xpath("//button[text()='Try it']"));
        button.click();
        button.click();
        button.click();
        button.click();
        try {
            wait.until(ExpectedConditions.numberOfWindowsToBe(4));
            System.out.println("Number of tabs are 4");
        }catch (Exception e) {
            System.out.println("Number of tabs are not 4");
        }

        Set<String> windowsHandles = driver.getWindowHandles();
        if (windowsHandles.size() > 4){
            System.out.println("Number of tabs are more than 4");
        }
    }

    @Test
    public void downloadFIle() throws InterruptedException, IOException {
        driver.get("https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf");
        String fileName = "dummy.pdf";
        Path filePath = Paths.get(downloadPath, fileName);
        long timeout = 20;
        long startTimeInMilliSec = System.currentTimeMillis();

        while (System.currentTimeMillis() - startTimeInMilliSec < timeout * 1000) {
            if (Files.exists(filePath) && Files.size(filePath)>0){
                if (!filePath.endsWith("crdownload")){
                    System.out.println("Download is complete");
                    break;
                }
            }
            Thread.sleep(500);
        }
    }

    @Test
    public void handleAuthPopup (){
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        System.out.println(driver.getTitle());
    }

    @Test
    public void getAutoCompleteSuggestions() {

        driver.get("https://www.amazon.com");
        driver.findElement(By.xpath("//button[text()='Continue shopping']")).click();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("car");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By allSuggestions = By.xpath("//div[contains(@id,'suggestion-row') and @role='row']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(allSuggestions));
        List<WebElement> allSuggestionsText = driver.findElements(allSuggestions);
        for (WebElement e : allSuggestionsText) {
            System.out.println(e.getText());
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
