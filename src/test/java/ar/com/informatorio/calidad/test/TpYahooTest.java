package ar.com.informatorio.calidad.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ar.com.informatorio.calidad.pages.WikiArticlePage;
import ar.com.informatorio.calidad.pages.YahooResultPage;
import ar.com.informatorio.calidad.pages.YahooSearchPage;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class TpYahooTest {

	private WebDriver driver;
	
	@BeforeMethod
	public void setup(){
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		driver.get("https://ar.search.yahoo.com");
	}
	
	@Test
	public void searchResistenciaInGoogle(){
		YahooSearchPage searchPage = new YahooSearchPage(driver);
		YahooResultPage resultPage = searchPage.search("Resistencia ciudad wiki");
		WikiArticlePage articlePage = resultPage.openFirstResult(WikiArticlePage.class);
		assertEquals("Resistencia (ciudad)", articlePage.getFirstHeadingText());
	}
	
	@AfterMethod
	public void tearDown(){
		if(null != driver){
    		driver.quit();
    	}
	}
}
