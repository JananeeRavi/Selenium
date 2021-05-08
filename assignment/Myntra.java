package week3.assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		//Open https://www.myntra.com/
		driver.navigate().to("https://www.myntra.com/");
		
		//Mouse over on WOMEN
		Actions builder = new Actions(driver);
		WebElement Women = driver.findElement(By.xpath("//a[text()='Women']"));
		builder.moveToElement(Women).build().perform();
		
		//Click Jackets & Coats
		WebElement jc = driver.findElement(By.xpath("//a[text()='Jackets & Coats']"));
		jc.click();
		
		//Find the total count of item
		String Total = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		Total=Total.replaceAll("\\D", "");
		int TotalCount = Integer.parseInt(Total);
		System.out.println("Total count :-" +TotalCount);
		
		//Validate the sum of categories count matches
		String jacketcount = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText();
		jacketcount=jacketcount.replaceAll("\\D", "");
		int jc1 = Integer.parseInt(jacketcount);
		System.out.println(jacketcount);
		
		String coatcount = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		coatcount=coatcount.replaceAll("\\D", "");
		int cc1 = Integer.parseInt(coatcount);
		System.out.println(coatcount);
		
		int categorycount = jc1+cc1;
		if (TotalCount==categorycount) {
			System.out.println("Count matched");}
		else {
			System.out.println("Count not matched");
		}
		
		//Check Coats
		WebElement checkbox = driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[2]"));
		checkbox.click();
		
		//Click + More option under BRAND
		WebElement Moreoptions = driver.findElement(By.xpath("//div[@class='brand-more']"));
		Moreoptions.click();
		
		//Type MANGO and click checkbox
		driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("MANGO");
		driver.findElement(By.xpath("//span[@class='FilterDirectory-count']/following-sibling::div[1]")).click();
		
		//Close the pop-up x
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		Thread.sleep(5000);
		
		//Confirm all the Coats are of brand MANGO
		List<WebElement> cbrand = driver.findElementsByXPath("//h3[@class='product-brand']");
		
		for (WebElement coats : cbrand) {
			String brands = coats.getText();
			System.out.println("Coat Brandname :-" +brands);
			
		}
		
		//Sort by Better Discount
		WebElement BetterDiscount = driver.findElement(By.xpath("(//div[@class='sort-sortBy'])"));
		builder.moveToElement(BetterDiscount).build().perform();
		driver.findElement(By.xpath("(//label[@class='sort-label '])[3]")).click();
		
		//Find the price of first displayed item
		String FirstItem = driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText();
		System.out.println(FirstItem);
		Thread.sleep(5000);
		
		//Mouse over on size of the first item
		WebElement Size = driver.findElement(By.xpath("(//div[@class='product-productMetaInfo'])[1]"));
		builder.moveToElement(Size).build().perform();
		Thread.sleep(5000);
		
		//Close Browser
		driver.close();
		
		
	}

}
