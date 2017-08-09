package Verify;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyErrorMessage2 {

	private WebDriver driver;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Автоматизация\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://gmail.com");
		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void main() throws InterruptedException
	{
		driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
		
		Thread.sleep(2000);
		
		String actualError=driver.findElement(By.xpath(".//*[@id='view_container']/form/div[2]/div/div[1]/div[1]/div/div[2]/div[2]")).getAttribute("innerHTML");
		String expectedError = "Введите адрес электронной почты или номер телефона";
		//type 1
		Assert.assertEquals(actualError, expectedError);
		//type 2
		Assert.assertTrue(actualError.contains("Вasd"));
		
		System.out.println("Test complete");
	}
	
}
