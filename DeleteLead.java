package week2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws Exception {
		/*
		 
		2	
		3	
		4	
		5	
		6	
		7	
		8	
		9	Enter phone number
		10	Click find leads button
		11	Capture lead ID of First Resulting lead
		12	Click First Resulting lead
		13	Click Delete
		14	Click Find leads
		15	Enter captured lead ID
		16	Click find leads button
		17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		18	Close the browser (Do not log out)
		 */
		

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
		
		
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("6380406844");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String leadid = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).getText();
		System.out.println(leadid);
		WebElement Name = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		Name.click();
		
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadid);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String errmsg = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		System.out.println(errmsg);
		if (errmsg.equals("No records to display")) {
			System.out.println("Verified no records found");}
		else {
			System.out.println("Verified records found");
			
		}
		
		
		
		
		
		

	}

}
