package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownOperations {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://omayo.blogspot.com/");
		
		WebElement dp = driver.findElement(By.id("multiselect1"));
		dp.click();
		Select selectDp = new Select(dp);
		selectDp.selectByValue("swiftx");
		selectDp.selectByValue("audix");
		
		Thread.sleep(2000);
		selectDp.deselectAll();
		
		

	}

}
