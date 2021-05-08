package week3.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSort {

	public static void main(String[] args) {
		
		//Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Launch the URL - https://erail.in/
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		
		
		//clear and type in the source station
		WebElement SrcStation = driver.findElement(By.xpath("//input[@id='txtStationFrom']"));
		SrcStation.clear();
		SrcStation.sendKeys("MAS");
		SrcStation.sendKeys(Keys.TAB);

		//clear and type in the destination station
		WebElement DstStation = driver.findElement(By.xpath("//input[@id='txtStationTo']"));
		DstStation.clear();
		DstStation.sendKeys("PUNE");
		DstStation.sendKeys(Keys.TAB);
		
		//Find all the train names using xpath and store it in a list
		WebElement GetTrains = driver.findElement(By.xpath("//input[@id='buttonFromTo']"));
		GetTrains.click();
		
		//Uncheck the check box - sort on date
		driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();
		
		//Find all the train names using xpath and store it in a list
		List<WebElement> trainname = driver.findElements(By.xpath("//table[@class = 'DataTable TrainList TrainListHeader']//td[2]"));
		List<String>lst=new ArrayList<String>();
		
		for (int i = 0; i < trainname.size(); i++) {
			String lst1 = trainname.get(i).getText();
			lst.add(lst1);
			
		}
		Collections.sort(lst);
		System.out.println(lst);
		
		driver.close();
	
	
	
	}
		
	
		
		
		
		

}
