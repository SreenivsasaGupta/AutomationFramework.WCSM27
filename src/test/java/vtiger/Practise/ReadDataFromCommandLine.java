package vtiger.Practise;

import org.testng.annotations.Test;

public class ReadDataFromCommandLine 
{
	@Test
	public void Test() 
	{
		String BROWSER = System.getProperty("browser");
		System.out.println(BROWSER);
		
		String URL = System.getProperty("url");
		System.out.println(URL);
	}
}
