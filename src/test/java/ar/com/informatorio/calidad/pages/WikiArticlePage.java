package ar.com.informatorio.calidad.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikiArticlePage extends BasePage{
	
	@FindBy(id = "firstHeading")
	private WebElement firstHeading;
	
	public WikiArticlePage(WebDriver driver){
		super(driver);
	}
	
	public String getFirstHeadingText(){
		return firstHeading.getText();
	}
}