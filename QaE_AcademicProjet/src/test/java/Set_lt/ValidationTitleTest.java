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

public class ValidationTitleTest extends Base

{
	private static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initialization();
		log.info("succesfully initialized");
		driver.get(prop.getProperty("url"));
		log.info("succesfully url initialized");
	}
@Test(priority=1)
public void  ValidateTitle() throws IOException
{
		LandingPage l=new LandingPage(driver);
	l.getTitle().getText();
	//compare the text from browser with actual text --error
	Assert.assertEquals(l.getTitle().getText(), "Featured Courses");
	log.info("succesfully validated test");
}
@AfterTest
public void tearDown()
{
	driver.close();
	driver=null;
}

}
