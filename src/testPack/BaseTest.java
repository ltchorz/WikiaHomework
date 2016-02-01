package testPack;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class BaseTest {
  
  public WebDriver driver;
	
  @Parameters ("browserName")
  @BeforeClass
  public void beforeClass(String browserName) throws Exception {
	  if (browserName.equalsIgnoreCase("firefox")) {
		  driver = new FirefoxDriver();
	  } else if (browserName.equalsIgnoreCase("chrome")) {
		  System.setProperty("webdriver.chrome.driver", "C:\\MyFiles\\eclipse\\chromedriver.exe");
		  driver = new ChromeDriver();
	  } else {
		  throw new Exception("Browser is not correct");
	  }
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://qm-homework.wikia.com");
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
