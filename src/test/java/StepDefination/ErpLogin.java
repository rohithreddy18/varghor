package StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ErpLogin {
	
	WebDriver driver;
	
	@When("^I login into stockAccounting Url on Chrome Browser$")
	public void i_login_into_stockAccounting_Url_on_Chrome_Browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.setProperty("webdriver.chrome.driver", "D:\\Ojt4oclock\\ERP_Maven\\CommonJars\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.get("http://webapp.qedge.com/");
	    driver.manage().window().maximize();
	}

	@When("^I click Reset Button on Login Page$")
	public void i_click_Reset_Button_on_Login_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("//button[@name='btnreset']")).click();
	}

	@When("^I enter admin and masterin UserNameField and PasswordField$")
	public void i_enter_admin_and_masterin_UserNameField_and_PasswordField() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   driver.findElement(By.xpath("//input[@name='username']")).clear();;
	   driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
	   driver.findElement(By.xpath("//input[@name='password']")).clear();;
	   driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
	}

	@When("^I click on Login Button$")
	public void i_click_on_Login_Button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   driver.findElement(By.xpath("//button[@name='btnsubmit']")).click();
	}

	@When("^I wait for LogoutLink$")
	public void i_wait_for_LogoutLink() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Thread.sleep(3000);
	}

	@Then("^I validate the title of the home page and close the Browser$")
	public void i_validate_the_title_of_the_home_page_and_close_the_Browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    if(driver.getTitle().contains("Dashboard « Stock Accounting	")){
	    	System.out.println("Success");
	    }
	    else{
	    	System.out.println("Fail");
	    }
	}
}
