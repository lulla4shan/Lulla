package executeClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPageClass;
import executeClasses.DataProviderClass;

public class LoginPageExecuteClass extends BaseClass {
	
	LoginPageClass lp;
	
  @Test
  public void verifyTheLogoIsDisplayedOrNot() {
	  lp = new LoginPageClass(driver);
	  boolean actual = lp.isLogoDisplayed();
	  Assert.assertTrue(actual);
  }
  
  @Test
  public void verifySuccessfulLogin() throws IOException {
	  lp = new LoginPageClass(driver);
	  lp.enterUsername(lp.readUserName(0, 0));
	  lp.enterPassword(lp.readPassWord(1, 0));
	  lp.clickLoginBtn();
	  boolean actual = lp.isAdminDoeDisplayed();
	  Assert.assertTrue(actual);
  }
  
  @Test(dataProvider = "DataProvider",dataProviderClass = DataProviderClass.class)
  public void verifyUnsuccessfulLogin(String name, String passwd) {
	  lp = new LoginPageClass(driver);
	  lp.enterUsername(name);
	  lp.enterPassword(passwd);
	  lp.clickLoginBtn();
	  boolean actual = lp.isAdminDoeDisplayed();
	  Assert.assertFalse(actual);
  }
  
  
}
