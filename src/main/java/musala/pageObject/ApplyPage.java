package musala.pageObject;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import musala.utility.Helpers;

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
		
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofMillis(10000));
		wait.until(ExpectedConditions.visibilityOf(txt_Name));
		
		txt_Name.sendKeys(name);
		txt_Email.sendKeys(email);
		txt_Mobile.sendKeys(mobile);
		txt_UploadCV.sendKeys(cvPath);
		
		Helpers.ClickByJavascript(chx_Consent);
	}
	
	public void submitForm() {
		Helpers.ClickByJavascript(btn_Send);
	}
	
	public String getErrorMessage() {
		return lbl_ErrorMessage.getText();
	}
}
