package com.qa.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.amazon.base.BasePage;

public class ProductDetailsPage extends BasePage {

	WebDriver driver;

	@FindBy(css = "#add-to-cart-button")
	WebElement addToCart;

	public ProductDetailsPage(WebDriver driver) {
		System.out.println("On ProductDetailsPage");
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	waitHandler.waitForPageLoad(driver, addToCart);
	public String getPageTitle() {
		return driver.getTitle();
	}

	public void addToCart() {
		addToCart.click();
	}

}
