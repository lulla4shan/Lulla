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

public class TableHandling2 {
	
	WebDriver driver;
	
	@Test
	public void verifyEdition() {
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		  username.sendKeys("admin");
		  WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		  password.sendKeys("password");
		  WebElement login = driver.findElement(By.xpath("//input[@name='submit']"));
		  login.submit();
		  
		  WebElement productTab = driver.findElement(By.xpath("//li[@class='flat-box waves-effect waves-block']/following-sibling::li[1]"));
		  productTab.click();
		  
		  WebElement searchBox = driver.findElement(By.xpath("//input[@class='form-control input-sm']"));
		  searchBox.sendKeys("apple");
		  
		  WebElement editBtn = driver.findElement(By.xpath("//a[@class='btn btn-default']/following-sibling::a[2]"));
		  editBtn.click();
		  
		  WebElement taxField = driver.findElement(By.xpath("//input[@name='tax']"));
		  taxField.clear();
		  taxField.sendKeys("5");
		  
		  WebElement submitBtn = driver.findElement(By.xpath("//button[text()='Submit']"));
		  submitBtn.submit();
		  
		  WebElement searchBox1 = driver.findElement(By.xpath("//input[@class='form-control input-sm']"));
		  searchBox1.sendKeys("apple");
		  
		  WebElement verifyRow = driver.findElement(By.xpath("//table[@id='Table']//tbody//tr"));
		  System.out.println(verifyRow.getText());
		  WebElement tax = driver.findElement(By.xpath("//table[@id='Table']//tbody//tr//td[5]"));
		  String expected = "5";
		  String actual = tax.getText();
		  Assert.assertEquals(actual, expected);
		  
	}
	
  @Test(enabled=false)
  public void tableHandling() {
	  
	  WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
	  username.sendKeys("admin");
	  WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
	  password.sendKeys("password");
	  WebElement login = driver.findElement(By.xpath("//input[@name='submit']"));
	  login.submit();
	  
	  WebElement productTab = driver.findElement(By.xpath("//li[@class='flat-box waves-effect waves-block']/following-sibling::li[1]"));
	  //  (//*[text()='Product'])[1]
	
	  productTab.click();
	  
	  /* print all values from the product table */
//	  WebElement tableFull = driver.findElement(By.xpath("//table[@id='Table']"));
//	  System.out.println(tableFull.getText());
	  
	 
//	   /* print all values from the heading of the product table */
	  WebElement tableHeadingFull = driver.findElement(By.xpath("//table[@id='Table']//thead"));
	  System.out.println("Heading : " +tableHeadingFull.getText());
//	  
//	  /* print a value ie; "Price" from the heading of the product table */
	  WebElement tableHeadingPrice = driver.findElement(By.xpath("//table[@id='Table']//thead//tr//th[6]"));
	  System.out.println("Particular heading Price from the table : "+tableHeadingPrice.getText());
//	  
//	  /* print all the values of 3rd row from the product table */
	  WebElement table3rdRow = driver.findElement(By.xpath("//table[@id='Table']//tbody//tr[3]"));
	  System.out.println("3rd row values : " +table3rdRow.getText());
//	
//	  /* print the value Category from 3rd row of the product table */
	  WebElement table3rdRowCategory = driver.findElement(By.xpath("//table[@id='Table']//tbody//tr[3]//td[3]"));
	  System.out.println("Particular value Category from 3rd row : " +table3rdRowCategory.getText()); 

	  
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://qalegend.com/restaurant/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  


}
