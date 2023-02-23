package com.qa.amazon.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.amazon.base.BasePage;
import com.qa.amazon.util.Utility;

public class HomePage extends BasePage {

	private static final String SEARCH_TEXTBOX_ID = "twotabsearchtextbox";
	private static final String selectText = "software testing";

//	private static final String TEXT_TO_SELECT_XPATH = "//div[@class='autocomplete-results-container']//div[@aria-label='"
//	+selectText+"']";
	private static final String ALL_SUGGESTIONS_XPATH = "//div[@class='autocomplete-results-container']/div[5]//div[@role='button']";
	private static final String ALL_SEARCH_RESULTS = "//div[starts-with(@data-cel-widget,'search_result') and @data-component-type='s-search-result']";
//	private static final String FIRST_FROM_SEARCH_RESULTS = "//div[starts-with(@data-cel-widget,'search_result_') and @data-component-type='s-search-result']";

	WebDriver driver;

	@FindBy(id = SEARCH_TEXTBOX_ID)
	WebElement searchBox;

//	@FindBy(xpath = TEXT_TO_SELECT_XPATH)
//	WebElement selectFromDropdown;

	public HomePage(WebDriver driver) {
		System.out.println("On  Home Page");
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void searchProduct() {
		enterSearchTerm(selectText);
		selectAProduct();
	}

	private void selectAProduct() {
		System.out.println("**************Selecting a product from a list");
		List<WebElement> searchResults = driver.findElements(By.xpath(ALL_SEARCH_RESULTS));
		System.out.println("list size : " + searchResults.size());
		for (WebElement webElement : searchResults) {
			System.out.println(">>>>searched item : " + webElement.getText());
		}
		// selecting first product displayed
		searchResults.get(0).click();
	}

	private void enterSearchTerm(String searchItem) {
		LOG.info("enterSearchTerm");
		waitHandler.waitForPageLoad(driver, searchBox);
		searchBox.clear();
		searchBox.click();
		searchBox.sendKeys(searchItem);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement selectedSuggestion = Utility.selectRandomSuggestion(ALL_SUGGESTIONS_XPATH, driver);
		selectedSuggestion.click();

	}

	public String getPageTitle() {
		System.out.println("LoginPage getPageTitle");
		LOG.info("PageTitle");
		return this.driver.getTitle();
	}
}
