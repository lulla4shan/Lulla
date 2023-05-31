package TestNGSamples;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicAnnotations {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://qabible.in/payrollapp/");
		driver.manage().window().maximize();

	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

	@Test
	public void testCase01() {
		String expURL = "https://qabible.in/payrollapp/1";
		String actURL = "https://qabible.in/payrollapp/";
		//Assert.assertEquals(actURL, expURL, "Expected URL is not equal to the Actual ...");
		SoftAssert sf = new SoftAssert();
		sf.assertEquals(actURL, expURL, "Expected URL is not equal to the Actual ...");
		sf.assertAll();
		System.out.println("passed");
		

	}

	@Test() // this test case will not run , because i give enabled=false. otherwise it will
							// run
	public void testCase02() {
		//System.out.println(driver.getTitle());
		Assert.assertNull(driver);
	}
}
