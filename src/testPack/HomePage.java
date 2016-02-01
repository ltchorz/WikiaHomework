package testPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

 
public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        
    }

        By usernameLocator = By.id("usernameInput");
        By passwordLocator = By.id("passwordInput");
        By loginButtonLocator = By.cssSelector("input.login-button");
        By contributeLocator = By.cssSelector("nav.wikia-menu-button");
        By addVideoItemLocator = By.xpath("//*[@id='WikiHeader']/div[1]/nav/ul/li[2]/a");
        By addVideoLocator = By.xpath("//ul[@class='WikiaMenuElement]/li");
        By avatarLocator = By.cssSelector(".avatar-container");
        
    public HomePage hoverMouseOverSignIn() {
    	Actions actions = new Actions(driver);
    	WebElement loginMenuLocator = driver.findElement(By.id("AccountNavigation"));
    	actions.moveToElement(loginMenuLocator).build().perform();
    	return this;
    }

    public HomePage typeUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
        return this;    
    }

    public HomePage typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;    
    }

    public HomePage submitLogin() {
        driver.findElement(loginButtonLocator).submit();
        return new HomePage(driver);    
    }

    // Here we could put methods for incorrect login

    // a sequence to login - to be used in the future, or other tests.
    public HomePage loginAs(String username, String password) {
    	hoverMouseOverSignIn();
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }
    
    public HomePage clickContribute() {
    	Actions actions = new Actions(driver);
    	WebElement contributeMenu = driver.findElement(contributeLocator);
    	actions.moveToElement(contributeMenu).build().perform();
    	contributeMenu.click();
    	return this;
    }
    
    public void clickMenuElement(By by) {
    	Actions actions = new Actions(driver);
    	WebElement menuItem = driver.findElement(by);
    	actions.moveToElement(menuItem).build().perform();
    	menuItem.click();
    }
    
    public boolean isElementPresent (By by) {
    	try {
    			driver.findElement(by);
    			return true;
    	} catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }
    
}