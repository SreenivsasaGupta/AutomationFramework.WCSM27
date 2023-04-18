package vtiger.WebElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerContactPage 
{
	//Rule 1:create separate POM class for every page 
	
			//Rule 2:Find all the webelements using the Annotations
			@FindBy(xpath = "//img[@alt='Create Contact...']")
			private WebElement createContact;

			
			//Rule 3 : Initialize these elements using constructers 
			public VtigerContactPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}

		
			//Rule4: Generate Getters to access the elements 
			public WebElement getCreateContact() {
				return createContact;
			}
			
					
			//RUle 5 : Business Libraray for Project generic methods
			public void createContactLookupImg()
			{
				createContact.click();
			}
}
