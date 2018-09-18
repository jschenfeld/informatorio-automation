package ar.com.informatorio.calidad.test.exercises;

import org.testng.annotations.Test;

import ar.com.informatorio.calidad.pages.exercise.CheckBoxPage;
import ar.com.informatorio.calidad.pages.exercise.DropDownPage;
import ar.com.informatorio.calidad.test.BaseTest;

public class CheckboxesAndDropDownTest extends BaseTest {

	/*
	 * Interactuar con un menu desplegable usando la clase Select.
	 * La clase Select sirve si el menu usa los tags select y option
	 */
	@Test
	public void selectOptionByTextTest(){
		driver.get("https://the-internet.herokuapp.com/dropdown");
		DropDownPage dropDownPage = new DropDownPage(driver);
		/* El text se encuentra entre cada tag Option
		 * ejemplo: <option value="2">Option 2</option>
		 */
		dropDownPage.selectOptionByVisibleText("Option 2");
	}
	
	@Test
	public void selectOptionByValueTest(){
		driver.get("https://the-internet.herokuapp.com/dropdown");
		DropDownPage dropDownPage = new DropDownPage(driver);
		/* el value es un atribut que se encuentra dentro de cada tag option
		 * ejemplo: <option value="2">Option 2</option>
		 */
		dropDownPage.selectOptionByValue("2");
	}
	
	
	@Test
	public void selectOptionByIndexTest(){
		driver.get("https://the-internet.herokuapp.com/dropdown");
		DropDownPage dropDownPage = new DropDownPage(driver);
		dropDownPage.selectOptionByIndex(2);
	}
	
	
	/*
	 * Interatuar con un menu desplegable solo con webelement
	 */
	@Test
	public void selectOptionByText2Test(){
		driver.get("https://the-internet.herokuapp.com/dropdown");
		DropDownPage dropDownPage = new DropDownPage(driver);
		dropDownPage.selectOptionByVisibleText2("Option 2");
	}
	
	@Test(enabled = false)
	public void selectOptionByValue2Test(){
		driver.get("https://the-internet.herokuapp.com/dropdown");
		DropDownPage dropDownPage = new DropDownPage(driver);
		dropDownPage.selectOptionByValue2("2");
	}
	
	@Test
	public void selectOptionByIndex2Test(){
		driver.get("https://the-internet.herokuapp.com/dropdown");
		DropDownPage dropDownPage = new DropDownPage(driver);
		dropDownPage.selectOptionByIndex2(3);
	}
	
	//Diferentes maneras de interactuar con los checkboxs
	@Test
	public void simpleCheckBoxTest(){
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
		checkBoxPage.clickCheckBox1();
		System.out.println("Checkbox 1 is selected: " + checkBoxPage.isCheckedCheckBox1());
		checkBoxPage.clickCheckBox2();
		System.out.println("Checkbox 2 is selected: " + checkBoxPage.isCheckedCheckBox2());


	}
	
	@Test
	public void checkbox1SelectedAndCheckBox2UnSelectedTest(){
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
		checkBoxPage.checkCheckBox1(true);
		checkBoxPage.checkCheckBox2(false);
	}
}