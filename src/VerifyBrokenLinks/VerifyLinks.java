package VerifyBrokenLinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyLinks {

	private WebDriver driver;
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\1\\Downloads\\Q&A\\Автоматизация\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://google.com");;
		driver.manage().window().maximize();
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	@Test
	public void verifyApptitle()
	{
		//получаем лист ссылок (а)
		List<WebElement>links = driver.findElements(By.tagName("a"));
		System.out.println("total links is " + links.size());
		
		for(int i=0; i<links.size();i++)
		{
			WebElement ele =links.get(i);
			//получаем все ссылки с атрибутом "href"
			String url = ele.getAttribute("href");
			verifyLinkActive(url);
		}
	}
	
	public static void verifyLinkActive(String linkUrl)
	{
		try {
			URL url= new URL(linkUrl);
			HttpURLConnection httpUrlConnect = (HttpURLConnection) url.openConnection();
			httpUrlConnect.setConnectTimeout(3000); //минимальное время ожидания для конекта
			httpUrlConnect.connect();
			if(httpUrlConnect.getResponseCode()==200)
			{
				System.out.println(linkUrl +" "+httpUrlConnect.getResponseMessage());
			}
			if(httpUrlConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(linkUrl+" "+httpUrlConnect.getResponseMessage()+ " - "+ HttpURLConnection.HTTP_NOT_FOUND);
				
			}
			
		}catch(Exception e)
		{
			
		}
	}
}
	
