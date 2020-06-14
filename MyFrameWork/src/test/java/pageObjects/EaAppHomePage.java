package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EaAppHomePage {
	WebDriver driver = null;

	public EaAppHomePage( WebDriver driver) {
		this.driver = driver;
	}

	By homeLink = By.xpath("//ul[1]//li[1]//a[1]");
	By aboutLink = By.linkText("About");
	By employeeListLink = By.linkText("Employee List");
	By registerLink = By.linkText("Register");
	By loginLink = By.linkText("Login");

	public WebElement HomeLink() {
		return driver.findElement(homeLink);
	}

	public WebElement AboutLink() {
		return driver.findElement(aboutLink);
	}

	public WebElement EmployeesListLink() {
		return driver.findElement(employeeListLink);
	}

	public WebElement RegistrationLink() {
		return driver.findElement(registerLink);
	}

	public WebElement LoginLink() {
		return driver.findElement(loginLink);
	}
}
