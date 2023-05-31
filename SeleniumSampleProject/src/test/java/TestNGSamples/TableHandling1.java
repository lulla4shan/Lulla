package TestNGSamples;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TableHandling1 {
	
	WebDriver driver;
	
  @Test
  public void printAllValuesFromTheTable() {
	  
	  //WebElement table = driver.findElement(By.tagName("table"));
	  WebElement table = driver.findElement(By.xpath("//table"));
	  System.out.println(table.getText());
  }
  
  @Test
  public void printTheHeadingOfTheTable() {
	  
	  WebElement table3rdRow = driver.findElement(By.xpath("//table//thead"));
	  System.out.println(table3rdRow.getText());
	  
	  // print a particular heading "URL" from the table
	  
	  WebElement url = driver.findElement(By.xpath("//table//thead//tr//th[2]"));
	  System.out.println(url.getText());
	
  }
  
  @Test
  public void printValuesFrom3rdRow() {
	  
	  WebElement table3rdRow = driver.findElement(By.xpath("//table//tbody//tr[3]"));
	  System.out.println(table3rdRow.getText());
	  
	  //print a particular column value from the table (ie; 1996 from 39th row)
	  WebElement value1996 = driver.findElement(By.xpath("//table//tbody//tr[39]//td[5]"));
	  System.out.println(value1996.getText());
  }
  
  @Test
  public void printValuesFrom3rdRow4thRow() {
	  
	  WebElement table3rdRow = driver.findElement(By.xpath("//table//tbody//tr[3]"));
	  WebElement table4thRow = driver.findElement(By.xpath("//table//tbody//tr[4]"));
	 
	  System.out.println(table3rdRow.getText());
	  System.out.println(table4thRow.getText());
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://chromium.googlesource.com/chromium/src/+/master/docs/chromedriver_status.md");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
