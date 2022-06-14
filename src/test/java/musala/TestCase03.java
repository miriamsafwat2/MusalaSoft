package musala;

import org.junit.Test;

import musala.pageObject.ApplyPage;
import musala.pageObject.CareersPage;
import musala.pageObject.HomePage;
import musala.utility.Helpers;

public class TestCase03 {
	@Test
	public void testCase03() throws InterruptedException {
		HomePage homePage = new HomePage();
		homePage.navigateToCareers();
		
		CareersPage careersPage = new CareersPage();
		careersPage.checkOpenPositions();
		
		Thread.sleep(3000);
		boolean isVerified = Helpers.verifyURL("https://www.musala.com/careers/join-us/");
		assert(isVerified);
		
		careersPage.selectLocation("Anywhere");
		careersPage.chooseQA();
		
		isVerified = careersPage.verifyMainSectionsExist();
		assert(isVerified);
		
		Thread.sleep(3000);
		careersPage.apply();
		
		ApplyPage applyPage = new ApplyPage();
		applyPage.fillForm("my name", "wrong@mail", "", "C:\\Users\\miria\\OneDrive\\Desktop\\My Folder\\Interviews\\Musala\\Test Automation\\Musala Soft Test Automation Task - 12.2021.pdf");
		applyPage.submitForm();
		String errorMessage = applyPage.getErrorMessage();
		System.out.println(errorMessage);
		
	}
}
