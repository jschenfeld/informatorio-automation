package ar.com.informatorio.calidad.pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		System.out.println("Loading PageFactory " + this.getClass().getSimpleName());
		PageFactory.initElements(driver, this);
	}

	protected void switchToLastWindows() {
		String actualWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String string : handles) {
			if (!string.equals(actualWindow)) {
				driver.switchTo().window(string);
			}
		}
	}

	protected boolean isElementPresent(int timeOutInSeconds, WebElement element) {
		System.out.println("Waiting for element.");
		return new WebDriverWait(driver, timeOutInSeconds)
				.pollingEvery(100L, TimeUnit.NANOSECONDS)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.visibilityOf(element)) != null;
	}
}