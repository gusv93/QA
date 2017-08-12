package Scroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScrollIntoView {

	private WebDriver driver;
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\1\\Downloads\\Q&A\\Автоматизация\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
		driver.manage().window().maximize();
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void scrollViev()
	{
		// Create instance of Javascript executor
		 
		JavascriptExecutor je = (JavascriptExecutor) driver;
		 
		 
		 
		//Identify the WebElement which will appear after scrolling down
		 
		WebElement element = driver.findElement(By.xpath(".//*[@id='mCSB_3_container']/p[3]"));
		 
		 
		 
		// now execute query which actually will scroll until that element is not appeared on page.
		 
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		 
		 
		 
		// Extract the text and verify
		 
		System.out.println(element.getText());
		 

	}
}
