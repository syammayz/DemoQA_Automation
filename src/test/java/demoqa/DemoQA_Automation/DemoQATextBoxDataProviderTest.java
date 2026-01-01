package demoqa.DemoQA_Automation;

import demoqa.utils.ExcelUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(demoqa.DemoQA_Automation.ExtentTestListener.class)
public class DemoQATextBoxDataProviderTest {

    @DataProvider(name = "textBoxData")
    public Object[][] getTextBoxData() throws Exception {

        String filePath = System.getProperty("user.dir")
                + "/testdata/TextBoxData.xlsx";

        return ExcelUtil.getTestData(filePath, "Sheet1");
    }

    @Test(dataProvider = "textBoxData")
    public void fillTextBoxUsingExcel(String fullName, String email,
                                      String currentAddress, String permanentAddress) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/text-box");

        driver.findElement(By.id("userName")).sendKeys(fullName);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("currentAddress")).sendKeys(currentAddress);
        driver.findElement(By.id("permanentAddress")).sendKeys(permanentAddress);
//        driver.findElement(By.id("submit")).click();
        WebElement submitBtn = driver.findElement(By.id("submit"));

       // Scroll into view
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView(true);", submitBtn);

       // Click using JavaScript (bypasses ads)
       js.executeScript("arguments[0].click();", submitBtn);

        String outputName = driver.findElement(By.id("name")).getText();
        Assert.assertTrue(outputName.contains(fullName), "Name mismatch!");

        driver.quit();
    }
}
