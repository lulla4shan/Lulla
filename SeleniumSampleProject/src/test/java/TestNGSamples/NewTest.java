package TestNGSamples;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class NewTest {
	
	WebDriver driver;
	
  @Test
  public void verifySuccessfulLogin() {
	  
	  WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
	  username.sendKeys("Admin");
	  WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
	  password.sendKeys("admin123");
	  WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
	  loginBtn.click();
	  WebElement uname = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
	  Boolean actual = uname.isDisplayed();
	  Assert.assertTrue(actual);
	  
  }
  
  
  
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
	  //driver.quit();
  }

}
