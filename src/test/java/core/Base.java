package core;

import org.testng.asserts.SoftAssert;

public class Base {

	public static ThreadLocal<SoftAssert> softAssert = new ThreadLocal<SoftAssert>();
	
	public static void createSoftAssert()
	{
		SoftAssert soft = new SoftAssert();
		softAssert.set(soft);
	}
	
	public static SoftAssert getSoftassert()
	{
		return softAssert.get();
	}
		
	public static void assertAll()
	{
		softAssert.get().assertAll();
	}
	
}
