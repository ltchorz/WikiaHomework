package testPack;

import org.testng.annotations.Test;

import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.openqa.selenium.By;


//import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
		
  @Parameters ({"username", "password"})
  @Test
  public void testLogin(String username, String password) {
	  
	  HomePage hPage = new HomePage(driver);
	  // check if url correct
	  Assert.assertEquals(driver.getCurrentUrl(), "http://qm-homework.wikia.com/wiki/QM_HomeWork_Wikia");
	  // hover over login dropdown menu
	  hPage.hoverMouseOverSignIn();
	  // test if login form is visible
	  Assert.assertTrue(hPage.isElementPresent(By.id("AccountNavigation")));
	  // perform login
	  HomePage uPage = hPage.typeUsername(username).typePassword(password).submitLogin();
	  //test if login successfull
	  Assert.assertTrue(uPage.isElementPresent(By.cssSelector(".avatar-container.logged-avatar-placeholder")));
  }
  
}
