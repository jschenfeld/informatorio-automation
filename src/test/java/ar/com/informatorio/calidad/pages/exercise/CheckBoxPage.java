package ar.com.informatorio.calidad.pages.exercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ar.com.informatorio.calidad.pages.BasePage;

public class CheckBoxPage extends BasePage {
	
	@FindBy(xpath = "//input[1]")
	private WebElement checkbox1;
	
	@FindBy(xpath = "//input[2]")
	private WebElement checkbox2;
	

	public CheckBoxPage(WebDriver driver) {
		super(driver);
	}
	
	public void checkCheckBox1(boolean isChecked){
		//pregunto si quiero que este chequeado
		if(isChecked){
			if(!checkbox1.isSelected()){
			//pregunto si NO esta chequedo, lo chequeado
				System.out.println("Select checkbox 1");
				checkbox1.click();
			} else {
				System.out.println("ya esta selecionado checkbox 1");
			}
		} else {
			if(checkbox1.isSelected()){
				System.out.println("Deselect checkbox 1");
				checkbox1.click();
			} else {
				System.out.println("ya esta deselecionado checkbox 1");
			}
		}
	}
	
	public void checkCheckBox2(boolean isChecked){
		//pregunto si quiero que este chequeado
		if(isChecked){
			//pregunto si NO esta chequedo, lo chequeo
			if(!checkbox2.isSelected()){
				System.out.println("Select checkbox 2");
				checkbox2.click();
			} else {
				System.out.println("ya esta selecionado checkbox 2");
			}
		} else {
		// codigo para verificar que este deselecionado
			
			//si esta chequeado lo deschequeo
			if(checkbox2.isSelected()){
				System.out.println("Deselect checkbox 2");
				checkbox2.click();
			} else {
				System.out.println("ya esta deselecionado checkbox 2");
			}
		}
	}
	
	public void clickCheckBox1(){
		checkbox1.click();
	}
	
	public void clickCheckBox2(){
		checkbox2.click();
	}
	
	public boolean isCheckedCheckBox1(){
		return checkbox1.isSelected();
	}
	
	public boolean isCheckedCheckBox2(){
		return checkbox2.isSelected();
	}
}
