package musala;

import org.junit.Test;

import musala.pageObject.ApplyPage;
import musala.pageObject.CareersPage;
import musala.pageObject.HomePage;
import musala.utility.Helpers;

public class TestCase03 {
	@Test
	public void testCase03() throws InterruptedException {
		applyInQACareer("Anywhere");
		submitForm();
	}

	private void applyInQACareer(String location) throws InterruptedException {
		HomePage homePage = new HomePage();
		homePage.navigateToCareers();
		
		CareersPage careersPage = new CareersPage();
		careersPage.checkOpenPositions();
		
		Thread.sleep(3000);
		boolean isVerified = Helpers.verifyURL("https://www.musala.com/careers/join-us/");
		assert(isVerified);
		
		careersPage.selectLocation(location);
		careersPage.chooseQA();
		
		isVerified = careersPage.verifyMainSectionsExist();
		assert(isVerified);
		
		Thread.sleep(3000);
		careersPage.apply();
	}

	private void submitForm() {
		ApplyPage applyPage = new ApplyPage();
		applyPage.fillForm("my name", "wrong@mail", "", "[Enter CV path here]");
		applyPage.submitForm();
		String errorMessage = applyPage.getErrorMessage();
		System.out.println(errorMessage);
	}
}
