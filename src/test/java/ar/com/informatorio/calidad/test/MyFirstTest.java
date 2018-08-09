package ar.com.informatorio.calidad.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class MyFirstTest {

	public static void main(String[] args) {
		WebDriver driver = null;
        try {
        
		ChromeDriverManager.getInstance().forceCache().setup();
		//abro chrome
		driver = new ChromeDriver();
		driver.get("https://google.com.ar");
		
		By searchBoxLocator = By.name("q");
//		By locator = By.className("");
//		By locator = By.cssSelector(selector)
//		By locator = By.id(id)
//		By locator = By.linkText(linkText)
		WebElement searchTextBox = driver.findElement(searchBoxLocator);
		searchTextBox.sendKeys("Resistencia wiki", Keys.TAB);
		
		By buttonSearchLocator = By.name("btnK");
		WebElement searchButton = driver.findElement(buttonSearchLocator); 
		searchButton.click();

		By firstResultLocator = By.xpath("(//*[@class='g']/descendant::a)[1]");
		WebElement firstResult = driver.findElement(firstResultLocator);
		firstResult.click();
		
		By getHearderLocator = By.id("firstHeading");
		WebElement firstHeading = driver.findElement(getHearderLocator);
		
		assertEquals("Resistencia (ciudad)", firstHeading.getText());
        } finally {
        	if(null != driver){
        		driver.quit();
        	}
        }
	}
}