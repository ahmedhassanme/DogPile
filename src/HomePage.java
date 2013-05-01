import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage 
{
	private WebDriver driver;
	private WebElement searchBox;
	private WebElement goButton;
	private final String URL = "http://www.dogpile.com/";
	
	public HomePage(WebDriver theDriver)
	{
		//Pass in the driver and navigate to the homepage
		driver = theDriver;
		driver.get(URL);
		
		//Store the elements on the page
		searchBox = driver.findElement(By.id("topSearchTextBox"));
		goButton = driver.findElement(By.id("topSearchSubmit"));
	}
	
	public SearchResultsPage searchAndGo(String data)
	{
		//Type the data into the search box and click the search button
		searchBox.sendKeys(data);
		goButton.click();
		SearchResultsPage results = new SearchResultsPage(driver);
		return results;
	}

}
