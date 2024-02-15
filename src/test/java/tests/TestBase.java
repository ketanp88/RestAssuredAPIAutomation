package tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import core.Assertions;
import core.Base;


public class TestBase extends Assertions {

	public String bearerToken = "123b934dd48340c191d0ee731fac0f54e122ac016798c5dba1bec7f5200ed2b1";
	@BeforeMethod(alwaysRun = true)
	public void initialize(@Optional String browser)
	{
		Base.createSoftAssert();
	}
	
    @AfterMethod(alwaysRun = true)
	public void cleanUp()
	{
		Base.assertAll();
	}
	
	
}
