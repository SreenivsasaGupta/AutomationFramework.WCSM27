package vtiger.WebElementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class VtigerCreateContactPage extends WebDriverUtility
{
	//Rule 1:create separate POM class for every page
	//String OrgName;
	
			//Rule 2:Find all the webelements using the Annotations
				@FindBy(name = "lastname") 
				private WebElement lastNameEdt;
				
				@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@alt='Select']")
				private WebElement orgNameLookUpImg;	
				
				@FindBy(name = "search_text")
				private WebElement searchEdt;
				
				@FindBy(name = "search")
				private WebElement searchBtn;
				
				@FindBy(xpath = "//input[@title='Save [Alt+S]']")
				private WebElement saveBtn;
	
			
			//Rule 3 : Initialize these elements using constructers
				
				public VtigerCreateContactPage(WebDriver driver)
				{
					PageFactory.initElements(driver, this);
				}


			//Rule4: Generate Getters to access the elements 
				public WebElement getLastName() {
					return lastNameEdt;
				}


				public WebElement getOrganizationName() {
					return orgNameLookUpImg;
				}


				public WebElement getSearchText() {
					return searchEdt;
				}


				public WebElement getSearchBtn() {
					return searchBtn;
				}


				
				public WebElement getSaveBtn() {
					return saveBtn;
				}
			
					
			//RUle 5 : Business Libraray for Project generic methods
				
				public void createcontact(String lastname)
				{
					lastNameEdt.sendKeys(lastname);
					saveBtn.click();
				}
				
				public void selectOrgName(WebDriver driver,String lastname,String OrgName,String partialWinchildTitle,String PartialwinparentTitle)
				{
					lastNameEdt.sendKeys(lastname);
					orgNameLookUpImg.click();
					getWindowHandels(driver, partialWinchildTitle);
					searchEdt.sendKeys(OrgName);
					searchBtn.click();
					driver.findElement(By.xpath("//a[.='"+OrgName+"']")).click();
					getWindowHandels(driver, PartialwinparentTitle);
					saveBtn.click();
				}
				

}
