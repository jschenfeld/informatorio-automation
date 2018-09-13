package ar.com.informatorio.calidad.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import ar.com.informatorio.calidad.pages.TheInternetDynamicPage;

public class WaitExampleTest extends BaseTest {

	@Test
	public void waitTest(){
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		
		TheInternetDynamicPage theInternetDynamicPage = new TheInternetDynamicPage(driver);
		theInternetDynamicPage.clickStartButton();
		assertEquals(theInternetDynamicPage.getMessage(), "Hello World!");
	}

}
