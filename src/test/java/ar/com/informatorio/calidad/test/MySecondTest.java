package ar.com.informatorio.calidad.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ar.com.informatorio.calidad.pages.GoogleResultPage;
import ar.com.informatorio.calidad.pages.GoogleSearchPage;
import ar.com.informatorio.calidad.pages.WikiArticlePage;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class MySecondTest {

	public static void main(String[] args) {
		WebDriver driver = null;
        try {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		driver.get("https://google.com.ar");

		GoogleSearchPage searchPage = new GoogleSearchPage(driver);
		GoogleResultPage resultPage = searchPage.search("Resistencia wiki");
		WikiArticlePage articlePage = resultPage.openFirstResult(WikiArticlePage.class);
		assertEquals("Resistencia (ciudad)", articlePage.getFirstHeadingText());

        } finally {
        	if(null != driver){
        		driver.quit();
        	}
        }
	}
}
