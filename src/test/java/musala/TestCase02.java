package musala;

import org.junit.Test;

import musala.pageObject.CompanyPage;
import musala.pageObject.FacebookPage;
import musala.pageObject.HomePage;
import musala.utility.Helpers;

public class TestCase02 {

	@Test
	public void testCase02() throws InterruptedException {
		HomePage homePage = new HomePage();
		homePage.navigateToCompany();
		
		CompanyPage companyPage = new CompanyPage();
		boolean isURLCorrect = Helpers.verifyURL("https://www.musala.com/company/");
		assert(isURLCorrect);
		
		boolean isLeadershipSectionExist = companyPage.verifyLeadershipSection();
		assert(isLeadershipSectionExist);
		
		companyPage.clickFacebookLink();
		
		isURLCorrect = Helpers.verifyURL("https://www.facebook.com/MusalaSoft?fref=ts");
		assert(isURLCorrect);
		
		FacebookPage facebookPage = new FacebookPage();
		boolean isProfilePictureExist = facebookPage.verifyProfilePicture();
		assert(isProfilePictureExist);
	}
}
