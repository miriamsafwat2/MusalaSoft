package musala.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import musala.utility.BrowserFactory;
import musala.utility.Constant;

public class Page {

	public Page() {
		PageFactory.initElements(getDriver(), this);
	}
	
	protected static WebDriver getDriver() {
		return BrowserFactory.getBrowser(Constant.BrowserType);
	}
}
