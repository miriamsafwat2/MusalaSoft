package musala.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import musala.utility.Constant;

public class HomePage extends Page {

	public HomePage() {
		super();
	}

	@FindBy(id = "wt-cli-accept-all-btn")
	WebElement lnk_AcceptCookies;

	@FindBy(xpath = "//button[span[text()='Contact us']]")
	WebElement btn_ContactUs;

	@FindBy(xpath = "//div[@id='menu']//a[contains(.,'Company')]")
	WebElement lnk_Company;

	@FindBy(xpath = "//div[@id='menu']//a[contains(.,'Careers')]")
	WebElement lnk_Careers;

	// *********** Methods **************

	public void navigateToContactUs() throws InterruptedException {
		getDriver().get(Constant.URL);

		// TODO replace all thread.sleep with explicit wait
		Thread.sleep(8000);

		if (lnk_AcceptCookies.isDisplayed()) {
			lnk_AcceptCookies.click();
			Thread.sleep(4000);
		}

		btn_ContactUs.click();
	}

	public void navigateToCompany() throws InterruptedException {
		getDriver().get(Constant.URL);

		Thread.sleep(8000);

		if (lnk_AcceptCookies.isDisplayed()) {
			lnk_AcceptCookies.click();
			Thread.sleep(4000);
		}

		lnk_Company.click();
	}
	
	public void navigateToCareers() throws InterruptedException {
		getDriver().get(Constant.URL);

		Thread.sleep(8000);

		if (lnk_AcceptCookies.isDisplayed()) {
			lnk_AcceptCookies.click();
			Thread.sleep(4000);
		}

		lnk_Careers.click();
	}
}
