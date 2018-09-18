package ar.com.informatorio.calidad.pages.exercise;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import ar.com.informatorio.calidad.pages.BasePage;

public class DropDownPage extends BasePage {

	@FindBy(id = "dropdown")
	private WebElement dropdown;
	
	@FindBys({@FindBy(tagName = "option")})
	private List<WebElement> options;
	
	public DropDownPage(WebDriver driver) {
		super(driver);
	}
	
	public void selectOptionByVisibleText(String option){
		Select dropdownSelect = new Select(dropdown);
		dropdownSelect.selectByVisibleText(option);
	}

	public void selectOptionByValue(String value){
		Select dropdownSelect = new Select(dropdown);
		dropdownSelect.selectByValue(value);
	}
	
	public void selectOptionByIndex(int index){
		Select dropdownSelect = new Select(dropdown);
		dropdownSelect.selectByIndex(index);
	}
	
	// Seleccionando en un dropdown sin usar la Clase Select
	public void selectOptionByIndex2(int index){
		dropdown.click();
		options.get(index).click();
	}
	
	
	public void selectOptionByVisibleText2(String text){
		dropdown.click();
		for (WebElement option : options) {
			if(option.getText().equalsIgnoreCase(text)){
				option.click();
			}
		}
	}
	
	public void selectOptionByValue2(String value){
		dropdown.click();
		for (WebElement option : options) {
			if(option.getAttribute("value").equalsIgnoreCase(value)){
				option.click();
			}
		}
	}
}
