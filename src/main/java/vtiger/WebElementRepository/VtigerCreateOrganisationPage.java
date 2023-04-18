package vtiger.WebElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class VtigerCreateOrganisationPage extends WebDriverUtility
{
	//Rule 1:create separate POM class for every page 
	
			//Rule 2:Find all the webelements using the Annotations
			@FindBy(name = "accountname") 
			private WebElement organizationNameedt;
			
			@FindBy(name = "industry")
			private WebElement orgIndustry;
			
			@FindBy(xpath = "//input[@title='Save [Alt+S]']")
			private WebElement saveBtn;
			
			//Rule 3 : Initialize these elements using constructors 
			public VtigerCreateOrganisationPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}

						
			//Rule4: Generate Getters to access the elements 
			public WebElement getOrganizationName() {
				return organizationNameedt;
			}

			public WebElement getSaveBtn() {
				return saveBtn;
			}

					
			//RUle 5 : Business Library for Project generic methods
			public void createOrgWithOrgName(String orgName)
			{
				organizationNameedt.sendKeys(orgName);
				saveBtn.click();
			}
			
			public void createOrgwithIndustry(String orgName,String industry)
			{
				organizationNameedt.sendKeys(orgName);
				handlingDropDown(orgIndustry, industry);
				saveBtn.click();
			}
			
}
