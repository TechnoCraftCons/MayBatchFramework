package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPageObjects {
	WebDriver driver = null;

	public RegistrationPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	By userName = By.id("UserName");
	By passWord = By.id("Password");
	By confirmPassWord = By.id("ConfirmPassword");
	By email = By.id("Email");
	By registerBtn = By.xpath("//div[6]//div[1]//input[1]");
	By confirmPwdNotMatching = By.xpath("//html//body//div//form//div//ul//li");
	By logOff = By.xpath("//form[@id='logoutForm']//li[2]//a[1]");
	By emailError = By.xpath("//html//body//div//form//div//ul//li");
	By userNameExists = By.xpath("//div/ul/li[contains(text(),'Name')]");
	By emailExists = By.xpath("//div/ul/li[contains(text(),'Email')]");

	public WebElement UserNameTextBox() {
		return driver.findElement(userName);
	}

	public WebElement PassWordTestBox() {
		return driver.findElement(passWord);
	}

	public WebElement ConfirmPassWrodTextBox() {
		return driver.findElement(confirmPassWord);
	}

	public WebElement EmailTextBox() {
		return driver.findElement(email);
	}

	public WebElement RegisterButton() {
		return driver.findElement(registerBtn);
	}

	public WebElement ConfirmPwdNotMatching() {
		return driver.findElement(confirmPwdNotMatching);
	}

	public WebElement LogOffLink() {
		return driver.findElement(logOff);
	}

	public WebElement EmailRequiredValidation() {
		return driver.findElement(emailError);
	}

	public WebElement EmailExistsValidation() {
		return driver.findElement(emailExists);
	}

	public WebElement UserNameExistsValidation() {
		return driver.findElement(userNameExists);
	}

}
