package vtiger.WebElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerOrganisationPage 
{
	//Rule 1:create separate POM class for every page 
	
			//Rule 2:Find all the webelements using the Annotations
			@FindBy(xpath = "//img[@alt='Create Organization...']")
			private WebElement createOrg;
			
			
			//Rule 3 : Initialize these elements using constructers 
			public VtigerOrganisationPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}


			
			//Rule4: Generate Getters to access the elements 
			
			public WebElement getCreateOrg() {
				return createOrg;
			}
			
					
			//RUle 5 : Business Libraray for Project generic methods
			public void NavCreateOrg()
			{
				createOrg.click();
			}

}
