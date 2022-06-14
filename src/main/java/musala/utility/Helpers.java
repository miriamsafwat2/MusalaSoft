package musala.utility;

import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Helpers {

	public static boolean verifyURL(String url) {
		return BrowserFactory.getBrowser(Constant.BrowserType).getCurrentUrl().equals(url);
	}

	public static void switchTo(String title) {
		for (String window : BrowserFactory.getBrowser(Constant.BrowserType).getWindowHandles()) {
			String currentTitle = BrowserFactory.getBrowser(Constant.BrowserType).switchTo().window(window).getTitle(); 
			if (currentTitle.equals(title))
				return;
		}
	}

	public static void GrabScreenShot(WebDriver driver, String name) throws IOException {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,
				new File(Paths.get("").toAbsolutePath().toString() + "\\Screenshots\\Screenshot_" + name + ".jpg"));
	}
}
