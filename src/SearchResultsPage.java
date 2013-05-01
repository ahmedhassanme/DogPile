import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SearchResultsPage 
{
	private WebDriver driver;
	private WebElement pageNumber;
	private WebElement nextButton;
	private WebElement prevButton;
	
	public SearchResultsPage(WebDriver theDriver)
	{
		//Set the WebDriver
		driver = theDriver;
		//Set the page number using its xpath
		pageNumber = driver.findElement(By.xpath("//*[@class='paginationSelectedPage']//strong"));
	}
	
	public String getPageNumber()
	{
		return pageNumber.getText();
	}
	
	public SearchResultsPage clickNext()
	{
		//Set the next button using its xpath
		nextButton = driver.findElement(By.xpath("//*[@class='paginationNext']//a"));
		//Click the button
		nextButton.click();
		//Return the new results page
		SearchResultsPage result = new SearchResultsPage(driver);
		return result;
	}
	
	public SearchResultsPage clickPrev()
	{
		//Set the prev button using its xpath
		prevButton = driver.findElement(By.xpath("//*[@class='paginationPrev']//a"));
		//Click the button
		prevButton.click();
		//Return the new results page
		SearchResultsPage result = new SearchResultsPage(driver);
		return result;
	}
}
