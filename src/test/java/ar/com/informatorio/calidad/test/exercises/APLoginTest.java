package ar.com.informatorio.calidad.test.exercises;

import org.testng.annotations.Test;

import ar.com.informatorio.calidad.model.Usuario;
import ar.com.informatorio.calidad.pages.exercise.APAuthenticationPage;
import ar.com.informatorio.calidad.test.BaseTest;

public class APLoginTest extends BaseTest {


	@Test
	public void loginWithParameters(){
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		APAuthenticationPage page = new APAuthenticationPage(driver);
		page.login("jose@jose.com", "josejose");
	}
	
	@Test
	public void loginUsingDefaultConstructor(){
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		APAuthenticationPage page = new APAuthenticationPage(driver);
		Usuario usuario = new Usuario();
		usuario.setEmail("jose@jose.com");
		usuario.setPassword("josejose");
		page.login(usuario);
	}
	
	@Test
	public void loginUsingConstructorWith2Parameters(){
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		APAuthenticationPage page = new APAuthenticationPage(driver);
		Usuario usuario = new Usuario("jose@jose.com","josejose");
		page.login(usuario);
	}
	
	@Test
	public void loginUsingConstructorFullParameters(){
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		APAuthenticationPage page = new APAuthenticationPage(driver);
		Usuario usuario = new Usuario(1, "jona", "bravo", "jose@jose.com", "1111", "josejose");
		page.login(usuario);
	}
	
	@Test
	public void loginUsingConstructorWith2ParametersWrongLogin(){
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		APAuthenticationPage page = new APAuthenticationPage(driver);
		Usuario usuario = new Usuario("test@test.com","test");
		page.login(usuario);
	}
}
