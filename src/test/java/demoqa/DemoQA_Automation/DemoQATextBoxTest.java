

package demoqa.DemoQA_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoQATextBoxTest {

    @Test
    public void fillTextBoxAndValidateOutput() {

        // Setup Firefox driver
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // Open DemoQA
        driver.get("https://demoqa.com/");

        // Click on "Elements" card
        WebElement elementsCard = driver.findElement(By.xpath("//h5[text()='Elements']/ancestor::div[@class='card mt-4 top-card']"));
        elementsCard.click();

        // Click on "Text Box" in the left menu
        WebElement textBoxMenu = driver.findElement(By.id("item-0"));   // Text Box menu
        textBoxMenu.click();

        // Test data
        String fullName      = "John Doe";
        String email         = "john.doe@test.com";
        String currentAddr   = "123 Current Street, City";
        String permanentAddr = "456 Permanent Street, City";

        // Fill in the form fields
        driver.findElement(By.id("userName")).sendKeys(fullName);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("currentAddress")).sendKeys(currentAddr);
        driver.findElement(By.id("permanentAddress")).sendKeys(permanentAddr);

        // Click Submit
        driver.findElement(By.id("submit")).click();

        // Capture output text
        String outputName    = driver.findElement(By.id("name")).getText();               // "Name:John Doe"
        String outputEmail   = driver.findElement(By.id("email")).getText();              // "Email:john.doe@test.com"
        String outputCurAddr = driver.findElement(By.xpath("//p[@id='currentAddress']")).getText();
        String outputPerAddr = driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText();

        System.out.println("Output Name: " + outputName);
        System.out.println("Output Email: " + outputEmail);
        System.out.println("Output Current Address: " + outputCurAddr);
        System.out.println("Output Permanent Address: " + outputPerAddr);

        // Assertions - verify entered vs displayed values
        Assert.assertTrue(outputName.contains(fullName), "Full Name mismatch!");
        Assert.assertTrue(outputEmail.contains(email), "Email mismatch!");
        Assert.assertTrue(outputCurAddr.contains(currentAddr), "Current Address mismatch!");
        Assert.assertTrue(outputPerAddr.contains(permanentAddr), "Permanent Address mismatch!");

        // Close browser
        driver.quit();
    }
}
