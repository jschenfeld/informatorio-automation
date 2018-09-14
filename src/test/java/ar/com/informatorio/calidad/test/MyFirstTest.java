package ar.com.informatorio.calidad.test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ar.com.informatorio.calidad.pages.GoogleResultPage;
import ar.com.informatorio.calidad.pages.GoogleSearchPage;
import ar.com.informatorio.calidad.pages.WikiArticlePage;
import ar.com.informatorio.calidad.pages.YahooResultPage;
import ar.com.informatorio.calidad.pages.YahooSearchPage;

public class MyFirstTest extends BaseTest {
	
	
	@Test(enabled = false)
	public void buscarResistencia() {
		driver.get("https://google.com.ar");

		GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
		googleSearchPage.fillTextBox("Resistencia wiki");
		GoogleResultPage googleResultPage = googleSearchPage.clickSearchButton(driver);
		WikiArticlePage wikiArticlePage = googleResultPage.clickFirstResult(WikiArticlePage.class);
		assertEquals(wikiArticlePage.getFirstHeadingText(), "Resistencia (ciudad)");
	}	
	
	@Test(enabled = false)
	public void buscarFormosa() {
			driver.get("https://google.com.ar");
			
			GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
			googleSearchPage.fillTextBox("Formosa ciudad wiki");
			GoogleResultPage googleResultPage = googleSearchPage.clickSearchButton(driver);
			WikiArticlePage wikiArticlePage = googleResultPage.clickFirstResult(WikiArticlePage.class);
			assertEquals(wikiArticlePage.getFirstHeadingText(), "Formosa (ciudad)");
	}
	
	@Test(dataProvider = "listaDePrueba")
	public void buscarEnGoogle(String query, String wikiTitle) {
			driver.get("https://google.com.ar");
			GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
			googleSearchPage.fillTextBox(query);
			GoogleResultPage googleResultPage = googleSearchPage.clickSearchButton(driver);
			WikiArticlePage wikiArticlePage = googleResultPage.clickFirstResult(WikiArticlePage.class);
			assertEquals(wikiArticlePage.getFirstHeadingText(), wikiTitle);
	}
	
	@Test(dataProvider = "listaDePrueba")//con esto le decimos que tome los datos del dataprovider
	public void buscarEnYahoo(String query, String result){
		driver.get("https://ar.search.yahoo.com/");
		
		YahooSearchPage searchPage = new YahooSearchPage(driver);
		searchPage.completarCampoDeBusqueda(query);
		YahooResultPage resultPage = searchPage.clickBotonBuscar();
		WikiArticlePage articlePage = resultPage.clickFirstResultLink();
		assertEquals(articlePage.getFirstHeadingText(), result);		
	}
	
	@DataProvider(name = "listaDePrueba") //identificador del dataprovider
	public static Object[][] valoresAprobar(){
		return new Object[][] { { "Resistencia ciudad wiki", "Resistencia (ciudad)" },
			{ "Corrientes capital wikipedia", "Corrientes (ciudad)" }, 
			{ "Formosa capital wiki", "Formosa (ciudad)" } };
	}
}