package vtiger.Practise;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyfileUtility;
import vtiger.GenericUtilities.TestDataFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class Scenario5UsingCreatedUtilitiesMethods {

	public static void main(String[] args) throws IOException, AWTException
	{
		// TODO Auto-generated method stub
		
		//Step1: Load all the required files 

			//Calling required  Utilities methohds
			PropertyfileUtility pUtil = new PropertyfileUtility();
			TestDataFileUtility tUtil = new TestDataFileUtility();
			WebDriverUtility wUtil = new WebDriverUtility();
			JavaUtility jUtil = new JavaUtility();
			
			//creating required objects
			
			WebDriver driver = null;
			String partialWInTitleParent = "Administrator - Contacts - vtiger CRM 5 - Commercial Open Source CRM";
			String partialWinTitlechild = "Organizations";
		
		// loading required Property file
			String BROWSER = pUtil.readDataFromPropertyFile("browser");
			String URL = pUtil.readDataFromPropertyFile("url");
			String USERNAME = pUtil.readDataFromPropertyFile("username");
			String PASSWORD = pUtil.readDataFromPropertyFile("password");
			
		//loading required test data using utilities methods
			String contactName = tUtil.readDataFromExcelFile("Contact", 1, 2);
			String contactName1 = tUtil.readDataFromExcelFile("Contact", 1, 2)+jUtil.randomNumber();
				
			
		//Step2: Launch the Browser
			
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else if(BROWSER.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			else
			{
				System.out.println("Please select the correct browser");
			}
			
		
		
		//step3:Launch URL				
			driver.get(URL);
			//Maximise the browser
				wUtil.maxiMizeWindow(driver);
				
			//Implicit wait for page load
				wUtil.waitForPageLoad(driver);
				
		//step4:Login to application
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);;
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
			
		//Step5: Create Contact
				driver.findElement(By.linkText("Contacts")).click();
				driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		
				//details to fill in contact 
				WebElement ele = driver.findElement(By.name("salutationtype"));
				wUtil.handlingDropDown(ele, 1);
				driver.findElement(By.name("firstname")).sendKeys(contactName);
				driver.findElement(By.name("lastname")).sendKeys(contactName1);
				driver.findElement(By.xpath("//img[@tabindex=\"\"]")).click();
				
				String a = "test";
				
				wUtil.getWindowHandels(driver, partialWinTitlechild);
				
				driver.findElement(By.xpath("//a[.=\"test\"]")).click();
				
				wUtil.getWindowHandels(driver, partialWInTitleParent);
				
				driver.findElement(By.xpath("//input[@value=\"T\"]")).click();
				
				WebElement ele1 = driver.findElement(By.name("assigned_group_id"));
				
				wUtil.handlingDropDown("Marketing Group",ele1);
				
											
		//step6: Save COntact
				
				driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
				driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		
		//Step7: Verify Contact
				
				String contactHeader = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
				
				if(contactHeader.contains(contactName))
				{
					System.out.println(contactHeader+"****** PASS ********");
				}
				else
				{
					System.out.println("******** FAIL ********");
				}
				
		
		//Step8:Signout Application
				
				wUtil.miniMiseWindowRbt1();			
				driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
				driver.findElement(By.xpath("//a[.=\"Sign Out\"]")).click();
						
		//Step9:Close Browser
			
				driver.close();
	}

}
