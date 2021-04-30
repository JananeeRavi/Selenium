package week2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws Exception {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		
	
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		
		driver.findElement(By.className("decorativeSubmit")).click();
		String text = driver.findElement(By.tagName("h2")).getText();
		driver.findElement(By.linkText("CRM/SFA")).click();
		
	
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Jananee");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
		
		String header = driver.findElement(By.xpath("//div[@id='sectionHeaderTitle_leads']")).getText();
		
		System.out.println(header);
		
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).sendKeys("Barclays");
		driver.findElement(By.xpath("(//input[@class='smallSubmit'])")).click();
		String str1 = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		System.out.println(str1);
		
		String compname = str1.replaceAll("[^a-zA-Z]", "");
		System.out.println(compname);
		
		if (compname.equals("Barclays")) {
			System.out.println("Company name updated");}
		else {
			System.out.println("Company name not updated");
		}
		
		
		
		
		
		
		

	}

}
