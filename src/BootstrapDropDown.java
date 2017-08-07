import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BootstrapDropDown {
	private WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Автоматизация\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/bootstrap/bootstrap_dropdowns.asp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void Test() {
		driver.findElement(By.xpath(".//*[@id='menu1']")).click();

		List<WebElement> bb_menu = driver.findElements(By.xpath(".//*[@class='dropdown-menu test']//li//a"));
		for(WebElement elem:bb_menu) {
			
			String innerHtml = elem.getAttribute("innerHTML");
			if(innerHtml.contentEquals("JavaScript"))
			{
				elem.click();
				break;
			}
			System.out.println("Dropdown value is " + innerHtml);
		}
	}

}
