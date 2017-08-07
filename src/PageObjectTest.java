import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PageObjectTest {
	private ChromeDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Автоматизация\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://google.com");
	}
	@AfterTest
	public void tearDown()
	{
	driver.quit();
	}

	@Test
	public void testSearch() {

		HomePage home = new HomePage(driver);
		ResultPage result = home.search("automated testing info");
		assertTrue(result.getFirstLink().contains(".info"));

	}
}
