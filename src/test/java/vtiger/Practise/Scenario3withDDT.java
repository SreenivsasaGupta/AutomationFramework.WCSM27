package vtiger.Practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario3withDDT 
{

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
	
//Step1: Load all the required files 
		//load property file 
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\commonProperties.properties");
		Properties pObj = new Properties();
		pObj.load(fisp);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		//random class		
		Random r = new Random();
		int rNumber = r.nextInt(1000);
		
		//load XL file
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String orgName = wb.getSheet("Organization").getRow(4).getCell(2).getStringCellValue()+rNumber;
		String orgIndustry = wb.getSheet("Organization").getRow(4).getCell(3).getStringCellValue();
		
//Step 2: Launch the Browser
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Please select proper web Browser");
		}
//step3:Launch URL		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
//step4:Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
//Step5: Create Organisation and Industry
		driver.findElement(By.xpath("//td[2]//a[.=\"Organizations\"]")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		WebElement industry_ele = driver.findElement(By.name("industry"));
		Select industry_s = new Select(industry_ele);
		industry_s.selectByValue(orgIndustry);
					
//step6: Save Organisation				
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
//Step7: Verify Organisation
		String orgHeader = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		if(orgHeader.contains(orgName))
		{
			System.out.println(orgHeader+"***** PASS ********");
		}
		else
		{
			System.out.println("******** FAIL ********");
		}
		
//Step8:Signout Application
		WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions a =new Actions(driver);
		a.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("browser closed");
//Step9:Close Browser
		driver.close();
		}

}
