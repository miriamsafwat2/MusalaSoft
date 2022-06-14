package musala.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookPage extends Page {

	public FacebookPage() {
		super();
	}
	
	@FindBy(xpath = "//div[@class=\"k4urcfbm\"]//div[@class=\"q9uorilb l9j0dhe7 pzggbiyp du4w35lb\"]/*[name()='svg']/*[name()='g']/*[name()='image']")
	WebElement img_ProfilePicture;
	
	public boolean verifyProfilePicture() {
		return img_ProfilePicture.isDisplayed();
	}
}
