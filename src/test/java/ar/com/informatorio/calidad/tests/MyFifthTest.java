package ar.com.informatorio.calidad.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ar.com.informatorio.calidad.pages.GoogleResultPage;
import ar.com.informatorio.calidad.pages.GoogleSearchPage;
import ar.com.informatorio.calidad.pages.WikiArticlePage;

public class MyFifthTest extends BaseTest {
	
	@DataProvider(name = "QueryProvider")
	public static Object[][] queryAndResult() {
		return new Object[][] { { "Resistencia wiki", "Resistencia (ciudad)" },
				{ "Corrientes capital wiki", "Corrientes (ciudad)" }, 
				{ "Formosa capital wiki", "Formosa (ciudad)" } };
	}

	@Test(dataProvider = "QueryProvider")
	public void searchGoogleDataProvider(String query, String result) {
		driver.get("https://www.google.com.ar");
		GoogleSearchPage googleMainPage = new GoogleSearchPage(driver);
		GoogleResultPage googleResultPage = googleMainPage.search(query);
		WikiArticlePage wikiArticlePage = googleResultPage.openFirstResult(WikiArticlePage.class);
		Assert.assertEquals(wikiArticlePage.getFirstHeadingText(), result);
	}
}
