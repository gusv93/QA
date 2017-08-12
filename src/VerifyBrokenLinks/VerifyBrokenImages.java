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

public class VerifyBrokenImages {

	private WebDriver driver;
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\1\\Downloads\\Q&A\\Автоматизация\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://qsushi.ua/");;
		driver.manage().window().maximize();
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	@Test
	public void verifyImg()
	{
		List<WebElement> tagImg = driver.findElements(By.tagName("img"));
		for(int i=0;i<tagImg.size();i++)
		{
			WebElement elementOfList =tagImg.get(i);
			String imgUrl = elementOfList.getAttribute("src");
			verifyImg(imgUrl);
		}
		
	}
	
	public static void verifyImg(String imageLink) {
		try {
			URL url = new URL(imageLink);
			HttpURLConnection httpUrlCon = (HttpURLConnection) url.openConnection();
			httpUrlCon.setConnectTimeout(3000);
			httpUrlCon.connect();
			if(httpUrlCon.getResponseCode()==200)
			{
				System.out.println(imageLink+" " +httpUrlCon.getResponseMessage() );
			}
			if(httpUrlCon.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
			{
				System.out.println(imageLink+" "+httpUrlCon.getResponseMessage()+ " - "+ HttpURLConnection.HTTP_NOT_FOUND);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
}
