package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase1;

public class Util extends TestBase1 {
	
     public static void switchToMainPanelFrame() {
    	 
    	 driver.switchTo().frame("mainpanel");
    	 
     }
     
   public static void mouseHoverAction(WebElement element) {
    	 
	   Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
    	 
     }
   public static void explicitwait(WebElement element, int duration) {
	   
	   WebDriverWait wait = new  WebDriverWait(driver,duration);
	   wait.until(ExpectedConditions.visibilityOf(element));
   }
}
