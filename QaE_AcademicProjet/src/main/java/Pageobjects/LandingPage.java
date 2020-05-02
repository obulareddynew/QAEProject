package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage 
{public static WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}

By signin=By.cssSelector("a[href*='sign_in']");
By title=By.cssSelector(".text-center>h2");
By NavBar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");

public WebElement getLogin()
{
	return driver.findElement(signin);
}
public WebElement getTitle()
{
	return driver.findElement(title);
}
public WebElement getNavigationBar()
{
	return driver.findElement(NavBar);
}
}
