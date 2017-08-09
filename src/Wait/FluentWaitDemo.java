package Wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class FluentWaitDemo {

	private WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Автоматизация\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");
		driver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void FlWait() {
		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				 
			       .withTimeout(60, TimeUnit.SECONDS)
			 
			       .pollingEvery(2, TimeUnit.SECONDS)
			 
			       .ignoring(NoSuchElementException.class);
			 
			 
			 
   WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			 
	 public WebElement apply(WebDriver driver) {
			    	 
			    	 
			WebElement ele=  driver.findElement(By.xpath(".//*[@id='demo']"));
			// Will capture the inner Text and will compare will WebDriver
			 
			// If condition is true then it will return the element and wait will be over
			    	
			    if (ele.getAttribute("innerHTML").equalsIgnoreCase("WebDriver")) 
                    {

                       System.out.println("Value is >>> " + ele.getAttribute("innerHTML"));

                        return ele;

                    }

//If condition is not true then it will return null and it will keep checking until condition is not true

else {
       System.out.println("Value is >>> " + ele.getAttribute("innerHTML"));

          return null;

      }

              }

         });

//If element is found then it will display the status

         System.out.println("Final visible status is >>>>> " + element.isDisplayed());

    }

		
		
		/*boolean status = driver.findElement(By.xpath(".//p[text()='WebDriver']")).isDisplayed();

		if (status) {
			System.out.println("Test passed");
		} else {

		}*/
	}

