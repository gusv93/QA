
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoToLinks {

	private WebDriver driver;
	
	@BeforeTest
	public void setUp(){
		System.setProperty("webdriver.chrome.driver",
				"D:\\Автоматизация\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void MainTest(){
		WebElement searchfield = driver.findElement(By.id("lst-ib"));
		searchfield.sendKeys("test");
		searchfield.submit();

		List<WebElement> resultLinks = driver.findElements(By.xpath(".//*[@id='rso']//h3/a"));
		

		for (int i = 0; i <= resultLinks.size(); i++) { // бежим по циклу
		    new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='rso']//h3/a"))); 

		    List<WebElement> resultLinks2 = driver.findElements(By.xpath(".//*[@id='rso']//h3/a")); // получаем снова список вебэлементов
		    resultLinks2.get(i).click(); // кликаем на нужный по индексу
		    // что-то делаем
		    driver.navigate().back();
	
	}
}
}