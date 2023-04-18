package vtiger.Contacts.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import vtiger.GenericUtilities.BaseClass;
import vtiger.WebElementRepository.VtigerContactHeaderPage;
import vtiger.WebElementRepository.VtigerContactPage;
import vtiger.WebElementRepository.VtigerCreateContactPage;
import vtiger.WebElementRepository.VtigerCreateOrganisationPage;
import vtiger.WebElementRepository.VtigerHomePage;
import vtiger.WebElementRepository.VtigerOrganisationPage;
import vtiger.WebElementRepository.VtigerOrgnisationHeaderPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateContactWithOrgNameTest extends BaseClass {

	
	@Test
	public void CreateContactWithOrgName() throws IOException
	{
			String LASTNAME = tUtil.readDataFromExcelFile("Contact", 4, 2)+jUtil.randomNumber();
			String OrgName=tUtil.readDataFromExcelFile("Contact", 4, 3)+jUtil.randomNumber();
			String partialWinchildTitle = "Accounts";
			String PartialwinparentTitle ="Contacts";
			
			System.out.println("test");
		//  Navigate to Organizations link
				VtigerHomePage vhp = new VtigerHomePage(driver);
				vhp.NavOrgLink();
				Reporter.log("Navigate to Organizations link",true);
		// Click on Create Organization Look up Image
				VtigerOrganisationPage vop = new VtigerOrganisationPage(driver);
				vop.NavCreateOrg();
				Reporter.log("Click on Create Organization Look up Image");
		// Create organization with mandatory Fields
				VtigerCreateOrganisationPage vcop = new VtigerCreateOrganisationPage(driver);
				vcop.createOrgWithOrgName(OrgName);
				Reporter.log("Create organization with mandatory Fields");
		//  Validate for Organization
				VtigerOrgnisationHeaderPage vohp = new VtigerOrgnisationHeaderPage(driver);
				String OrgCreated=vohp.getOrgHeaderText();
				Assert.assertTrue(OrgCreated.contains(OrgName));
				Reporter.log("validate for Organization");
		// Create Contact
				vhp.NavContactLink();
				VtigerContactPage vcp = new VtigerContactPage(driver);
				vcp.createContactLookupImg();
				
				VtigerCreateContactPage vccp = new VtigerCreateContactPage(driver);
				vccp.selectOrgName(driver, LASTNAME, OrgName, partialWinchildTitle, PartialwinparentTitle);
				Reporter.log("Create Contact");
		// Validate for contact
				VtigerContactHeaderPage vchp = new VtigerContactHeaderPage(driver);
				String contactCreated = vchp.getContactHeader(LASTNAME);
				Assert.assertTrue(contactCreated.contains(LASTNAME));
				Reporter.log("Validate for contact");
				
	}
	
	@Test
	public void Demo()
	{
		System.out.println("Demo");
	}

}
