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
		driver = theDriver;
		driver.get(URL);
		searchBox = driver.findElement(By.id("topSearchTextBox"));
		goButton = driver.findElement(By.id("topSearchSubmit"));
	}
	
	public SearchResultsPage searchAndGo(String data)
	{
		searchBox.sendKeys(data);
		goButton.click();
		SearchResultsPage results = new SearchResultsPage(driver);
		return results;
	}

}
