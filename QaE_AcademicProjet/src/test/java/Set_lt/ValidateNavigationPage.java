package Set_lt;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pageobjects.LandingPage;
import Pageobjects.LoginPage;
import resources.Base;

public class ValidateNavigationPage extends Base
{
	private static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initialization();
		driver.get(prop.getProperty("url"));
	}
@Test(priority=1)
public void  validateAppNav() throws IOException
{
	
	LandingPage l=new LandingPage(driver);
	
	//compare the text from browser with actual text --error
	Assert.assertTrue(l.getNavigationBar().isDisplayed());
	log.info("navigation bar");
}
@AfterTest
public void tearDown()
{
	driver.close();
	driver=null;
}

}
