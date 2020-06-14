package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.EaAppHomePage;
import pageObjects.RegistrationPageObjects;

public class RegistrationTest {
	WebDriver driver;

	@BeforeMethod
	public void StartUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://eaapp.somee.com/");
		driver.manage().window().maximize();
		EaAppHomePage hpo = new EaAppHomePage(driver);
		hpo.RegistrationLink().click();
	}

	@AfterMethod
	public void CleanUp() {
		driver.close();
	}
	@Test
	public void RegisterPositiveTest() {
		RegistrationPageObjects rpo = new RegistrationPageObjects(driver);
		rpo.UserNameTextBox().sendKeys("autoTe");
		rpo.PassWordTestBox().sendKeys("Welcome12@");
		rpo.ConfirmPassWrodTextBox().sendKeys("Welcome12@");
		rpo.EmailTextBox().sendKeys("Auto@automation.com");
		rpo.RegisterButton().click();
		String userNameExists = rpo.UserNameExistsValidation().getText();
		Assert.assertEquals(userNameExists, "Name autoTe is already taken.");
		String emailExists = rpo.EmailExistsValidation().getText();
		Assert.assertEquals(emailExists, "Email 'Auto@automation.com' is already taken.");

	}

	@Test
	public void RegisterNegativeWithNoConfirmPwd() {
		RegistrationPageObjects rpo = new RegistrationPageObjects(driver);
		rpo.UserNameTextBox().sendKeys("autoTest");
		rpo.PassWordTestBox().sendKeys("Welcome12@");
		rpo.EmailTextBox().sendKeys("Automation@automation.com");
		rpo.RegisterButton().click();
		String cpwdError = rpo.ConfirmPwdNotMatching().getText();
		Assert.assertEquals(cpwdError, "The password and confirmation password do not match.");
	}

	@Test
	public void RegisterNegativeWithNoEmail() {
		RegistrationPageObjects rpo = new RegistrationPageObjects(driver);
		rpo.UserNameTextBox().sendKeys("autoTest");
		rpo.PassWordTestBox().sendKeys("Welcome12@");
		rpo.ConfirmPassWrodTextBox().sendKeys("Welcome12@");
		rpo.RegisterButton().click();
		String emailError = rpo.EmailRequiredValidation().getText();
		Assert.assertEquals(emailError, "The Email field is required.");
	}
}
