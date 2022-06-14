package musala.pageObject;

import java.util.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import musala.utility.Helpers;

public class CareersPage extends Page {

	public CareersPage() {
		super();
	}
	
	@FindBy(xpath = "//button//span[contains(.,'Check our open positions')]")
	WebElement btn_CheckOpenPositions;
	
	@FindBy(id = "get_location")
	WebElement select_GetLocation;
	
	@FindBy(xpath = "//img[@alt='Automation QA Engineer']")
	WebElement img_AutomationEngineer;
	
	@FindBy(xpath = "//h2[text()='General description']")
	WebElement lbl_GeneralDescription;
	
	@FindBy(xpath = "//h2[text()='Requirements']")
	WebElement lbl_Requirements;
	
	@FindBy(xpath = "//h2[text()='Responsibilities']")
	WebElement lbl_Responsibilities;
	
	@FindBy(xpath = "//h2[text()='What we offer']")
	WebElement lbl_WhatWeOffer;
	
	@FindBy(xpath = "//input[@value='Apply']")
	WebElement btn_Apply;
	
	@FindBy(xpath = "//div[@class='card']//h2")
	List<WebElement> jobTitles;
	
	@FindBy(xpath = "//div[@class='card-container']/a")
	List<WebElement> jobUrl;
	
	@FindBy(xpath = "//p[@class='card-jobsHot__location']")
	List<WebElement> jobCity;
	
	// *********** Methods **************
	
	public void checkOpenPositions() {
		btn_CheckOpenPositions.click();
	}
	
	public void selectLocation(String selection) {
		Select getLocation = new Select(select_GetLocation);
		getLocation.selectByVisibleText(selection);
	}
	
	public void chooseQA() {
		img_AutomationEngineer.click();
	}

	public boolean verifyMainSectionsExist() {
		if(!lbl_GeneralDescription.isDisplayed())
			return false;
		if(!lbl_Requirements.isDisplayed())
			return false;
		if(!lbl_Responsibilities.isDisplayed())
			return false;
		if(!lbl_WhatWeOffer.isDisplayed())
			return false;
		return true;
	}
	
	public void apply() {
		Helpers.ClickByJavascript(btn_Apply);
	}

	public void printAllJobs() {
		for(int i = 0; i < jobTitles.size(); i++) {
			if(getCity(i).equals("Anywhere"))
				continue;
			System.out.println("Position: " + getPosition(i));
			System.out.println("More info: " + getURL(i));
			System.out.println();
		}
	}

	private String getCity(int i) {
		return jobCity.get(i).getText();
	}

	private String getPosition(int i) {
		return jobTitles.get(i).getText();
	}

	private String getURL(int i) {
		return jobUrl.get(i).getAttribute("href");
	}
}
