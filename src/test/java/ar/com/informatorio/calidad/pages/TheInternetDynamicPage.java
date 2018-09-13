package ar.com.informatorio.calidad.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TheInternetDynamicPage extends BasePage {

	@FindBy(xpath = "//*[@id='start']/button")
	private WebElement start;
	
	private WebElement finish;
	
	@FindBy(xpath = "//*[@id='finish']/h4")
	private WebElement message;
	
	public TheInternetDynamicPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickStartButton(){
		start.click();
		isElementPresent(10, finish);
	}
	
	public String getMessage(){
		return message.getText();
	}
}