package core;


public class Assertions {

	
	public void verifyEquals(Object obj1, Object obj2)
	{
		if(obj1.equals(obj2))
		{
			Log.verify("VERIFICATION: PASSED. Expected: '" + obj1 + "' Actual: '" + obj2+"'");
		}
		else
		{
			Log.verify("VERIFICATION: FAILED. Expected: '" + obj1 + "' Actual: '" + obj2+"'");
		}
		Base.softAssert.get().assertEquals(obj1, obj2);
	}
	
	public void verifyContains(String obj1, String obj2)
	{
		if(obj1.contains(obj2))
		{
			Log.verify("VERIFICATION: PASSED. Expected: '" + obj1 + "' contains value Actual: '" + obj2+"'");
			Base.softAssert.get().assertEquals(true, true);
		}
		else
		{
			Log.verify("VERIFICATION: FAILED. Expected: '" + obj1 + "' does not contains value Actual: '" + obj2+"'");
			Base.softAssert.get().assertEquals(true, false);
		}
	}
	
	
}
