package vtiger.Practise;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertyFilePractice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//step1:read the property file 
		FileInputStream f1 = new FileInputStream(".\\src\\test\\resources\\commonProperties.properties");
		//step2:create object of file property 
		Properties pobj = new Properties();
		//step3:load file input steam 
		pobj.load(f1);
		//step4: using keys read the file 
		String Browser=pobj.getProperty("browser");	
		System.out.println(Browser);
		String URL=pobj.getProperty("url");
		System.out.println(URL);
		String Username = pobj.getProperty("username");
		String Password = pobj.getProperty("password");
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		
	
	}

}
