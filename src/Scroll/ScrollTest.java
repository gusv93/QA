package Scroll;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScrollTest {
	
	private WebDriver driver;
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\1\\Downloads\\Q&A\\Автоматизация\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://jqueryui.com");;
		driver.manage().window().maximize();

		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	@Test
	public void ScrollTestCase() throws Throwable
	{
		
		 
		 // This  will scroll page 400 pixel vertical
		  ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
		  Thread.sleep(5000);
	}

}
