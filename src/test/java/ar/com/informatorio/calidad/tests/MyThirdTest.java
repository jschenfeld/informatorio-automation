package ar.com.informatorio.calidad.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ar.com.informatorio.calidad.pages.GoogleResultPage;
import ar.com.informatorio.calidad.pages.GoogleSearchPage;
import ar.com.informatorio.calidad.pages.WikiArticlePage;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class MyThirdTest {
	
	private WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com.ar");
	}
	
	@Test
	public void searchResistenciaInGoogle(){
		GoogleSearchPage searchPage = new GoogleSearchPage(driver);
		GoogleResultPage resultPage = searchPage.search("Resistencia wiki");
		WikiArticlePage articlePage = resultPage.openFirstResult(WikiArticlePage.class);
		assertEquals("Resistencia (ciudad)", articlePage.getFirstHeadingText());
	}
	
	@Test
	public void searchCorrientesInGoogle(){
		GoogleSearchPage searchPage = new GoogleSearchPage(driver);
		GoogleResultPage resultPage = searchPage.search("Corrientes capital wiki");
		WikiArticlePage articlePage = resultPage.openFirstResult(WikiArticlePage.class);
		assertEquals("Corrientes (ciudad)", articlePage.getFirstHeadingText());
	}
	
	@Test
	public void searchFormosaInGoogle(){
		GoogleSearchPage searchPage = new GoogleSearchPage(driver);
		GoogleResultPage resultPage = searchPage.search("Formosa capital wiki");
		WikiArticlePage articlePage = resultPage.openFirstResult(WikiArticlePage.class);
		assertEquals("Formosa (ciudad)", articlePage.getFirstHeadingText());
	}
	
	@Test
	public void searchRosarioInGoogle(){
		GoogleSearchPage searchPage = new GoogleSearchPage(driver);
		GoogleResultPage resultPage = searchPage.search("Rosario wiki");
		WikiArticlePage articlePage = resultPage.openFirstResult(WikiArticlePage.class);
		assertEquals("Rosario (Argentina)", articlePage.getFirstHeadingText());
	}
	
	@AfterMethod
	public void tearDown() {
		if (null != driver) {
			driver.quit();
		}
	}
	
}
