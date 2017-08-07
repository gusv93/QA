package DataFromFile;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryPage {
	private WebDriver driver;
	private String xpath;
	static List<String>buttonsValue=new ArrayList<>();
	List<String>dataFromFile;
	public CategoryPage(WebDriver driver) {
		this.driver=driver;
	}
	
		public void buttons(String s) {
			this.xpath=s;
		List<WebElement>buttons=driver.findElements(By.xpath(s));
		
		
		for(int i=0;i<buttons.size();i++)
		{
			WebElement localButton = buttons.get(i);
			String valueOfbutton=localButton.getAttribute("innerHTML");	
			buttonsValue.add(valueOfbutton);
			System.out.println(valueOfbutton);
		}
			
	}
		public void write(String filePath) throws IOException {
			FileWriter fw= new FileWriter(filePath);
			try {
			
			for(String b: buttonsValue) {
				fw.write(b);
				fw.write(System.getProperty("line.separator"));
			}
			}catch(IOException e)
			{
				System.out.println(e.getMessage());
			}
			finally {
			fw.flush();
			fw.close();
			}
		}	
		
		public void read (String filePath) throws IOException{
			
			FileReader fr= new FileReader(filePath);
			dataFromFile = new ArrayList<>();
			String dataInList = null;
			Scanner scan = new Scanner(fr);
			while(scan.hasNextLine())
			{
				dataFromFile.add(scan.nextLine());
			}
			fr.close();
			for(int i=0; i<dataFromFile.size();i++)
			{
			 dataInList = dataFromFile.get(i);
			 
			}
			WebElement elem=driver.findElement(By.linkText(dataInList));
			elem.click();
		}

		
	

}
