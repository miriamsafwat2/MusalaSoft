package musala.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import musala.utility.Actions;
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
		acceptCookies();
		Actions.click(btn_ContactUs);
	}

	public void navigateToCompany() throws InterruptedException {
		acceptCookies();
		Actions.click(lnk_Company);
	}
	
	public void navigateToCareers() throws InterruptedException {
		acceptCookies();
		Actions.click(lnk_Careers);
	}
	
	private void acceptCookies() throws InterruptedException {
		getDriver().get(Constant.URL);

		// TODO replace all thread.sleep with explicit wait
		Thread.sleep(8000);

		if (lnk_AcceptCookies.isDisplayed()) {
			Actions.click(lnk_AcceptCookies);
			Thread.sleep(4000);
		}
	}
}
