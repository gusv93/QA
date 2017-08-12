package HandleModalWindow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandleModalWindowDemo {

	private WebDriver driver;
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\1\\Downloads\\Q&A\\Автоматизация\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://qsushi.ua/");;
		driver.manage().window().maximize();
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	@Test
	public void test () throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@class='sign-in']")).click();
		Thread.sleep(3000);
	}
}
