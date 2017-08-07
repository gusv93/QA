import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckAndRadioButtons {

	private WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Автоматизация\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-automate-radio-button-in.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void Test() {

		List<WebElement> radio = driver.findElements(By.xpath(".//*[@type='radio' and @name='lang']"));

		for (int i = 0; i < radio.size(); i++) {
			WebElement elem = radio.get(i);
			String value = elem.getAttribute("value");

			System.out.println(value);
			if (value.equalsIgnoreCase("RUBY")) {
				elem.click();
			}
		}

		List<WebElement> checkbox = driver.findElements(By.xpath(".//*[@type='checkbox' and @name='lang']"));

		for (int i = 0; i < checkbox.size(); i++) {
			WebElement local_cb = checkbox.get(i);
			String id = local_cb.getAttribute("id");

			System.out.println(id);
			if (id.equalsIgnoreCase("code")) {
				local_cb.click();
			}
		}
	}
}
