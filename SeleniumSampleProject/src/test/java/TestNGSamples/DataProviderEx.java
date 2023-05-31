package TestNGSamples;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderEx {
  @Test(dataProvider = "dp1")
  public void addIntegers(Integer n, Integer s) {
	  System.out.println(n+s);
  }
  
  @Test(dataProvider = "dp1")
	  public void multiplication(Integer a, Integer b) {
		  System.out.println(a*b);
	  }

  @DataProvider (name = "dp1")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, 2 },
      new Object[] { 2, 2 },
      new Object[] { 2, 2 }
      
    };
  }
}
