package week2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathPractise {

	public static void main(String[] args) {
	
		/*Launch the URL*/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		
		/*Enter the username based on its label*/
		driver.findElement(By.xpath("//label[@for='username']/following-sibling::input"));
		
		/*Enter the password based on its label*/
		driver.findElement(By.xpath("//label[@for='password']/following-sibling::input"));
		
		/*Click Login*/
		driver.findElement(By.className("decorativeSubmit")).click();
		
		/*Click on CRMSFA link*/
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		/*Click on Leads link*/
		driver.findElement(By.linkText("Leads")).click();
		
		/*Click on Merge Leads link*/
		driver.findElement(By.linkText("Merge Leads")).click();
		
		/*Click the first img icon*/
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[1]")).click();
		
		/*Select the first resulting lead*/
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]")).click();
		
		/*Click the second img icon*/
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();
		
		/*Select the second resulting lead*/
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]")).click();
		
		/*Click on Merge Lead (submit) button*/
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		
		/*Get the company name text based on its label*/
		driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).click();
		
		
		
	}

}
