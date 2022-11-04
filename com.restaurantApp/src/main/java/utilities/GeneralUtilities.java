package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	
	public void clickElement(WebElement element)
	{
		element.click();
	}

	public void typeText(WebElement element , String text)
	{
		element.sendKeys(text);
	}

	public String getTextMethod(WebElement element )
	{
		return element.getText();
	}

	public boolean isDisplayedMethod(WebElement element)
	{
		return element.isDisplayed();
	}

	public boolean isSelectedMethod(WebElement element)
	{
		return element.isSelected();
	}

	public boolean isEnabledMethod(WebElement element)
	{
		return element.isEnabled();
	}

	public void addThredSleep() throws InterruptedException
	{
		Thread.sleep(5000);
	}

	public void scrollToFindAnElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
	}

	public void clickByJS(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element );
	}

	public String getcurrentUrl(WebDriver driver)
	{
		return driver.getCurrentUrl();
	}

	public void clearElement(WebElement element)
	{
		element.clear();
	}

	public void acceptAlertMsg(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

	public void selectByIndexDorpDown(WebElement element, int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectByVisibleTextDorpDown(WebElement element, String text)
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectByValueDorpDown(WebElement element, String text)
	{
		Select select = new Select(element);
		select.selectByValue(text);
	}

}
