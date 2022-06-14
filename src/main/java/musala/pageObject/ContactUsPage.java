package musala.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import musala.utility.Actions;

public class ContactUsPage extends Page {
	
	public ContactUsPage() {
		super();
	}
	
	@FindBy(name = "your-name")
	WebElement txt_Name;

	@FindBy(name = "your-email")
	WebElement txt_Email;

	@FindBy(name = "mobile-number")
	WebElement txt_Mobile;

	@FindBy(name = "your-subject")
	WebElement txt_Subject;

	@FindBy(name = "your-message")
	WebElement txt_Message;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement btn_Submit;

	@FindBy(xpath = "//span[@class='wpcf7-form-control-wrap your-email']/span[@class='wpcf7-not-valid-tip']")
	WebElement lbl_MailError;

	// *********** Methods ***********

	public void fillTheForm(String name, String email, String msg, String subject, String mobile) {
		Actions.type(txt_Name, name);
		Actions.type(txt_Email, email);
		Actions.type(txt_Message, msg);
		Actions.type(txt_Subject, subject);
		Actions.type(txt_Mobile, mobile);
	}

	public void submit() {
		Actions.click(btn_Submit);
	}

	public String getErrorMessage() {
		return lbl_MailError.getText();
	}
}
