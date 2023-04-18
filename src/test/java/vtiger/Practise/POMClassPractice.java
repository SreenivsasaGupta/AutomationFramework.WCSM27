package vtiger.Practise;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyfileUtility;
import vtiger.GenericUtilities.TestDataFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.WebElementRepository.VtigerContactHeaderPage;
import vtiger.WebElementRepository.VtigerContactPage;
import vtiger.WebElementRepository.VtigerCreateContactPage;
import vtiger.WebElementRepository.VtigerCreateOrganisationPage;
import vtiger.WebElementRepository.VtigerHomePage;
import vtiger.WebElementRepository.VtigerLoginPage;
import vtiger.WebElementRepository.VtigerOrganisationPage;
import vtiger.WebElementRepository.VtigerOrgnisationHeaderPage;

public class POMClassPractice 
{

	public static void main(String[] args) throws IOException {
		//Step1: Load all the required files 

		//Calling required  Utilities methohds
		PropertyfileUtility pUtil = new PropertyfileUtility();
		TestDataFileUtility tUtil = new TestDataFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		
		//creating required objects
		WebDriver driver = null;
		
	// loading required Property file
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
	//loading required testData
		String lastname = tUtil.readDataFromExcelFile("Contact", 4, 2)+jUtil.randomNumber();
		String orgName = tUtil.readDataFromExcelFile("Contact", 4, 3)+jUtil.randomNumber();


		
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
			
	//step4 : Login to the page 
			VtigerLoginPage vlp = new VtigerLoginPage(driver);
			//vlp.getUserNameEdt().sendKeys(USERNAME);
			//vlp.getPassWordEdt().sendKeys(PASSWORD);
			//vlp.getSubmiBtn().click();
			vlp.loginPage(USERNAME, PASSWORD);
			VtigerHomePage vhp = new VtigerHomePage(driver);
			vhp.NavOrgLink();
			VtigerOrganisationPage vop = new VtigerOrganisationPage(driver);
			vop.NavCreateOrg();
			VtigerCreateOrganisationPage vcop = new VtigerCreateOrganisationPage(driver);
			vcop.createOrgwithIndustry(orgName,"");
			VtigerOrgnisationHeaderPage vohp = new VtigerOrgnisationHeaderPage(driver);
			vohp.ChekOrgCreated(orgName);
			vohp.NavContactLink();
			VtigerContactPage vcp = new VtigerContactPage(driver);
			vcp.createContactLookupImg();
			VtigerCreateContactPage vccp = new VtigerCreateContactPage(driver);
			vccp.createcontact(lastname);
			vccp.selectOrgName(driver, lastname, orgName, "Accounts","Contacts");
			//vccp.saveOrg(driver, "contact");
			VtigerContactHeaderPage vchp = new VtigerContactHeaderPage(driver);
			System.out.println(vchp.getAdministratorNavLink());
			vchp.Signout(driver);
			
	}
}
