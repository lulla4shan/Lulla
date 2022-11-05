package executeClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPageClass;
import executeClasses.DataProviderClass;

public class LoginPageExecuteClass extends BaseClass {
	
	LoginPageClass lp;
	
  @Test(priority = 1, groups = {"group1"})
  public void verifyTheLogoIsDisplayedOrNot() {
	  lp = new LoginPageClass(driver);
	  boolean actual = lp.isLogoDisplayed();
	  Assert.assertTrue(actual);
  }
  
  @Test(priority = 2, groups = {"group2"})
  public void verifySuccessfulLogin() throws IOException {
	  lp = new LoginPageClass(driver);
	  lp.enterUsername(lp.readUserName(0, 0));
	  lp.enterPassword(lp.readPassWord(1, 0));
	  lp.clickLoginBtn();
	  boolean actual = lp.isAdminDoeDisplayed();
	  Assert.assertTrue(actual);
  }
  
  @Test(priority = 3,groups = {"group2"}, dataProvider = "DataProvider",dataProviderClass = DataProviderClass.class)
  public void verifyUnsuccessfulLogin(String name, String passwd) {
	  lp = new LoginPageClass(driver);
	  lp.enterUsername(name);
	  lp.enterPassword(passwd);
	  lp.clickLoginBtn();
	  boolean actual = lp.isAdminDoeDisplayed();
	  Assert.assertFalse(actual);
  }
  
  
}
