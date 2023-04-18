package vtiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/***
 * This is Implementation class for IretryAnalyser interface in testng
 * @author Sushma Akki
 *
 */

public class IRetryAnalyserImplementation implements IRetryAnalyzer 
{

	public boolean retry(ITestResult result) 
	{
		int count = 0;
		int retry = 5;
		while(count < retry)
		{
			count++;
			return true;
		}
		return false;
	}

}
