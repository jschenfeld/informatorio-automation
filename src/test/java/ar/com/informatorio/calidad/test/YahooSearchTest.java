package ar.com.informatorio.calidad.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import ar.com.informatorio.calidad.pages.WikiArticlePage;
import ar.com.informatorio.calidad.pages.YahooResultPage;
import ar.com.informatorio.calidad.pages.YahooSearchPage;

public class YahooSearchTest extends BaseTest {
	
	
	@Test
	public void buscarResistenciaConYahoo(){
		driver.get("https://ar.search.yahoo.com/");
		
		YahooSearchPage searchPage = new YahooSearchPage(driver);
		searchPage.completarCampoDeBusqueda("Resistencia ciudad wiki");
		YahooResultPage resultPage = searchPage.clickBotonBuscar();
		WikiArticlePage wikiPage = resultPage.clickFirstResultLink();
		assertEquals(wikiPage.getFirstHeadingText(), "Resistencia (ciudad)");
	}

}
