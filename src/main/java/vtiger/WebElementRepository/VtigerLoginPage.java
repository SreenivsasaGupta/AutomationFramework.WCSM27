package vtiger.WebElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerLoginPage 
{
	//Rule 1:create separate POM class for every page 
	
	//Rule 2:Find all the webelements using the Annotations
	@FindBy(name = "user_name")
	private WebElement userNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement passWordEdt;
	
	@FindAll({@FindBy(id = "submitButton"),@FindBy(xpath = "//input[@value=\"Login\"]")})
	private WebElement submiBtn;
	
	//Rule 3 : Initialize these elements using constructers 
	public VtigerLoginPage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	//Rule4: Generate Getters to access the elements 

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPassWordEdt() {
		return passWordEdt;
	}

	public WebElement getSubmiBtn() {
		return submiBtn;
	}
	
	//RUle 5 : Business Libraray for Project generic methods
	
	public void loginPage(String username,String password)
	{
		userNameEdt.sendKeys(username);
		passWordEdt.sendKeys(password);
		submiBtn.click();
	}
	
	
	
}
