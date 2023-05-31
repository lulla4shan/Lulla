package SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
//		WebElement frametag = driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
//		driver.switchTo().frame(frametag);
//		WebElement clickOnIframe = driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));
//		clickOnIframe.click();
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement frametag = driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
		js.executeScript("arguments[0].scrollIntoView();", frametag);

//		driver.switchTo().frame(11);
//		WebElement clickOnIframe = driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));
//		clickOnIframe.click();

		
		
		
		
		
		
		driver.switchTo().frame("a077aa5e");
		WebElement clickOnIframe = driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));
		clickOnIframe.click();
		
		
		
		
		//driver.switchTo().frame(3);
		//driver.switchTo().frame("frametag");
		//driver.switchTo().frame("a077aa5e");
		
		driver.switchTo().parentFrame(); //is equal to the  driver.switchTo().defaultContent();
		//driver.switchTo().defaultContent();
		
		

	}

}
