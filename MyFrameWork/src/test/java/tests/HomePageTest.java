package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.EaAppHomePage;

public class HomePageTest {
	WebDriver driver;

	@BeforeMethod
	public void StartUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://eaapp.somee.com/");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void CleanUp() {
		driver.close();
	}

	@Test
	public void ClickLinks() {
		EaAppHomePage hpo = new EaAppHomePage(driver);
		hpo.AboutLink().click();
		hpo.EmployeesListLink().click();
		hpo.RegistrationLink().click();
		hpo.LoginLink().click();
		hpo.HomeLink().click();
	}

	@Test
	public void HomePageTesting() {
		EaAppHomePage hpo = new EaAppHomePage(driver);
		hpo.HomeLink().click();
		hpo.RegistrationLink().click();

	}
}
