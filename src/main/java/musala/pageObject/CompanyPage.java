package musala.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import musala.utility.Helpers;

public class CompanyPage extends Page {
	
	public CompanyPage() {
		super();
	}

	@FindBy(xpath = "//h2[text()='Leadership']")
	WebElement lbl_Leadership;
	
	@FindBy(xpath = "//footer//a[contains(@href,'facebook')]")
	WebElement lnk_Facebook;
	
	// *********** Methods ***********
	
	public boolean verifyLeadershipSection() {
		if(lbl_Leadership.isDisplayed())
			return true;
		return false;
	}

	public void clickFacebookLink() {
		lnk_Facebook.click();
		Helpers.switchTo("Musala Soft - Home | Facebook");
	}
}
