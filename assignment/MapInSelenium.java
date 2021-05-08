package week3.assignment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MapInSelenium {

	public static void main(String[] args) {
		
		//Launch the browser
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				
				//Launch the URL - https://erail.in/
				driver.get("https://erail.in/");
				driver.manage().window().maximize();
				
				//Uncheck the check box - sort on date
				driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();
				
				
				//clear and type in the source station
				WebElement SrcStation = driver.findElement(By.xpath("//input[@id='txtStationFrom']"));
				SrcStation.clear();
				SrcStation.sendKeys("MAS");
				SrcStation.sendKeys(Keys.TAB);

				//clear and type in the destination station
				WebElement DstStation = driver.findElement(By.xpath("//input[@id='txtStationTo']"));
				DstStation.clear();
				DstStation.sendKeys("Bangalore Cant");
				DstStation.sendKeys(Keys.TAB);
				
				//Find all the train names using xpath and store it in a list
				WebElement GetTrains = driver.findElement(By.xpath("//input[@id='buttonFromTo']"));
				GetTrains.click();
				
				
				
				//Declare a Map
				Map<String,String>map=new HashMap<String,String>();
				
				WebElement traint = driver.findElement(By.xpath("//table[@class = 'DataTable TrainList TrainListHeader']"));
				List<WebElement> tname = traint.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr/td[2]"));
				List<WebElement> tno = traint.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr/td[1]"));
				
				for (int i = 0; i < tno.size(); i++) {
				String details = tno.get(i).getText();
				String details1 = tname.get(i).getText();
				
				if(details1.startsWith("S")) {
					map.put(details, details1);
					
				}
				
					
				}
				
				
				System.out.println(map);
	}
	

}
