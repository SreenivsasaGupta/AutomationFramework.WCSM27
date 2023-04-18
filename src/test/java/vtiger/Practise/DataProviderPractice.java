package vtiger.Practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice
{
	
	@Test(dataProvider = "getDataMobile")
	public void printMobileDetails(String mName,int price,int qun,String color,boolean Availability)
	{
		System.out.println("**********"+mName+"-"+price+"-"+qun+"-"+color+"-"+Availability+"-"+"************");
	}

	@Test(dataProvider = "getDataLaptop")
	public void printLaptopDetails(String lName,int price,int qun,String color)
	{
		System.out.println("**********"+lName+"-"+price+"-"+qun+"-"+color+"************");
	}

	
	@DataProvider
	public Object[][] getDataMobile()
	{
		
		Object[][] data = new Object[2][5];
		
		data[0][0] = "MI";
		data[0][1] = 5800;
		data[0][2] = 10;
		data[0][3] = "Black";
		data[0][4] = true;
		
		data[1][0] = "Iphone";
		data[1][1] = 58000;
		data[1][2] = 1;
		data[1][3] = "Gold";
		data[1][4] = true;
		
		return data;
		
	}
	
	@DataProvider
	public Object[][] getDataLaptop()
	{
		
		Object[][] data = new Object[1][4];
		
		data[0][0] = "DELL";
		data[0][1] = 58000;
		data[0][2] = 100;
		data[0][3] = "Black";
		
		return data;
		
	}
	
	
}
