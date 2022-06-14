package musala.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import musala.utility.Actions;

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
		return lbl_Leadership.isDisplayed();
	}

	public void clickFacebookLink() {
		Actions.click(lnk_Facebook);
		Actions.switchTo("Musala Soft - Home | Facebook");
	}
}
