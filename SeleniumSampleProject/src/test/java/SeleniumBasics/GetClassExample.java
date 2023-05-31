package SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetClassExample {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		System.out.println(driver.getClass()); // output : class org.openqa.selenium.chrome.ChromeDriver
		System.out.println(driver.getClass().getSimpleName()); // output: ChromeDriver
		
		WebElement home = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		System.out.println(home.getClass().getSimpleName());
		driver.quit();

	}

}
