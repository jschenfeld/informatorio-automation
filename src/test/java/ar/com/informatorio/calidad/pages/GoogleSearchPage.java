package ar.com.informatorio.calidad.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

	private WebDriver driver;

	@FindBy(name = "q")
	private WebElement searchTextBox;

	@FindBy(name = "btnK")
	private WebElement searchButton;

	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public GoogleResultPage search(String query) {
		searchTextBox.clear();
		searchTextBox.sendKeys(query);
		searchTextBox.sendKeys(Keys.TAB);
		searchButton.click();
		return new GoogleResultPage(driver);
	}
}
