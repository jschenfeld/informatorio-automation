package ar.com.informatorio.calidad.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class MyFirstTest {

	public static void main(String[] args) {
		WebDriver driver = null;
        try {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		driver.get("https://google.com.ar");
		driver.findElement(By.xpath("//input[@title='Buscar']")).clear();
		driver.findElement(By.xpath("//input[@title='Buscar']")).sendKeys("Resistencia wiki", Keys.TAB);
		driver.findElement(By.xpath("//input[@value='Buscar con Google']")).click();
		driver.findElement(By.xpath("(//*[@class='g']/descendant::a)[1]")).click();
		assertEquals("Resistencia (ciudad)", driver.findElement(By.id("firstHeading")).getText());
        } finally {
        	if(null != driver){
        		driver.quit();
        	}
        }
	}

}
