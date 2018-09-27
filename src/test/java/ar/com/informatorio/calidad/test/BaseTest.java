package ar.com.informatorio.calidad.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public abstract class BaseTest {

	protected WebDriver driver;
	final String GRID_HOST = "http://192.168.42.120:4444";
	private String navegador;

	@BeforeSuite
	public void getDriver() {
		System.out.println("Gettting browser driver.");
		ChromeDriverManager.getInstance().forceCache().setup();
		FirefoxDriverManager.getInstance().setup();
	}

	@BeforeMethod
	@Parameters("browser")
	public void abrirNavegador(@Optional String navegador) throws MalformedURLException {
		if (StringUtils.isBlank(navegador)) {
			navegador = "remoteLinuxFirefox";
		}
		this.navegador = navegador;
		
		System.out.println("Opening browser: " + navegador);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		switch (navegador) {
		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			// options.addArguments("--start-maximized");

			Map<String, Object> prefs = new HashMap<>();
			// Hide save credentials prompt
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			chromeOptions.setExperimentalOption("prefs", prefs);

			driver = new ChromeDriver(chromeOptions);
			break;
		case "firefox":
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
					"text/csv, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel");
			profile.setPreference("browser.download.dir", SystemUtils.IS_OS_WINDOWS ? "C:\\" : "~/");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setProfile(profile);
			driver = new FirefoxDriver(firefoxOptions);
			break;
		case "opera":
			driver = new OperaDriver();
			break;
		case "remoteLinuxChrome":
            capabilities.setBrowserName("chrome");
    		capabilities.setCapability("platformName","linux");
		    driver = new RemoteWebDriver(new URL(GRID_HOST + "/wd/hub"), capabilities);
		    break;
		case "remoteLinuxFirefox":
            capabilities.setBrowserName("firefox");
    		capabilities.setCapability("platformName","linux");
		    driver = new RemoteWebDriver(new URL(GRID_HOST + "/wd/hub"), capabilities);
		    break;
		case "remoteMacChrome":
            capabilities.setBrowserName("chrome");
    		capabilities.setCapability("platformName","mac");
		    driver = new RemoteWebDriver(new URL(GRID_HOST + "/wd/hub"), capabilities);
		    break;
		case "remoteWindowsChrome":
            capabilities.setBrowserName("chrome");
    		capabilities.setCapability("platformName","win10");
		    driver = new RemoteWebDriver(new URL(GRID_HOST + "/wd/hub"), capabilities);
		    break;
		case "remoteWindowsFirefox":
            capabilities.setBrowserName("firefox");
    		capabilities.setCapability("platformName","win10");
		    driver = new RemoteWebDriver(new URL(GRID_HOST + "/wd/hub"), capabilities);
		    break;
		case "remoteAndroidChrome":
            capabilities.setBrowserName("chrome");
    		capabilities.setCapability("platformName","Android");
    		capabilities.setCapability("deviceName", "Galaxy J7 Prime");
		    driver = new RemoteWebDriver(new URL(GRID_HOST + "/wd/hub"), capabilities);
		    break;
		default:
			throw new RuntimeException("El navegador " + navegador + " no esta soportado");
		}
//		driver.manage().window().maximize();
	}

	@AfterMethod
	public void cerrarNavegador() {
		System.out.println("Closing browser: " + navegador);
		if (null != driver) {
			driver.quit();
		}
	}
}