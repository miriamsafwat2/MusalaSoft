package musala;

import org.junit.Test;

import musala.pageObject.CareersPage;
import musala.pageObject.HomePage;

public class TestCase04 {
	@Test
	public void testCase04() throws InterruptedException {
		HomePage homePage = new HomePage();
		homePage.navigateToCareers();
		
		CareersPage careersPage = new CareersPage();
		careersPage.checkOpenPositions();
		
		Thread.sleep(3000);
		System.out.println("Filters by cities excluding 'Anywhere'");
		filterCareersByCity(careersPage, "Sofia");
		filterCareersByCity(careersPage, "Skopje");
	}

	private void filterCareersByCity(CareersPage careersPage, String cityName) throws InterruptedException {
		careersPage.selectLocation(cityName);
		Thread.sleep(3000);
		System.out.println(cityName);
		careersPage.printAllJobs();
	}
}
