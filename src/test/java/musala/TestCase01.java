package musala;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.junit.Test;
import musala.pageObject.ContactUsPage;
import musala.pageObject.HomePage;

public class TestCase01 {
	
	String name;
	String email;
	String msg;
	String subject;
	String mobile;
	
	@Test
	public void testCase01() throws InterruptedException, IOException {
		prepareData();
		
		HomePage homePage = new HomePage();
		homePage.navigateToContactUs();
		
		ContactUsPage contactUsPage = new ContactUsPage();
		contactUsPage.fillTheForm(name, email, msg, subject, mobile);
		contactUsPage.submit();
		Thread.sleep(3000);
		
		String errorMessage = contactUsPage.getErrorMessage();
		assertEquals("Incorrect error message", "The e-mail address entered is invalid.", errorMessage);
	}
	
	private void prepareData() {
		name = "max";
		email = "asdf@asdf";
		msg = "hello";
		subject = "this is a subject";
		mobile = "1234567890";
	}
}
