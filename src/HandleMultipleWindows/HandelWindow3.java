package HandleMultipleWindows;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandelWindow3 {

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
		
		List<WebElement> links = driver.findElements(By.xpath(".//a[@name='link1']"));
		for(WebElement link:links)
		{
			link.click();
		}
		
		Set<String> allWindows = driver.getWindowHandles();
		
		for (String child : allWindows) {
			if (!parrentWindow.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				
				if(driver.getTitle().contains("Google"))
				{
					driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");	
					Thread.sleep(3000);
					System.out.println("title of window is " + driver.getTitle());
					driver.close();
				}
				else if(driver.getTitle().contains("Facebook"))
				{
					driver.findElement(By.xpath(".//*[@id='u_0_4']")).sendKeys("Selenium WebDriver");
					Thread.sleep(3000);
					System.out.println("title of window is " + driver.getTitle());
					driver.close();
				}
				else if (driver.getTitle().contains("Yahoo"))
				{
					driver.findElement(By.xpath(".//input[@name='p']")).sendKeys("Selenium WebDriver");
					Thread.sleep(3000);
					System.out.println("title of window is " + driver.getTitle());
					driver.close();
				}
				
				
			}
		}
		
		driver.switchTo().window(parrentWindow);
		System.out.println("title of window is " + driver.getTitle());

}
}
