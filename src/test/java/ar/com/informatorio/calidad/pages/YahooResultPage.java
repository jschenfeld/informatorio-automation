package ar.com.informatorio.calidad.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YahooResultPage extends BasePage {

	@FindBy(xpath = "(//div[@id='web']/descendant::h3[@class='title']/a)[1]")
	private WebElement firstResultLink;
	
	public YahooResultPage(WebDriver driver) {
		super(driver);
		isElementPresent(15, firstResultLink);
	}

	public WikiArticlePage clickFirstResultLink(){
		firstResultLink.click();
		switchToLastWindows();
		return new WikiArticlePage(driver);
	}
}
