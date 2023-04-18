package vtiger.Practise;




import org.testng.annotations.Test;




public class IretryAnalyserPractice 
{
	@Test(retryAnalyzer = vtiger.GenericUtilities.IRetryAnalyserImplementation.class)
	public void test()
	{
		org.testng.Assert.fail();
		System.out.println("helo");
	}
	
}
