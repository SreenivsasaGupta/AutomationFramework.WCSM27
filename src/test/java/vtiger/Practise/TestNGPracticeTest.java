package vtiger.Practise;

import org.testng.annotations.Test;

public class TestNGPracticeTest 
{
	@Test(priority = 1,invocationCount = 2)
	public void createUsers()
	{
		System.out.println("user ceated");
	}
	@Test(priority = -5,invocationCount = 0)
	public void modifyUser()
	{
		System.out.println("User modify");
	}
	@Test(priority = 3,invocationCount = 2)
	public void deleteUser()
	{
		System.out.println("User Deleted");
	}
}
