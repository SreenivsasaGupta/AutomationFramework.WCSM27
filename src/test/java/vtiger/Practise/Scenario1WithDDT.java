package vtiger.Practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyfileUtility;
import vtiger.GenericUtilities.TestDataFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class Scenario1WithDDT {

	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		
		//Step1: Load all the required files 
				//load property file 
				
				/*FileInputStream fisp = new FileInputStream(IContactUtility.propertyfilepath);
				Properties pObj = new Properties();
				pObj.load(fisp);
				String BROWSER = pObj.getProperty("browser");
				String URL = pObj.getProperty("url");
				String USERNAME = pObj.getProperty("username");
				String PASSWORD = pObj.getProperty("password");
			*/
		
		
				//random class		
				//Random r = new Random();
				//int value = r.nextInt(100);
				
				
				//Calling required TestDatafile Utilities 
				TestDataFileUtility tUtil = new TestDataFileUtility();
				PropertyfileUtility pUtil = new PropertyfileUtility();
				JavaUtility jUtil = new JavaUtility();
				WebDriverUtility wUtil = new WebDriverUtility();
				//load XL file
				//FileInputStream fise = new FileInputStream(IContactUtility.excelfilepath);
				//Workbook wb = WorkbookFactory.create(fise);
				String BROWSER = pUtil.readDataFromPropertyFile("browser");
				String URL = pUtil.readDataFromPropertyFile("url");
				String USERNAME = pUtil.readDataFromPropertyFile("username");
				String PASSWORD = pUtil.readDataFromPropertyFile("password");
			
				String contactName = tUtil.readDataFromExcelFile("Contact", 1, 2)+jUtil.randomNumber();
						//wb.getSheet("Contact").getRow(1).getCell(2).getStringCellValue()+value;
				
				
		//Step 1: Launch the Browser
			WebDriver driver=null;
						if(BROWSER.equalsIgnoreCase("chrome"))
						{
							driver = new ChromeDriver();
						}
						else if(BROWSER.equalsIgnoreCase("firefox"))
						{
							
							WebDriverManager.firefoxdriver().setup();
							driver = new FirefoxDriver();
							
						}
						else
						{
							System.out.println("Invalid browser name");
						}
						
						//wUtil.maxiMizeWindow(driver);
						wUtil.maxmisewindowrbt();
						wUtil.waitForPageLoad(driver);
						/*
						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
						*/
		//step3:Launch URL				
						driver.get(URL);
		//step4:Login to application
						driver.findElement(By.name("user_name")).sendKeys(USERNAME);
						driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
						driver.findElement(By.id("submitButton")).click();
						
		//Step5: Create Contact
						driver.findElement(By.xpath("//table[1]//a[.=\"Contacts\"]")).click();
						driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
						WebElement ele = driver.findElement(By.name("salutationtype"));
						wUtil.handlingDropDown(ele, 1);
						//Select s=new Select(ele);
						//s.selectByIndex(1);
						driver.findElement(By.name("firstname")).sendKeys("test");
						driver.findElement(By.name("lastname")).sendKeys(contactName);
						driver.findElement(By.xpath("//input[@value=\"T\"]")).click();
						WebElement ele1 = driver.findElement(By.name("assigned_group_id"));
						wUtil.handlingDropDown("Marketing Group",ele1);
						//Select s1=new Select(ele1);
						//s1.selectByVisibleText("Marketing Group");
					
		//step6: Save COntact				
						driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
			
		//Step7: Verify Contact
				String contactHeader = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
				
				if(contactHeader.contains(contactName))
				{
					System.out.println(contactHeader+"****** PASS ********");
				}
				else
				{
					System.out.println("******** FAIL ********");
				}
				
		//Step8:Signout Application
						
			driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
			driver.findElement(By.xpath("//a[.=\"Sign Out\"]")).click();
			
		//Step8:Close Browser
			//driver.close();
		
	}

}
