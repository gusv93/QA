package ScreenShots;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import library.Utility;

public class FacebookScreenshot {
	 WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Автоматизация\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://facebook.com");
		driver.manage().window().maximize();
	}
	//делает скрин если тест падает
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenshot(driver, result.getName());
		}
		
		driver.quit();
	}

	@Test
	public void captureScreenshot() throws IOException {
		//делает скриншот, сам метод описан в пакете library
		Utility.captureScreenshot(driver, "BrowserStarted");
		driver.findElement(By.xpath(".//*[@id='emailasd']")).sendKeys("Lear Automation");
	
	}
}
