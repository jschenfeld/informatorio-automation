package ar.com.informatorio.calidad.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage extends BasePage {
		
	@FindBy(name = "q")
	private WebElement searchBoxLocator;

	@FindBy(name = "btnK")
	private WebElement searchButton;
	
	
	public GoogleSearchPage(WebDriver driver) {
		super(driver);
	}

	public void fillTextBox(String keyword) {
		System.out.println("Filling search text box with: " + keyword);
		searchBoxLocator.sendKeys(keyword);
		searchBoxLocator.sendKeys(Keys.TAB);
	}

	public GoogleResultPage clickSearchButton(WebDriver driver) {
		System.out.println("Clicking search button.");
		searchButton.click();
		return new GoogleResultPage(driver);
	}
}
