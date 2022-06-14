package musala.utility;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions {
	
	public static void type(WebElement element, String text) {
		waitUntilVisible(element);
		element.sendKeys(text);
	}
	
	public static void click(WebElement element) {
		waitUntilVisible(element);
		element.click();
	}
	
	public static void selectByText(WebElement element, String text) {
		Select selector = new Select(element);
		selector.selectByVisibleText(text);
	}
	
	public static void clickByJavascript(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("arguments[0].click()", element);
	}
	
	public static void waitUntilVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofMillis(10000));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void switchTo(String title) {
		for (String window : getDriver().getWindowHandles()) {
			String currentTitle = getDriver().switchTo().window(window).getTitle(); 
			if (currentTitle.equals(title))
				return;
		}
	}
	
	private static WebDriver getDriver() {
		return BrowserFactory.getBrowser(Constant.BrowserType);
	}
}
