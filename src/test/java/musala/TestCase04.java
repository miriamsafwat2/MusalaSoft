package musala;

import org.junit.Test;

import musala.pageObject.CareersPage;
import musala.pageObject.HomePage;

public class TestCase04 {
	
	HomePage homePage;
	CareersPage careersPage;
	
	@Test
	public void testCase04() throws InterruptedException {
		homePage = new HomePage();
		homePage.navigateToCareers();
		
		careersPage = new CareersPage();
		careersPage.checkOpenPositions();
		
		Thread.sleep(3000);
		System.out.println("Filters by cities excluding 'Anywhere'");
		filterCareersByCity("Sofia");
		filterCareersByCity("Skopje");
	}

	private void filterCareersByCity(String cityName) throws InterruptedException {
		careersPage.selectLocation(cityName);
		Thread.sleep(3000);
		System.out.println(cityName);
		careersPage.printAllJobs();
	}
}
