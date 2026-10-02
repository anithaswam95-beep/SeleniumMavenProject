package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void loginTest() {

        // Enter username
        driver.findElement(By.id("user-name"))
               .sendKeys("standard_user");

        // Enter password
        driver.findElement(By.id("password"))
               .sendKeys("secret_sauce");

        // Click Login button
        driver.findElement(By.id("login-button"))
               .click();

        // Print title and URL
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        // Verify successful login
        Assert.assertEquals(driver.getTitle(), "Swag Labs");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory.html")
        );
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}


