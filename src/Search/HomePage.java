package Search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	private WebDriver driver;
	protected String searchField;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void search(String searchData) {
	WebElement elem = driver.findElement(By.id(searchField));
		elem.sendKeys(searchData);
		elem.submit();
	}

	public void searchIdField(String s) {
		this.searchField=s;
		driver.findElement(By.id(s));

	}
	public void clear()
	{
		driver.findElement(By.id(searchField)).clear();
	}
	

}
