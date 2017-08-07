package DataFromFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainTestDataFromFile {
	private WebDriver driver;
	private static String filePath="D:\\Автоматизация\\testDataFirst.txt";
	private static String filePath2="D:\\Автоматизация\\testDataFirst.txt";
	@DataProvider
	public Object[][] testData()
	{
		return new Object[][] {
			new Object[] {"Test1"}	
		};
		
	}

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Автоматизация\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://can.ua/notebooks/c1487/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
	@Test
	public void MainTest() throws IOException {
	
		CategoryPage cpage = new CategoryPage(driver);
		cpage.buttons(".//*[@id='sort-producer']//label");
		cpage.write(filePath);
		cpage.read(filePath2);
		
	
	
	}
}
