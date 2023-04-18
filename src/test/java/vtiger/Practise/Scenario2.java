package vtiger.Practise;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario2 {
public static void main(String[] args) {
		
		Random r = new Random();
		int value = r.nextInt(1000);
		
		//Step 1: Launch the Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");
		
		//Step 2: Login to App
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3: Navigate to Organizations link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 4: Click on Create Organization Look up Image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 5: Create organization with mandatory Fields
		driver.findElement(By.name("accountname")).sendKeys("CSS CORP"+value);
		
		//Step 6: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 7: Validate for Organization
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains("CSS CORP"))
		{
			System.out.println(OrgHeader+" ---- PASS ----");
		}
		else
		{
			System.out.println(" ---- Failed ----");
		}
		
		//Step 8: Logout of app
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Sign out successful");
		
}	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/*public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sushma Akki\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	Random r=new Random();
	int Random_num=r.nextInt(1000);
	driver.manage().window().maximize();
	driver.get("http://localhost:8888");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.xpath("//td[2]//a[.=\"Organizations\"]")).click();
	driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
	driver.findElement(By.name("accountname")).sendKeys("test"+Random_num);
	driver.findElement(By.xpath("//input[@value=\"T\"]")).click();
	WebElement ele = driver.findElement(By.name("assigned_group_id"));
	Select s=new Select(ele);
	s.selectByIndex(1);
	driver.findElement(By.xpath("//input[@accesskey=\"S\"]")).click();
	Thread.sleep(1000);
	String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(OrgHeader.contains("CSS CORP"))
	{
		System.out.println(OrgHeader+" ---- PASS ----");
	}
	else
	{
		System.out.println(" ---- Failed ----");
	}
	
	WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act = new Actions(driver);
	act.moveToElement(ele1).perform();
	driver.findElement(By.linkText("Sign Out")).click();
	System.out.println("Sign out successful");
	
	
	WebElement ele1 = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
	Actions a1 = new Actions(driver);
	a1.moveToElement(ele1).perform();
	driver.findElement(By.linkText("Sign Out")).click();
	Thread.sleep(2500);		
	driver.close();*/

	
	


