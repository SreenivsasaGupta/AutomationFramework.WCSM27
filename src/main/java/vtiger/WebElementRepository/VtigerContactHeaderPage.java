package vtiger.WebElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class VtigerContactHeaderPage 
{
	
	//Rule 1:create separate POM class for every page 
	
		//Rule 2:Find all the webelements using the Annotations
		@FindBy(xpath = "//span[@class=\"dvHeaderText\"]") 
		private WebElement contactHeader;
		
		@FindBy(xpath = "//a[text()='Sign Out']") 
		private WebElement signoutNavLink;
		
		@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']") 
		private WebElement administratorNavLink;
		
		//Rule 3 : Initialize these elements using constructers 
		
		public VtigerContactHeaderPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		
		//Rule4: Generate Getters to access the elements 
		public WebElement getOrgHeader() {
			return contactHeader;
		}
		
		public WebElement getAdministratorNavLink() {
			return administratorNavLink;
		}
		
		public WebElement getSignoutNavLink() {
			return signoutNavLink;
		}
			
				
		//RUle 5 : Business Libraray for Project generic methods
		public String getContactHeader(String lastname)
		{
			String headertext =  contactHeader.getText();
			 return headertext;
			
		}
				
		public void Signout(WebDriver driver) 
		{
			WebDriverUtility wUtil = new WebDriverUtility();
			wUtil.mouseOverAction(driver, administratorNavLink);
			signoutNavLink.click();
		}
		

}
