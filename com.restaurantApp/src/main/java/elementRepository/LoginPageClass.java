package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.GeneralUtilities;

public class LoginPageClass {
	
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	//ExcelReadClass excel = new ExcelReadClass();
	
	public LoginPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//img[starts-with(@src,'https://qalegend.com/restaurant/files')]")
	WebElement logo;
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@name='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//*[contains(text(),'admin Doe')]")
	WebElement adminDoe;
	
	public boolean isLogoDisplayed() {
		return gl.isDisplayedMethod(logo);
	}
	public void enterUsername(String uname) {
		gl.typeText(username, uname);
	}
	public void enterPassword(String pass) {
		gl.typeText(password, pass);
	}
	public String readUserName(int r, int c) throws IOException
	{
		return ExcelReadClass.readStringData(r,c);
	}
	
	public String readPassWord(int r,int c) throws IOException
	{
		return ExcelReadClass.readStringData(r, c);
	}
	
	public void clickLoginBtn() {
		gl.clickElement(loginBtn);
	}
	
	public boolean isAdminDoeDisplayed() {
		return gl.isDisplayedMethod(adminDoe);
	}

}
