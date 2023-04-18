package vtiger.Organisation.tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyfileUtility;
import vtiger.GenericUtilities.TestDataFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.WebElementRepository.VtigerCreateOrganisationPage;
import vtiger.WebElementRepository.VtigerHomePage;
import vtiger.WebElementRepository.VtigerLoginPage;
import vtiger.WebElementRepository.VtigerOrganisationPage;
import vtiger.WebElementRepository.VtigerOrgnisationHeaderPage;

public class CreateOrgwithIndustryTest extends BaseClass 
{
	@Test(dataProvider = "createOrgWithIndustry")
	public void CreateOrgwithIndustry(String OrgName, String industry) throws IOException 
	{
		// Step 1: Create Object of Utilities
		
					
				// Step 5: Navigate to Organizations link
						VtigerHomePage vhp = new VtigerHomePage(driver);
						vhp.NavOrgLink();
				// Step 6: Click on Create Organization Look up Image
						VtigerOrganisationPage vop = new VtigerOrganisationPage(driver);
						vop.NavCreateOrg();
						
				// Step 7: Create organization with mandatory Fields
						VtigerCreateOrganisationPage vcop = new VtigerCreateOrganisationPage(driver);
						vcop.createOrgwithIndustry(OrgName+jUtil.randomNumber(), industry);
						
				// Step 9: Validate for Organization
						VtigerOrgnisationHeaderPage vohp = new VtigerOrgnisationHeaderPage(driver);
						String OrgCreated=vohp.getOrgHeaderText();
						if(OrgCreated.contains(OrgName))
						{
							System.out.println("-------Org creation successful------"+OrgCreated);
						}
						else
						{
							System.out.println("------ Org Creation Failed---------");
						}
				
	}
	@DataProvider(name="createOrgWithIndustry")
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
	///Object[][] data = tUtil.readDataFromExcelSheetForDataProvider("DataProvider");
	
	return tUtil.readDataFromExcelSheetForDataProvider("DataProvider");
	}
}
