package demoqa.DemoQA_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoQAUploadDownloadTest {

    @Test
    public void uploadFileAndVerify() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/upload-download");

       
        String filePath = "/Users/syam/Downloads/testfile.txt";

        WebElement uploadInput = driver.findElement(By.id("uploadFile"));
        uploadInput.sendKeys(filePath);

        WebElement uploadedPathText = driver.findElement(By.id("uploadedFilePath"));
        String uploadedText = uploadedPathText.getText();
        System.out.println("Uploaded Text: " + uploadedText);

        // Basic validation - uploaded text contains file name
        Assert.assertTrue(uploadedText.contains("testfile.txt"), "Uploaded file name not displayed!");

        driver.quit();
    }

    @Test
    public void verifyDownloadButton() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/upload-download");

        WebElement downloadButton = driver.findElement(By.id("downloadButton"));
        Assert.assertTrue(downloadButton.isDisplayed(), "Download button is not displayed!");
        Assert.assertTrue(downloadButton.isEnabled(), "Download button is not enabled!");

        // Click download (file will be downloaded to browser's default location)
        downloadButton.click();

        // We won't validate file on disk here (needs OS-level checks)
        System.out.println("Download button clicked successfully.");

        driver.quit();
    }
}
