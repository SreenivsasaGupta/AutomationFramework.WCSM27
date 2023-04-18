package vtiger.Practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
			
		WebDriver driver = new ChromeDriver();
		String key = "webdriver.chrome.driver";
		String value ="C:\\Users\\Sushma Akki\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe";
		System.setProperty(key, value);
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//table[1]//a[.=\"Contacts\"]")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		WebElement ele = driver.findElement(By.name("salutationtype"));
		Select s=new Select(ele);
		s.selectByIndex(1);
		driver.findElement(By.name("firstname")).sendKeys("Sushma");
		driver.findElement(By.name("lastname")).sendKeys("Akki");
		driver.findElement(By.xpath("//input[@value=\"T\"]")).click();
		WebElement ele1 = driver.findElement(By.name("assigned_group_id"));
		Select s1=new Select(ele1);
		s1.selectByVisibleText("Marketing Group");
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.xpath("//a[.=\"Sign Out\"]")).click();
		Thread.sleep(2500);		
		driver.close();

	}

}
