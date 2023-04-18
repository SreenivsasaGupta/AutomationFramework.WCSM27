package vtiger.WebElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class VtigerHomePage extends WebDriverUtility
{
	
	//Rule 1:create separate POM class for every page 
	
		//Rule 2:Find all the webelements using the Annotations
		@FindBy(xpath = "//a[text()='Organizations']") private WebElement orgNavLink;
		@FindBy(xpath = "//a[text()='Contacts']") private WebElement contactNavLink;
		@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']") private WebElement administratorNavLink;
		@FindBy(xpath = "//img[@src='themes/softed/images/Home.PNG']")private WebElement homeNavlink;
		@FindBy(xpath = "//a[text()='Sign Out']") private WebElement signoutNavLink;
		
		//Rule 3 : Initialize these elements using constructers 
		public VtigerHomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

					
		//Rule4: Generate Getters to access the elements 
		public WebElement getOrgNavLink() {
			return orgNavLink;
		}

		public WebElement getContactNavLink() {
			return contactNavLink;
		}

		public WebElement getAdministratorNavLink() {
			return administratorNavLink;
		}

		public WebElement getSignoutNavLink() {
			return signoutNavLink;
		}
		
		public WebElement getHomeNavlink() {
			return homeNavlink;
		}

				
		//RUle 5 : Business Libraray for Project generic methods
		
		public void NavHomeLink()
		{
			homeNavlink.click();
		}
		
		public void NavOrgLink()
		{
			orgNavLink.click();
		}
		
		public void NavContactLink()
		{
			contactNavLink.click();
		}
		
		public void Signout(WebDriver driver) 
		{
			mouseOverAction(driver, administratorNavLink);
			signoutNavLink.click();
		}
		
		

}
