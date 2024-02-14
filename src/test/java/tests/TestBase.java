package tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import core.Assertions;
import core.Base;


public class TestBase extends Assertions {

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
