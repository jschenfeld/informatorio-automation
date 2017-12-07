package ar.com.informatorio.calidad.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.OperaDriverManager;

public class BaseParameterTest {

	protected WebDriver driver;
	protected String browser = "Chrome";
	protected String device;
	protected WebDriverWait wait;
	
	@BeforeSuite
	@Parameters("browser")
	public void suiteSetup(@Optional String browser) {
		if(StringUtils.isNotBlank(browser)){
			this.browser = browser;
		}
		switch (this.browser) {
		case "Firefox":
			OperaDriverManager.getInstance().setup();
			break;
		case "Chrome":
			ChromeDriverManager.getInstance().setup();
			break;
		default:
		}
	}
	

	@BeforeMethod
	@Parameters(value = { "device", "url" })
	public void setup(@Optional String device, String url) {
		if(StringUtils.isNotBlank(device)){
			this.device = device;
		}
		switch (this.browser) {
		case "Firefox":
			driver = new FirefoxDriver();
			break;
		case "Chrome":
			driver = new ChromeDriver(customOptions());
			break;
		default:
		}
		wait = new WebDriverWait(driver, 30);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() {
		if (null != driver) {
			driver.quit();
		}
	}

	private ChromeOptions customOptions() {
		ChromeOptions options = new ChromeOptions();
		// Disable extensions and hide infobars
		options.addArguments("--disable-extensions");
		options.addArguments("disable-infobars");
		options.addArguments("--lang=es");

		// Disabled suggestion to save password
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("intl.accept_languages", "es");

		options.setExperimentalOption("prefs", prefs);

		if (StringUtils.isNotBlank(device)) {
			Map<String, String> mobileEmulation = new HashMap<>();
			mobileEmulation.put("deviceName", device);
			// options.addArguments("--enable-web-app-frame");
			options.addArguments("--enable-mobile-emulation");
			options.setExperimentalOption("mobileEmulation", mobileEmulation);
		} else {
			options.addArguments("--start-maximized");
		}
		return options;
	}
}
