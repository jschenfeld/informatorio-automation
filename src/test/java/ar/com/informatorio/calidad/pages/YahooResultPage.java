package ar.com.informatorio.calidad.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YahooResultPage {
	private WebDriver driver;

	@FindBy(xpath = "(//*[@class='title']/descendant::a)[1]")
	private WebElement firstResultLink;

	public YahooResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public <T> T openFirstResult(Class<T> returnPage) {
		firstResultLink.click();		
		switchToWindows(1);
		return PageFactory.initElements(driver, returnPage);
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
