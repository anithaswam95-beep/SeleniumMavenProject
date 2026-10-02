package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

    WebDriver driver;

    @Parameters("browserName")
    @BeforeClass
    public void setUp(@Optional("Chrome") String browserName) {

        if (browserName.equalsIgnoreCase("Chrome")) {

            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("Edge")) {

            driver = new EdgeDriver();

        } else if (browserName.equalsIgnoreCase("Firefox")) {

            driver = new FirefoxDriver();

        } else {

            throw new IllegalArgumentException(
                    "Browser is not supported: " + browserName);
        }

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @Test(priority = 1)
    public void verifyTitle() {

        String actualTitle = driver.getTitle();

        String expectedTitle = "Web form";

        Assert.assertEquals(actualTitle, expectedTitle);

        System.out.println("Title test passed");
    }

    @Test(priority = 2)
    public void enterText() {

        driver.findElement(By.name("my-text"))
                .sendKeys("Hello Selenium");

        System.out.println("Text entered successfully");
    }

    @Test(priority = 3)
    public void submitForm() {

        driver.findElement(By.cssSelector("button"))
                .click();

        String message = driver.findElement(By.id("message"))
                .getText();

        Assert.assertEquals(message, "Received!");

        System.out.println("Form submitted successfully");
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}