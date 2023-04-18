package vtiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.WebElementRepository.VtigerHomePage;
import vtiger.WebElementRepository.VtigerLoginPage;

public class BaseClass 
{
	/**
	 * this class consist of all basic config annotations 
	 * author sreeni
	 *
	 */

	//Calling required  Utilities methohds
	public PropertyfileUtility pUtil = new PropertyfileUtility();
	public TestDataFileUtility tUtil = new TestDataFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public JavaUtility jUtil = new JavaUtility();
	
	//creating required objects
	
	public WebDriver driver = null;
	public static WebDriver screenShot_Driver;
	
	
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("DataBase Connection Successful");
	}
	@BeforeClass
	public void bcConfig() throws IOException
	{
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			 System.out.println("--- "+BROWSER+"Browser launched ---");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("--- "+BROWSER+"Browser launched ---");
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("--- "+BROWSER+"Browser launched ---");
		}
		else
		{
			System.out.println("select the correct browser");
		}
		
		screenShot_Driver = driver;
		wUtil.maxiMizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		
		driver.get(URL);
		
	}
	
	@BeforeMethod
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		VtigerLoginPage vlp = new VtigerLoginPage(driver);
		vlp.loginPage(USERNAME, PASSWORD);
		 System.out.println("--- Login successful ---");
	}
	
	@AfterMethod
	public void amConfig()
	{
		VtigerHomePage vhm = new VtigerHomePage(driver);
		vhm.Signout(driver);
		System.out.println("--- logout successful ---");
		
	}
	
	
	@AfterClass
	public void acConfig()
	{
		driver.quit();
        System.out.println("--- Browser closed ---"); 
	}
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("DataBase closed Successful");
	}
}
