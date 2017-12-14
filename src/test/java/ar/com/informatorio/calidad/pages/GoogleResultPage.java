package ar.com.informatorio.calidad.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleResultPage extends BasePage {

	@FindBy(xpath = "(//*[@class='g']/descendant::a)[1]")
	private WebElement firstResultLink;

	public GoogleResultPage(WebDriver driver) {
		super(driver);
	}

	public <T> T openFirstResult(Class<T> returnPage) {
		firstResultLink.click();
		return PageFactory.initElements(driver, returnPage);
	}
}