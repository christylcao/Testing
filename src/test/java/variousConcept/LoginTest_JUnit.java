package variousConcept;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class LoginTest_JUnit {

	WebDriver driver;
	By USER_NAME_FIELD = By.id("username");
	By PASSWORD_FIELD = By.id("password");
	By SIGN_IN_FIELD = By.name("login");
	By DASHBOARD_HEADER_FIELD = By.xpath("//h2[text()=' Dashboard ']");
	
	@Before
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void posLoginTest() {
		
		//WEBELEMENT TYPE
		WebElement USER_NAME_ELEMENT = driver.findElement(By.id("username"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.id("password"));
		WebElement SIGN_IN_ELEMENT = driver.findElement(By.name("login"));
		
		
		USER_NAME_ELEMENT .clear();
		USER_NAME_ELEMENT.sendKeys("demo@techfios.com");
		PASSWORD_ELEMENT.sendKeys("abc123");
		SIGN_IN_ELEMENT.click();
		WebElement DASHBOARD_HEADER_ELEMENT = driver.findElement(By.xpath("//h2[text()=' Dashboard ']"));
		Assert.assertTrue("Dashboard page is not available", DASHBOARD_HEADER_ELEMENT.isDisplayed());
		
		driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SIGN_IN_FIELD).click();
		driver.findElement(DASHBOARD_HEADER_FIELD);
		Assert.assertTrue("Dashboard page is not available", driver.findElement(DASHBOARD_HEADER_FIELD).isDisplayed());
	
		
	}
	//@Test
	public void negLoginTest() {
	
		driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123444");
		driver.findElement(SIGN_IN_FIELD).click();
		driver.findElement(DASHBOARD_HEADER_FIELD);
		Assert.assertTrue("Dashboard page is not available", driver.findElement(DASHBOARD_HEADER_FIELD).isDisplayed());
		
	}
	
	//@After
		public void tearDown() throws InterruptedException {
			
			Thread.sleep(3000);
			driver.close();
}
}