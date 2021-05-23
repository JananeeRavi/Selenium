package stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
	ChromeDriver driver;
	
	@Given("Launch Chrome Browser")
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
	@When("Load URL {string}")
	public void loadURL(String url) {
		driver.get(url);
	}
	@And("type username as {string}")
	public void typeUserName(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}

	@And("type password as {string}")
	public void typePassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@And("Click Login button")
	public void clickLoginButton(){
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
	}
	
	@Then("Click on Leads")
	public void clickLeads() {
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
	}
	
	@When("Click on Find Leads")
	public void findLeads() {
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
	}
	
	@And("Enter First Name as {string}")
	public void enterFirstname(String Fname) {
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(Fname);
	}
	
	@And("Click on Find Leads Button")
	public void clickFindLeadsButton() throws Exception {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
	}
	
	@And("Click on the first result")
	public void firstResult() {
		driver.findElement(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[1]")).click();
	}
	
	@And("Verify Lead")
	public void verifyLead() {
		String text = driver.findElement(By.xpath("//div[text()='View Lead']")).getText();
		System.out.println(text);
	}
	
	
	
}

