package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testngPractice.DataForTesting;

public class SauceDemoExcelTest {
	
	WebDriver driver;
	
	
	@BeforeMethod(alwaysRun = true)
	public void setUp()
	{		
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.saucedemo.com/");
	}
	
	@Test(priority=1, dataProvider="LoginData", dataProviderClass=DataForTesting.class)
	public void verifyLogin(String userName, String password, String expectedResult)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));  
		
		WebElement userNameField = wait.until(
				ExpectedConditions.visibilityOfElementLocated(
						By.id("user-name")));
		
		userNameField.sendKeys(userName);
		
		WebElement passwordField = wait.until(
				ExpectedConditions.visibilityOfElementLocated(
						By.id("password")));
		
		passwordField.sendKeys(password);
		
		WebElement loginButton = wait.until(
				ExpectedConditions.elementToBeClickable(
						By.id("login-button")));
		
		loginButton.click();
		
		Boolean expected = Boolean.parseBoolean(expectedResult);
		
		boolean actualUrl = driver.getCurrentUrl().contains("/inventory.html");
		
		Assert.assertEquals(
				actualUrl,
				expected,
				"Login Validation is not successful");
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void quit()
	{
		driver.quit();
	}
}