package Search;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainSearch {
	private WebDriver driver;

	@DataProvider
	public Object[][] testData()
	{
		return new Object[][] {
			new Object[] {"Test1"},
			new Object[] {"Test2"},
			new Object[] {"Test3"},
			new Object[] {"Test4"},
			new Object[] {"Test5"},
			new Object[] {"Test6"},
			new Object[] {"Test7"},
			new Object[] {"Test8"},
			new Object[] {"Test9"},
			new Object[] {"Test10"},
			
		};
		
	}

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Автоматизация\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com.ua");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test(dataProvider="testData")
	public void testSearch(String s) {
		HomePage home = new HomePage(driver);
		home.searchIdField("lst-ib");
		home.search(s);
		home.clear();
	
		
	}

}
