package testPack;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;


public class AddVideo {
	private final WebDriver driver;

    public AddVideo(WebDriver driver) {
        this.driver = driver;
    }
    
    By inputLocator = By.id("wpWikiaVideoAddUrl");
    By submitLocator = By.cssSelector("input[value=Add]");
    
    public AddVideo typeURL (String videoUrl) {
    	driver.findElement(inputLocator).sendKeys(videoUrl);
    	return this;
    }
    
    public void clickAdd () {
    	driver.findElement(submitLocator).click();
    }
    
    public void clickLink (By link) {
    	driver.findElement(link).click();
    }
    
    public String getMsgText() {
    	return 	driver.findElement(By.cssSelector(".msg")).getText();
    }
    
    

}
