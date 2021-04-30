package week2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		String text = driver.findElement(By.tagName("h2")).getText();
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Jananee");
		driver.findElement(By.id("lastNameField")).sendKeys("Ravi");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Jan");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("R");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("IT");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Script to create contact through automation");
		
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("123@abc.com");
		WebElement eleDropdown1=driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select d1 = new Select(eleDropdown1);
		d1.selectByVisibleText("New York");
		
		driver.findElement(By.name("submitButton")).click();
		
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Contact is created");
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		String text2 = driver.findElement(By.id("sectionHeaderTitle_contacts")).getText();
		System.out.println(text2);
		driver.close();
		
		
		
		
		

	}

}
