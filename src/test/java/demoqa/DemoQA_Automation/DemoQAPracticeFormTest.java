package demoqa.DemoQA_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoQAPracticeFormTest {

    @Test
    public void fillPracticeFormAndValidateSubmission() throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // Open Practice Form page directly
        driver.get("https://demoqa.com/automation-practice-form");

        // Test data
        String firstName = "John";
        String lastName  = "Doe";
        String email     = "john.doe@test.com";
        String mobile    = "9876543210";
        String address   = "123 Test Street, Test City";

        // Fill mandatory fields
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("userEmail")).sendKeys(email);

        // Select Gender - "Male"
        WebElement genderMaleLabel = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        genderMaleLabel.click();

        // Mobile number
        driver.findElement(By.id("userNumber")).sendKeys(mobile);

        // Current address
        driver.findElement(By.id("currentAddress")).sendKeys(address);

        // Select State (e.g., NCR)
        driver.findElement(By.id("state")).click();
        WebElement stateOption = driver.findElement(By.xpath("//div[@id='state']//div[text()='NCR']"));
        stateOption.click();

        // Select City (e.g., Delhi)
        driver.findElement(By.id("city")).click();
        WebElement cityOption = driver.findElement(By.xpath("//div[@id='city']//div[text()='Delhi']"));
        cityOption.click();

        // Submit form
        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();

        // Small wait to allow modal to appear (you can replace with WebDriverWait)
        Thread.sleep(2000);

        // Validate confirmation modal
        WebElement modalTitle = driver.findElement(By.id("example-modal-sizes-title-lg"));
        String modalText = modalTitle.getText();
        System.out.println("Modal Title: " + modalText);

        Assert.assertEquals(modalText, "Thanks for submitting the form", "Form submission modal title mismatch!");

        // Validate Student Name in the table
        WebElement studentNameValue = driver.findElement(By.xpath("//td[text()='Student Name']/following-sibling::td"));
        String actualStudentName = studentNameValue.getText();
        System.out.println("Student Name in Modal: " + actualStudentName);

        Assert.assertEquals(actualStudentName, firstName + " " + lastName, "Student name mismatch in modal!");

        // Close modal
        WebElement closeBtn = driver.findElement(By.id("closeLargeModal"));
        closeBtn.click();

        // Quit browser
        driver.quit();
    }
}
