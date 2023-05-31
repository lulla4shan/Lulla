package TestNGSamples;
import org.testng.annotations.Test;

public class TestNGBasics {
	
	@Test(priority = 2)
	public void testCase01() {
		System.out.println("Test case 1 executed");
	}

	@Test(priority = 3)
	public void testCase02() {
		System.out.println("Test case 2 executed");
	}

	@Test(priority = 1)
	public void testCase03() {
		System.out.println("Test case 3 exedcuted");
	}
}
