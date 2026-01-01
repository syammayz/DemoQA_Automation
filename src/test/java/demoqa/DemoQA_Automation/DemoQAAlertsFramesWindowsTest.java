package demoqa.DemoQA_Automation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class DemoQAAlertsFramesWindowsTest {

    @Test
    public void handleAlerts() throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/alerts");

        // Simple alert - Click Me button
        driver.findElement(By.id("alertButton")).click();
        Thread.sleep(1000);
        Alert simpleAlert = driver.switchTo().alert();
        String alertText = simpleAlert.getText();
        System.out.println("Simple Alert Text: " + alertText);
        simpleAlert.accept();

        // Confirm alert - accept & dismiss
        driver.findElement(By.id("confirmButton")).click();
        Thread.sleep(1000);
        Alert confirmAlert = driver.switchTo().alert();
        System.out.println("Confirm Alert Text: " + confirmAlert.getText());
        confirmAlert.dismiss(); // or accept()

        // Prompt alert - send text
        driver.findElement(By.id("promtButton")).click();
        Thread.sleep(1000);
        Alert promptAlert = driver.switchTo().alert();
        System.out.println("Prompt Alert Text: " + promptAlert.getText());
        promptAlert.sendKeys("Demo User");
        promptAlert.accept();

        driver.quit();
    }

    @Test
    public void handleFrames() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/frames");

        // Switch to first frame
        driver.switchTo().frame("frame1");
        String frameHeading1 = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println("Frame 1 Text: " + frameHeading1);
        Assert.assertTrue(frameHeading1.contains("This is a sample page"), "Frame 1 text mismatch!");

        // Switch back to main page
        driver.switchTo().defaultContent();

        // Switch to second frame
        driver.switchTo().frame("frame2");
        String frameHeading2 = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println("Frame 2 Text: " + frameHeading2);
        Assert.assertTrue(frameHeading2.contains("This is a sample page"), "Frame 2 text mismatch!");

        driver.quit();
    }

    @Test
    public void handleMultipleWindows() throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/browser-windows");

        String parentWindow = driver.getWindowHandle();

        // Click button to open new tab
        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(2000);

        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> it = allWindows.iterator();

        while (it.hasNext()) {
            String childWindow = it.next();
            if (!parentWindow.equals(childWindow)) {
                driver.switchTo().window(childWindow);
                String heading = driver.findElement(By.id("sampleHeading")).getText();
                System.out.println("Child Window Heading: " + heading);
                Assert.assertTrue(heading.contains("This is a sample page"), "Child window content mismatch!");
                driver.close(); // close child
            }
        }

        // Switch back to parent
        driver.switchTo().window(parentWindow);

        driver.quit();
    }
}
