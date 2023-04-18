package vtiger.Practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Scenario4 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sushma Akki\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//td[2]//a[.=\"Organizations\"]")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys("test_0_0");
		WebElement industry_ele = driver.findElement(By.name("industry"));
		Select industry_s = new Select(industry_ele);
		industry_s.selectByValue("Energy");
		WebElement type_ele = driver.findElement(By.name("accounttype"));
		Select type_s = new Select(type_ele);
		type_s.selectByValue("Customer");
		driver.findElement(By.xpath("//input[@value=\"T\"]")).click();
		WebElement ele = driver.findElement(By.name("assigned_group_id"));
		Select s=new Select(ele);
		s.selectByIndex(1);
		driver.findElement(By.xpath("//input[@accesskey=\"S\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.xpath("//a[.=\"Sign Out\"]")).click();
		Thread.sleep(2500);		
		driver.close();



	}

}
