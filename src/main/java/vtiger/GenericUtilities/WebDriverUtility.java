/**
 * 
 */
package vtiger.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Sushma Akki
 *
 */
public class WebDriverUtility 
{
	/***
	 * This method will Maximize the window 
	 * @param driver
	 */
	public void maxiMizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/***
	 * this method will Minimize the window 
	 * @param driver
	 */
	
	public void miniMizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/***
	 * this methos used to wait for page load / Implicit wait
	 * @param driver
	 */
	
	public void waitForPageLoad(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
	/***
	 * this method is used to wait for element to be visible 
	 * @param driver
	 * @param element
	 */
	
	public void  waitForElementToBeVisible(WebDriver driver,WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/***
	 * this method is used to wait for particular element to be click 
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/***
	 * This Method used to handle the drop down using selectbyIndex
	 * @param element
	 * @param index
	 */
	
	public void handlingDropDown(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/***
	 * This Method used to handle the drop down using selectbyValue
	 * @param element
	 * @param value
	 */
	
	public void handlingDropDown(WebElement element,String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	/***
	 * This Method used to handle the drop down using selectbyvisibletext
	 * @param value
	 * @param element
	 */
	
	public void handlingDropDown(String value,WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
	}
	/***
	 * This Method used to act on the mouseover action
	 * @param driver
	 * @param element
	 */
	
	public void mouseOverAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/***
	 * this method helps us to perform the right click Action
	 * @param driver
	 */
	
	public void rightClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 *this method helps us to perform the right click Action on particular element 
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver,  WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * this method helps us to perform the double click Action 
	 * @param driver
	 */
	
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * this method helps us to perform the double click Action on particular element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,  WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * this method helps us to perform the DRAG and DROP Action
	 * @param driver
	 * @param srcElement
	 * @param destElement
	 */
	
	public void dragAndDrop(WebDriver driver,WebElement srcElement,WebElement destElement)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, destElement);
	}
	
	/**
	 * this method helps us to perform the clt+alt+del using robort class
	 * @throws Exception
	 */
	
	public void cltAltDelete() throws Exception
	{
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_ALT);
		rbt.keyPress(KeyEvent.VK_DELETE);
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		rbt.keyRelease(KeyEvent.VK_ALT);
		rbt.keyRelease(KeyEvent.VK_DELETE);		
	}
	
	/**
	 * this method helps us to perform the maximise the window using robort class
	 * @throws Exception
	 */
	
	public void maxmisewindowrbt() throws Exception
	{
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_WINDOWS);
		rbt.keyPress(KeyEvent.VK_UP);
		rbt.keyRelease(KeyEvent.VK_WINDOWS);
		rbt.keyRelease(KeyEvent.VK_UP);
	}
	
	/**
	 * this method helps us to perform the Minimise the window using robort class
	 * @throws AWTException
	 */
	public void miniMiseWindowRbt1() throws AWTException
	{
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_WINDOWS);
		rbt.keyPress(KeyEvent.VK_DOWN);
		rbt.keyRelease(KeyEvent.VK_WINDOWS);
		rbt.keyRelease(KeyEvent.VK_DOWN);
	}
	
	/**
	 * this method helps us to perform the enter key using robort class
	 * @throws AWTException
	 */

	public void pressEnterKey() throws AWTException
	{
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_ENTER);
	}
	
	/**
	 * this method helps us to perform the enter key using robort class
	 * @throws AWTException
	 */
	
	public void releaseEnterKey() throws AWTException
	{
		Robot rbt = new Robot();
		rbt.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * this method helps us to handle the Frame using index
	 * @param driver
	 * @param index
	 */
	
	public void handleFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * this method helps us to handle the Frame using nameOrID
	 * @param driver
	 * @param nameOrId
	 */
	
	public void handleFrame(WebDriver driver, String nameOrId )
	{
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * this method helps us to handle the Frame using webelement 
	 * @param driver
	 * @param element
	 */
	
	public void handleFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
/**
 * this method helps us to handle the parent Frame
 * @param driver
 */
	
	public void handleParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * this method helps us to handle the Default Frame
	 * @param driver
	 */
	
	public void handleDefaultframe(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * this method helps us to handle the alert pop up accept 
	 * @param driver
	 */
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * this method helps us to handle the alert pop up dismiss 
	 * @param driver
	 */
	
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * this method helps us to get the alert pop up text 
	 * @param driver
	 * @return
	 */
	
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * this method will switch to window based on window title 
	 * @param driver
	 * @param partialWinTitle
	 */
	
	public void getWindowHandels(WebDriver driver,String partialWinTitle )
	{
		Set<String> winIDs = driver.getWindowHandles(); //storing windows session in set
		for(String windows:winIDs) // creating for each loop to switch to windows 
		{
			 String currentTitle =driver.switchTo().window(windows).getTitle(); // getting title of all windows 
		
			 if(currentTitle.contains(partialWinTitle))//comparing required win title with the current title
			 {
				 
				 break;//stopping it from checking further 
			 }
		}
				
	}
	
	
	/**
	 * this method will take screen shot and save it in ScreenShot Folder
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShotS(WebDriver driver,String screenShotName) throws IOException
	
	{
		//Create TakeScreenshot class object
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		//adding object get the screenshot into file
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		//give file name
		File dest = new File(".\\ScreenShots\\"+screenShotName+".png");
		
		//copy file from src to dest
		//for this we have comms IO dependency 
		FileUtils.copyFile(src,dest);//common Io Dependency		
		return dest.getAbsolutePath();//we use this for external reporting
		
	}
	
	/**
	 * This method used to scroll down the page randomly
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	
	/**
	 * this method used to scroll down the page until the given element found 
	 * @param driver
	 * @param element
	 */
	
	public void scrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")",element);
	}
}
