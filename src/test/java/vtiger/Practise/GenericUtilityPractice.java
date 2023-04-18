package vtiger.Practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyfileUtility;
import vtiger.GenericUtilities.TestDataFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		
		/**
		 * 
		 */
		PropertyfileUtility p1 = new PropertyfileUtility();
		String data = p1.readDataFromPropertyFile("browser");
		System.out.println(data);
		
		/*TestDataFileUtility t1= new TestDataFileUtility();
		TestDataFileUtility t2 = new TestDataFileUtility();
		String ContactName = t1.readDataFromExcelFile("Contact", 1, 2);
		String OrgName = t2.readDataFromExcelFile("Organization", 1, 2);
		System.out.println(ContactName);
		System.out.println(OrgName);
		
		t1.writeDatatoExcel("Organization", 20, 6, OrgName);
		System.out.println("Data Added");
		
		JavaUtility j1 = new JavaUtility();
		System.out.println(j1.systemDate());
		System.out.println(j1.randomNumber());
		
		System.out.println(j1.systemDateInFormat());
		*/
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverUtility wUtil = new WebDriverUtility();
		//wUtil.maxiMizeWindow(driver);
		wUtil.maxmisewindowrbt();		
		wUtil.cltAltDelete();
		System.out.println("window got Maximised");
		//wUtil.miniMizeWindow(driver);
		//System.out.println("winodw got minimised");
		wUtil.rightClickAction(driver);;
		
		
		
	}

}
