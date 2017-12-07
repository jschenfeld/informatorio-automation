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
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		driver.get("https://google.com.ar");
		
		WebElement searchTextBox = driver.findElement(By.name("q"));
		searchTextBox.clear();
		searchTextBox.sendKeys("Resistencia wiki", Keys.TAB);
		
		WebElement searchButton = driver.findElement(By.name("btnK")); 
		searchButton.click();
		
		WebElement firstResult = driver.findElement(By.xpath("(//*[@class='g']/descendant::a)[1]"));
		firstResult.click();
		
		WebElement firstHeading = driver.findElement(By.id("firstHeading"));
		
		assertEquals("Resistencia (ciudad)", firstHeading.getText());
        } finally {
        	if(null != driver){
        		driver.quit();
        	}
        }
	}

}
