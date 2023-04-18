package vtiger.GenericUtilities;

import java.util.Date;
import java.util.Random;

/***
 * 
 * @author Sushma Akki
 *
 */
public class JavaUtility 
{
/***
 * This Method to create the random number
 * @return
 */
	public int randomNumber()
	{
			Random r= new Random();
			return  r.nextInt(1000);
	}

	/***
	 * this method to get the system date
	 * @return
	 */
	
	public String systemDate()
	{
		Date d = new Date();
		return d.toString();
	}
	
	/***
	 * this method to get the system date in format 
	 * @return
	 */
	
	public String systemDateInFormat()
	{
		Date d = new Date();
		String[] dArr = d.toString().split(" ");
		//Fri Mar 10 10:39:20 IST 2023;

		String date = dArr[2];
		String month = dArr[1];
		String year = dArr[5];
		String time = dArr[3].replace(":", "-");
		String datevalue = date+"-"+month+"-"+year+""+time;
		return datevalue;
	}
	
}
