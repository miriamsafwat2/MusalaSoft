package musala.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookPage extends Page {

	public FacebookPage() {
		super();
	}
	
	@FindBy(xpath = "//*[@id='mount_0_0_W2']//div/svg/g/image")
	WebElement img_ProfilePicture;
	
	public boolean verifyProfilePicture() {
		return img_ProfilePicture.isDisplayed();
	}
}
