package HandleMultipleWindows;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandelWindow1 {

	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\јвтоматизаци€\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.in/2017/07/multiple-window-examples.html");
		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testHandelWindow() throws InterruptedException {
		//определ€ем родительское окно
		String parrentWindow = driver.getWindowHandle();
		System.out.println("Parrent windos is " + parrentWindow);
		
		driver.findElement(By.xpath("*//a[contains(@href,'http://www.google.com')]")).click();
		
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println("Total windows " + allWindows.size());

		for (String child : allWindows) {
			if (!parrentWindow.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");
				
				Thread.sleep(3000);
			}
		}
		
		driver.switchTo().window(parrentWindow);
		System.out.println("Parrent window title is " + driver.getTitle());
	}

}
