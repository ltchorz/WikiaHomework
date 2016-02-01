package testPack;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;



public class AddVideoTest extends BaseTest {
	
	
  @Test
  public void testAddVideo() throws InterruptedException {
	  
	  String fileName = "H2O What Happened";
	  // navigate to home page
	  // Navigate to http://qm-homework.wikia.com
	  driver.get("http://qm-homework.wikia.com");
	  Assert.assertEquals(driver.getCurrentUrl(), "http://qm-homework.wikia.com/wiki/QM_HomeWork_Wikia");
	  
	  HomePage uPage = new HomePage(driver);
	  
	  // Left click on Contribute button
	  // Contribute drop-down expanded
	  uPage.clickContribute();
	  Assert.assertTrue(uPage.isElementPresent(By.cssSelector("a[data-id='wikiavideoadd']")));
	  // Left click on Add Video button
	  uPage.clickMenuElement(uPage.addVideoItemLocator);
	  // User is redirected to the WikiaVideoAdd page http://qm-homework.wikia.com/wiki/Special:WikiaVideoAdd
	  Assert.assertEquals(driver.getCurrentUrl(), "http://qm-homework.wikia.com/wiki/Special:WikiaVideoAdd");
	  //Type URL to video from youtube into the “Video URL” field and left click the “Add” button e.g. url http://www.youtube.com/watch?v=h9tRIZyTXTI
	  ////Flash message with text: “Video page File:FILENAME was successfully added.” is displayed near the top of the page
	  AddVideo addPage = new AddVideo(driver);
	  
	  addPage.typeURL("https://youtu.be/c1kgZLgWpb8").clickAdd();
	  
	  Assert.assertEquals(addPage.getMsgText(), "Video page File:"+fileName+" was successfully added.");
	  
	  // Left click the link to file on the flash message
	  // User is redirected to the http://qm-homework.wikia.com/wiki/File:FILENAME page
	  
	  addPage.clickLink(By.linkText(fileName));
	  
	  Assert.assertEquals(driver.getCurrentUrl(), "http://qm-homework.wikia.com/wiki/File:"+fileName.replaceAll(" ", "_"));
	  
  }


  @BeforeMethod
  public void beforeTest() {
	  HomePage uPage = new HomePage(driver);
	  uPage.loginAs("ltchorz", "SuperSecretPassword");
  }

}
