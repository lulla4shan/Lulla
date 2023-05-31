package SeleniumBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
	
	public static void main(String args[]) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\git\\TestProject\\FirstMavenProject\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//WebDriverManager.firefoxdriver().setup();
//		WebDriver driver = new FirefoxDriver();
		
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
				
		driver.get("https://selenium.obsqurazone.com/select-input.php");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement selectInput = driver.findElement(By.xpath("//a[text()='Select Input']"));
		//selectInput.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", selectInput);
		
		WebElement selectColorDropdown = driver.findElement(By.xpath("//select[@id='single-input-field']"));
		selectColorDropdown.click();
		
		Select select = new Select(selectColorDropdown);
		
		//select.selectByIndex(3);
		//select.selectByValue("Red");
		select.selectByVisibleText("Yellow");
		
		//js.executeScript("window.scrollBy(0,1000)");
		driver.manage().window().minimize();
		
		//driver.close();
	}

}
