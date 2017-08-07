import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FirstTest {

	private WebDriver driver;

	
	@DataProvider
	public Object[][] testData()
	{
		return new Object[][]{
				new Object []{"Test1", "User1", "+380930563244", "qweqwe",10,"7","1993"},
				new Object []{"Test2", "User2", "+380930563244", "qweqwe",11,"5","2003"},
				new Object []{"Test3", "User3", "+380930563244", "qweqwe",7,"8","1995"},
				new Object []{"Test4", "User4", "+380930563244", "qweqwe",5,"9","1997"},
			
		};
	}
	
	@BeforeTest
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Автоматизация\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}

	@Test(dataProvider="testData")
	public void Test(String name, String lastName, String phoneNumber, String password, int day, String month, String year) {

		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("firstname")));
		
		WebElement fn =driver.findElement(By.name("firstname"));
		fn.clear();
		fn.sendKeys(name);
		WebElement ln = driver.findElement(By.name("lastname"));
		ln.clear();
		ln.sendKeys(lastName);
		WebElement pn =driver.findElement(By.name("reg_email__"));
		pn.clear();
		pn.sendKeys(phoneNumber);
		WebElement pass = driver.findElement(By.name("reg_passwd__"));
		pass.clear();
		pass.sendKeys(password);

		Select dayOfBirth = new Select(driver.findElement(By.id("day")));
		dayOfBirth.selectByIndex(day);
		Select monthOfBirth = new Select(driver.findElement(By.id("month")));
		monthOfBirth.selectByValue(month);
		Select yearOfBirth = new Select(driver.findElement(By.id("year")));
		yearOfBirth.selectByVisibleText(year);

		driver.findElement(By.id("u_0_i")).click();
		driver.findElement(By.xpath("//*[@id='reg_pages_msg']/a")).click();
		driver.navigate().back();
		//driver.navigate().refresh();
		System.out.println(driver.getTitle());
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		assertEquals("Facebook — Выполните вход или зарегистрируйтесь", driver.getTitle());
		//driver.quit();
		
	}
	}

