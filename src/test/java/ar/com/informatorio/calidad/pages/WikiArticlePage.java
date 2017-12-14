package ar.com.informatorio.calidad.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiArticlePage {

	@FindBy(id = "firstHeading")
	private WebElement firstHeading;

	public WikiArticlePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getFirstHeadingText() {
		return firstHeading.getText();
	}
}