package week2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		

		/*1	Launch the browser
		2	Enter the username
		3	Enter the password
		4	Click Login
		5	Click crm/sfa link
		6	Click Leads link
		7	Click Find leads
		8	Click on Email
		9	Enter Email
		10	Click find leads button
		11	Capture name of First Resulting lead
		12	Click First Resulting lead
		13	Click Duplicate Lead
		14	Verify the title as 'Duplicate Lead'
		15	Click Create Lead
		16	Confirm the duplicated lead name is same as captured name
		17	Close the browser (Do not log out)*/
		
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
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("123@abc.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		String name1 = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a")).getText();
		System.out.print(name1);
		WebElement Name = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a"));
		Name.click();
		
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		String name2 = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		System.out.println(name2);
		
		
		
		if (name1.equals(name2)) {
			
			System.out.println("Duplicated lead name same as captured lead name");}
			else {
			System.out.println("Duplicated lead name is different");
		}
	}

}
