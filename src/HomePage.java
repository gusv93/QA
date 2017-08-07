import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {

	private WebDriver driver;

	public HomePage(ChromeDriver driver) {
		this.driver = driver;
	}

	public ResultPage search(String text) {

		WebElement elem = driver.findElement(By.id("lst-ib"));
		elem.sendKeys(text);
		elem.submit();
		
		return new ResultPage(driver);
	}

}
