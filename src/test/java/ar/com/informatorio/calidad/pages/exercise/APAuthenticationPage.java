package ar.com.informatorio.calidad.pages.exercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ar.com.informatorio.calidad.model.Usuario;
import ar.com.informatorio.calidad.pages.BasePage;

public class APAuthenticationPage extends BasePage {

	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "passwd")
	private WebElement password;
	
	@FindBy(id = "SubmitLogin")
	private WebElement submitButton;
	
	public APAuthenticationPage(WebDriver driver) {
		super(driver);
	}
	
	public void login(String pEmail, String pPassword){
		this.email.sendKeys(pEmail);
		this.password.sendKeys(pPassword);
		this.submitButton.click();
	}
	
	public void login(Usuario usuario){
		System.out.println(String.format("Login using user: %s, password: %s",
				usuario.getEmail(), usuario.getPassword()));
		this.email.sendKeys(usuario.getEmail());
		this.password.sendKeys(usuario.getPassword());
		this.submitButton.click();
	}
}
