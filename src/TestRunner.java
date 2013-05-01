import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.SeleneseTestBase;


public class TestRunner extends SeleneseTestBase
{
	WebDriver driver;
	HomePage home;
	SearchResultsPage results;
	
	@BeforeSuite
	public void setUpSelenium()
	{
		driver = new FirefoxDriver();
	}
	
	@AfterSuite
	public void shutDownSelenium()
	{
		driver.close();
	}
	
	@Test(description = "Open the homepage")
	public void openHomePage()
	{
		home = new HomePage(driver);
	}
	
	@Test(description = "Type 'huddle' into search field and click search button", dependsOnMethods = {"openHomePage"})
	public void searchAndGo()
	{
		results = home.searchAndGo("huddle");
	}
	
	@Test(description = "Verify we're on the 1st page", dependsOnMethods = {"searchAndGo"})
	public void verifyFirstPage()
	{
		String pageNumber = results.getPageNumber();
		assertTrue(pageNumber.equals("1"));
	}
	
	@Test(description = "Click the 'next' button", dependsOnMethods = {"verifyFirstPage"})
	public void clickNext()
	{
		results = results.clickNext();
	}
	
	@Test(description = "Verify we're on the 2nd page", dependsOnMethods = {"clickNext"})
	public void verifySecondPage()
	{
		String pageNumber = results.getPageNumber();
		assertTrue(pageNumber.equals("2"));
	}
	
	@Test(description = "Click the 'prev' button", dependsOnMethods = {"verifySecondPage"})
	public void clickPrev()
	{
		results = results.clickPrev();
	}
	
	@Test(description = "Verify we're back at the first page", dependsOnMethods = {"clickPrev"})
	public void verifyFirstPageAgain()
	{
		String pageNumber = results.getPageNumber();
		assertTrue(pageNumber.equals("1"));
	}
}
