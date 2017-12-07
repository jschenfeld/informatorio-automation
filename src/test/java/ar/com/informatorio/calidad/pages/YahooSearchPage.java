package ar.com.informatorio.calidad.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YahooSearchPage {
	private WebDriver driver;

	@FindBy(xpath = "//input[@name='p']")
	private WebElement searchTextBox;

	@FindBy(xpath = "//button[@class='sbb']")
	private WebElement searchButton;

	public YahooSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public YahooResultPage search(String query) {
		searchTextBox.clear();
		searchTextBox.sendKeys(query);
		searchTextBox.sendKeys(Keys.TAB);
		searchButton.click();
		return new YahooResultPage(driver);
	}
}
