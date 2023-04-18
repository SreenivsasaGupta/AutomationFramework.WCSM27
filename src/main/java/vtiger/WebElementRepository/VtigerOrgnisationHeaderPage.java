package vtiger.WebElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerOrgnisationHeaderPage
{
	//Rule 1:create separate POM class for every page 
	
	//Rule 2:Find all the webelements using the Annotations
	@FindBy(xpath = "//span[@class='dvHeaderText']") 
	private WebElement orgHeader;
	@FindBy(xpath = "//a[text()='Contacts']") 
	private WebElement contactNavLink;
	
	//Rule 3 : Initialize these elements using constructers 
	
	public VtigerOrgnisationHeaderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Rule4: Generate Getters to access the elements 
	public WebElement getOrgHeader() {
		return orgHeader;
	}
	
	public WebElement getContactNavLink() {
		return contactNavLink;
	}

	
			
	//RUle 5 : Business Libraray for Project generic methods
	public String getOrgHeaderText()
	{
		return orgHeader.getText();
	}
	
	public void ChekOrgCreated(String orgName)
	{
		String orgHeaderText = orgHeader.getText();	
		if(orgHeaderText.contains(orgName))
		{
			System.out.println( orgHeaderText+ " --- Organization Created");
		} 
		else 
		{
			System.out.println(" ----Organization creation Failed ----");
		}
	}
	
	public void NavContactLink()
	{
		contactNavLink.click();
	}
	
}
