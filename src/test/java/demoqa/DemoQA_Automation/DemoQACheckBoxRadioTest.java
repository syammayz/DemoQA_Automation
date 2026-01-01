package demoqa.DemoQA_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoQACheckBoxRadioTest {

    @Test
    public void verifyCheckBoxSelection() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/");

        // Click on "Elements"
        WebElement elementsCard = driver.findElement(
                By.xpath("//h5[text()='Elements']/ancestor::div[@class='card mt-4 top-card']"));
        elementsCard.click();

        // Click on "Check Box" in left menu
        WebElement checkBoxMenu = driver.findElement(By.id("item-1"));
        checkBoxMenu.click();

        // Expand all nodes
        WebElement expandAllBtn = driver.findElement(By.xpath("//button[@title='Expand all']"));
        expandAllBtn.click();

        // Select "Home" checkbox
        WebElement homeCheckbox = driver.findElement(By.xpath("//span[@class='rct-title' and text()='Home']/preceding-sibling::span[@class='rct-checkbox']"));
        homeCheckbox.click();

        // Verify "You have selected" text
        WebElement result = driver.findElement(By.id("result"));
        String resultText = result.getText();
        System.out.println("CheckBox Result: " + resultText);

        Assert.assertTrue(resultText.toLowerCase().contains("home"), "Home checkbox selection not displayed!");

        driver.quit();
    }

    @Test
    public void verifyRadioButtonSelection() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/");

        // Click on "Elements"
        WebElement elementsCard = driver.findElement(
                By.xpath("//h5[text()='Elements']/ancestor::div[@class='card mt-4 top-card']"));
        elementsCard.click();

        // Click on "Radio Button" in left menu
        WebElement radioButtonMenu = driver.findElement(By.id("item-2"));
        radioButtonMenu.click();

        // Select "Yes" radio button
        WebElement yesRadio = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        yesRadio.click();

        // Validate message
        WebElement result = driver.findElement(By.className("text-success"));
        String selectedText = result.getText();
        System.out.println("Radio Button Result: " + selectedText);

        Assert.assertEquals(selectedText, "Yes", "Radio button selection is not 'Yes'!");

        driver.quit();
    }
}
