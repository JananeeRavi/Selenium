package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {
	

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		//driver.manage().window().maximize();
		
		
		//Open https://www.nykaa.com/
		driver.navigate().to("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Mouseover on Brands and Mouseover on Popular
		Actions builder = new Actions(driver);
		WebElement Brands = driver.findElement(By.xpath("//a[text()='brands']"));
		builder.moveToElement(Brands).build().perform();
		WebElement Popular = driver.findElement(By.xpath("//a[text()='Popular']"));
		builder.moveToElement(Popular).build().perform();
		
		//Click L'Oreal Paris
		driver.findElement(By.xpath("//img[@src='https://adn-static2.nykaa.com/media/wysiwyg/2019/lorealparis.png']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>lst=new ArrayList<String>(windowHandles);
		driver.switchTo().window(lst.get(1));
		
		//Go to the newly opened window and check the title contains L'Oreal Paris
		String title = driver.getTitle();
		System.out.println(title);

		
		//Click sort By and select customer top rated
		WebElement SortBy = driver.findElement(By.xpath("//span[@title='POPULARITY']"));
		SortBy.click();
		WebElement Toprated = driver.findElement(By.xpath("//span[text()='customer top rated']"));
		Toprated.click();
		Thread.sleep(5000);
		
		//Click Category and click Shampoo
		driver.findElement(By.xpath("//div[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		
		//check whether the Filter is applied with Shampoo
		String Filter = driver.findElement(By.xpath("//li[text()='Shampoo']")).getText();
		if (Filter.contains("Shampoo")) {
			System.out.println("Filter applied");}
		else {
			System.out.println("Filter not applied");
			
		}
		
		//Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("(//span[contains(text(),'Colour Protect Shampoo')])[1]")).click();
		
		//GO to the new window and select size as 175ml(selecting 360ml as 175ml is selected by default)
		windowHandles = driver.getWindowHandles();
		lst=new ArrayList<String>(windowHandles);
		driver.switchTo().window(lst.get(2));
		driver.findElement(By.xpath("//span[text()='360ml']")).click();
		
		
		//Print the MRP of the product
		String text = driver.findElement(By.xpath("(//span[@class='post-card__content-price-offer'])[1]")).getText();
		text=text.replaceAll("\\D", "");
		int MRP = Integer.parseInt(text);
		System.out.println("MRP of the product is :-" +MRP);
		
		//Click on ADD to BAG
		driver.findElement(By.xpath("(//button[@class='combo-add-to-btn prdt-des-btn js--toggle-sbag nk-btn nk-btn-rnd atc-simple m-content__product-list__cart-btn  '])[1]")).click();
		
		//Go to Shopping Bag
		driver.findElement(By.xpath("//div[@class='AddBagIcon']")).click();
		Thread.sleep(1000);
		
		//Print the Grand Total amount
		String text2 = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		text2=text2.replaceAll("\\D", "");
		int GrandTotal = Integer.parseInt(text2);
		System.out.println("GrandTotal of the product is :-" +GrandTotal);
		
		//Click Proceed
		//driver.findElement(By.xpath("//div[@class='close']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		
		
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		
		String text3 = driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
		text3=text3.replaceAll("\\D", "");
		int GrandTotal1 = Integer.parseInt(text3);
		System.out.println("MRP of the product is :-" +GrandTotal1);
		
		if (GrandTotal==GrandTotal1) {
			
			System.out.println("Price matches");}
		else {
			System.out.println("Price do not match");
		}
			
			
		}
		
		
		
		
		
	}


