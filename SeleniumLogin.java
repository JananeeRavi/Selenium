package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumLogin {

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
		
				
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.className("inputBox")).sendKeys("IBM");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Jananee");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Ravi");
		
		WebElement eleDropdown1=driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dd1 = new Select(eleDropdown1);
		dd1.selectByVisibleText("Other");
		
		WebElement eleDropdown2=driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select dd2 = new Select(eleDropdown2);
		dd2.selectByVisibleText("Catalog Generating Marketing Campaigns");
		
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Jananee");
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("Ravi");
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Miss");
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("10/10/1991");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Test Specialist");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("IT Services");
		driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("8,00,000");
		
		WebElement eleDropdown3=driver.findElement(By.id("createLeadForm_currencyUomId"));
		Select dd3 = new Select(eleDropdown3);
		dd3.selectByVisibleText("BSD - Bahaman Dollar");
		
		WebElement eleDropdown4=driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select dd4 = new Select(eleDropdown4);
		dd4.selectByVisibleText("Insurance");
		
		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("8000");
		WebElement eleDropdown5=driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select dd5 = new Select(eleDropdown5);
		dd5.selectByVisibleText("LLC/LLP");
		
		driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("UT");
		driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("JR");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("This is my first automation script");
		driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("This is my first automation script");
		
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys("7");
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("1");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("6380406844");
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("044");
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Jananee");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("123@abc.com");
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("http://leaftaps.com/opentaps");
		
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Jananee");
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Ravi");
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("Addr1");
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("Addr2");
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Cary");
		
		WebElement eleDropdown6=driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select dd6 = new Select(eleDropdown6);
		dd6.selectByVisibleText("Australia");
		
		WebElement eleDropdown7=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select dd7 = new Select(eleDropdown7);
		dd7.selectByVisibleText("New South Wales");
		
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("5134607");
		
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("91");
		driver.findElement(By.className("smallSubmit")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.className("inputBox")).clear();
		driver.findElement(By.className("inputBox")).sendKeys("BARCLAYS");
		driver.findElement(By.className("smallSubmit")).click();
		
		String text2 = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println(text2);
		
		
		}
		
	}

}