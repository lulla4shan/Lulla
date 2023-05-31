package SeleniumBasics;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindow {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent window handle : "+parentWindow);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement openNewWindowBtn = driver.findElement(By.id("newWindowBtn"));
		js.executeScript("arguments[0].scrollIntoView();", openNewWindowBtn);
		openNewWindowBtn.click();
		
		Set<String> allChildWindows = driver.getWindowHandles(); // All child windows are stored in a set of strings.
		System.out.println(allChildWindows);
		
		Iterator<String> iterator = allChildWindows.iterator(); // Here we will iterate through all child windows.
		while(iterator.hasNext())
		{
			String childWindow = iterator.next();
			if(!parentWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				
				driver.manage().window().maximize();
				
				WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
				firstName.sendKeys("ansala");
				
				Thread.sleep(5000);
				
			}
			
		}
		
		driver.switchTo().window(parentWindow);
		
		Thread.sleep(5000);
		driver.quit();
		
		
	}
}
		
	
	
