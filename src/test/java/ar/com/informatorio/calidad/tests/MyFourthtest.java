package ar.com.informatorio.calidad.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import ar.com.informatorio.calidad.pages.GoogleResultPage;
import ar.com.informatorio.calidad.pages.GoogleSearchPage;
import ar.com.informatorio.calidad.pages.WikiArticlePage;

public class MyFourthtest extends BaseTest {

	@Test
	public void searchResistenciaInGoogle(){
		driver.get("https://www.google.com.ar");
		GoogleSearchPage searchPage = new GoogleSearchPage(driver);
		GoogleResultPage resultPage = searchPage.search("Resistencia wiki");
		WikiArticlePage articlePage = resultPage.openFirstResult(WikiArticlePage.class);
		assertEquals("Resistencia (ciudad)", articlePage.getFirstHeadingText());
	}
	
	@Test
	public void searchCorrientesInGoogle(){
		driver.get("https://www.google.com.ar");
		GoogleSearchPage searchPage = new GoogleSearchPage(driver);
		GoogleResultPage resultPage = searchPage.search("Corrientes capital wiki");
		WikiArticlePage articlePage = resultPage.openFirstResult(WikiArticlePage.class);
		assertEquals("Corrientes (ciudad)", articlePage.getFirstHeadingText());
	}
	
	@Test
	public void searchFormosaInGoogle(){
		driver.get("https://www.google.com.ar");
		GoogleSearchPage searchPage = new GoogleSearchPage(driver);
		GoogleResultPage resultPage = searchPage.search("Formosa capital wiki");
		WikiArticlePage articlePage = resultPage.openFirstResult(WikiArticlePage.class);
		assertEquals("Formosa (ciudad)", articlePage.getFirstHeadingText());
	}
	
	@Test
	public void searchRosarioInGoogle(){
		driver.get("https://www.google.com.ar");
		GoogleSearchPage searchPage = new GoogleSearchPage(driver);
		GoogleResultPage resultPage = searchPage.search("Rosario wiki");
		WikiArticlePage articlePage = resultPage.openFirstResult(WikiArticlePage.class);
		assertEquals("Rosario (Argentina)", articlePage.getFirstHeadingText());
	}
}
