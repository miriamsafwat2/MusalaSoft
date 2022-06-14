package musala.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import musala.utility.Actions;

public class ApplyPage extends Page {
	
	public ApplyPage() {
		super();
	}
	
	@FindBy(name = "your-name")
	WebElement txt_Name;
	
	@FindBy(name = "your-email")
	WebElement txt_Email;
	
	@FindBy(name = "mobile-number")
	WebElement txt_Mobile;
	
	@FindBy(name = "uploadtextfield")
	WebElement txt_UploadCV;
	
	@FindBy(name = "adConsentChx")
	WebElement chx_Consent;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement btn_Send;
	
	@FindBy(xpath = "//div[@class='wpcf7-response-output']")
	WebElement lbl_ErrorMessage;
	
	// *********** Methods **************
	
	public void fillForm(String name, String email, String mobile, String cvPath) {
		Actions.waitUntilVisible(txt_Name);
		
		Actions.type(txt_Name, name);
		Actions.type(txt_Email, email);
		Actions.type(txt_Mobile, mobile);
		Actions.type(txt_UploadCV, cvPath);
		
		Actions.clickByJavascript(chx_Consent);
	}
	
	public void submitForm() {
		Actions.clickByJavascript(btn_Send);
	}
	
	public String getErrorMessage() {
		return lbl_ErrorMessage.getText();
	}
}
