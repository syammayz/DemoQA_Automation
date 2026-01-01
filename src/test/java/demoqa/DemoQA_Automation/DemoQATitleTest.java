package demoqa.DemoQA_Automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoQATitleTest {

    @Test
    public void verifyHomePageTitle() {

        // Correct declaration
        WebDriver driver;

        // GeckoDriver path
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");

        // Correct assignment
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/");

        String expectedTitle = "DEMOQA";
        String actualTitle = driver.getTitle();

        System.out.println("Actual Title: " + actualTitle);

        Assert.assertEquals(actualTitle, expectedTitle);

        driver.quit();
    }
}
