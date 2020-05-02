package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class Base
{
	public static WebDriver driver;
	public Properties prop;
	public WebDriver initialization() throws IOException
	{
  prop=new Properties();
 FileInputStream file=new FileInputStream("GlobalVariables.properties");
 prop.load(file);
 if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
 {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver(); 
 }
 else if(prop.getProperty("browser").equalsIgnoreCase("FirFox")){
	 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");	
		driver = new FirefoxDriver(); 
	}
 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
 return driver;
 
 
	}
	public void getScreenshot(String name) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C:\\Users\\Ramakrishna\\eclipse-workspace\\QaE_AcademicProjet\\"+name+"new.png"));
	}
}
