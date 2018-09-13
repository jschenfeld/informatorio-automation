package ar.com.informatorio.calidad.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YahooSearchPage extends BasePage {
	
	@FindBy(name = "p")
	private WebElement campoTextoBusqueda;

	@FindBy(xpath = "//div[@title='Search']")
	private WebElement botonBuscar;
	
	public YahooSearchPage(WebDriver driver) {
		super(driver);
		isElementPresent(15, botonBuscar);
	}
	
	public void completarCampoDeBusqueda(String keyword){
		System.out.println("Filling search text box with: " + keyword);
		campoTextoBusqueda.sendKeys(keyword);
	}

	public YahooResultPage clickBotonBuscar(){
		System.out.println("Clicking search button.");
		botonBuscar.click();
		return new YahooResultPage(driver);
	}

}