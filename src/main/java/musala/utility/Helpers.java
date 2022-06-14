package musala.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Helpers {

	public static boolean verifyURL(String url) {
		return getDriver().getCurrentUrl().equals(url);
	}

	public static void switchTo(String title) {
		for (String window : getDriver().getWindowHandles()) {
			String currentTitle = getDriver().switchTo().window(window).getTitle(); 
			if (currentTitle.equals(title))
				return;
		}
	}

	public static void GrabScreenShot(WebDriver driver, String name) throws IOException {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,
				new File(Paths.get("").toAbsolutePath().toString() + "\\Screenshots\\Screenshot_" + name + ".jpg"));
	}
	
	public static void ClickByJavascript(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("arguments[0].click()", element);
	}
	
	private static WebDriver getDriver() {
		return BrowserFactory.getBrowser(Constant.BrowserType);
	}
}
