package musala.utility;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

	/*
	 * Factory method for getting browsers
	 */
	public static WebDriver getBrowser(String browserName) {
		WebDriver driver = null;

		switch (browserName) {
		case "Firefox":
			driver = getFirefoxDriver(driver);
		case "Chrome":
			driver = getChromeDriver(driver);
			break;
		}

		return driver;
	}

	private static WebDriver getChromeDriver(WebDriver driver) {
		driver = drivers.get("Chrome");
		if (driver != null)
			return driver;

		System.setProperty("webdriver.chrome.driver",
				Paths.get("").toAbsolutePath().toString() + "\\src\\Drivers\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        
		driver = new ChromeDriver(options);
		drivers.put("Chrome", driver);

		return driver;
	}

	private static WebDriver getFirefoxDriver(WebDriver driver) {
		driver = drivers.get("Firefox");
		if (driver != null)
			return driver;

		System.setProperty("webdriver.gecko.driver",
				Paths.get("").toAbsolutePath().toString() + "\\src\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		drivers.put("Firefox", driver);

		return driver;
	}

	public static void closeAllDriver() {
		for (String key : drivers.keySet()) {
			drivers.get(key).close();
			drivers.get(key).quit();
		}
	}
}
