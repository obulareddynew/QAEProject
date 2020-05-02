package Set_lt;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pageobjects.LandingPage;
import Pageobjects.LoginPage;
import resources.Base;

public class TestCaseSet1 extends Base
{
	private static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initialization();
		
	}
@Test(priority = 1,dataProvider = "getData")
public void  homePageNav(String Username,String password,String text) throws IOException
{
	driver.get(prop.getProperty("url"));
	LandingPage l=new LandingPage(driver);
	l.getLogin().click();
	LoginPage lp=new LoginPage(driver);
	lp.getEmail().sendKeys(Username);
	lp.getPassword().sendKeys(password);
	System.out.println(text);
	lp.getLogin().click();
	log.info("login clicked");
}
@DataProvider
public Object[][] getData()
{
	// row strands for hoe many different data types test should run
	// coloumn stands for how many values per each test
	
	Object[][] data=new Object[2][3];
	//oth row
	data[0][0]="nonrestricteduser@qw.com";
	data[0][1]="123456";
	data[0][2]="Restricted User";
	//1st row
	data[1][0]="restricteduser@qw.com";
	data[1][1]="456788";
	data[1][2]="Non restricted User";
	return data;
}
@AfterTest
public void tearDown()
{
	driver.close();
	driver=null;
}

}
