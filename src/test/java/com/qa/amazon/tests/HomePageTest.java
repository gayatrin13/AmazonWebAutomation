package com.qa.amazon.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.amazon.base.BaseTest;
import com.qa.amazon.pages.HomePage;
import com.qa.amazon.pages.ProductDetailsPage;

public class HomePageTest extends BaseTest {

	HomePage hPage;
	ProductDetailsPage prodPage;

	@BeforeClass
	public void setUP() {
		hPage = new HomePage(driver);
	}

	@Test(priority = 1)
	public void verifyTitle() {
		System.out.println("Verify Page Title ");
		LOG.info("Verify Page Title ");
		Assert.assertEquals(hPage.getPageTitle().trim(), "Amazon.com. Spend less. Smile more.", "Title doesnt match");
	}

	@Test(priority = 2)
	public void searchProduct() throws InterruptedException {
		hPage.searchProduct();
		Thread.sleep(4000);
		System.out.println("Searching product");
		prodPage = new ProductDetailsPage(driver);

	}
}
