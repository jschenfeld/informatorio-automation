package ar.com.informatorio.calidad.pages;

import java.util.Set;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	
	public BasePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	protected static boolean isElementDisplayed(WebDriver driver, final WebElement element, int seconds) {
		try {
			(new WebDriverWait(driver, seconds)).until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver driver) {
					if (element.isDisplayed()) {
						return element;
					}
					return null;
				}
			});
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}
	
	protected void switchToLastWindows() {
		String actualWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String string : handles) {
			if(!string.equals(actualWindow)){
				driver.switchTo().window(string);
			}
		}
	}

	protected void switchToWindows(int index) {
		String[] array = driver.getWindowHandles().toArray(new String[0]);
		if(array.length >= index){
			driver.switchTo().window(array[index]);
		} else {
			System.out.println("No es posible cambiar a la ventana numero " + index + " solo hay " + array.length  + " ventanas disponibles.");
		}
	}
}
