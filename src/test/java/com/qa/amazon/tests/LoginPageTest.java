package com.qa.amazon.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.amazon.base.BaseTest;
import com.qa.amazon.pages.HomePage;
import com.qa.amazon.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;

public class LoginPageTest extends BaseTest {

//	WebDriver driver;
	LoginPage lPage;
	HomePage hPage;

	@BeforeMethod
	public void setup() {
		System.out.println("@BeforeMethod");
		lPage = new LoginPage(driver);
	}

	@Test(priority = 1)
	public void verifyTitle() {
		System.out.println("verifyTitle() " + driver);
		LOG.info("verifyTitle() " + driver);
		Assert.assertEquals(lPage.getPageTitle().trim(), "Amazon.com. Spend less. Smile more.", "Title doesnt match");
	}

	@Epic("Login Verification")
	@Description("Verifying the login functionality")
	@Story("User can login with valid username and password")
	@Test(priority = 2)
	public void login() throws InterruptedException {
		lPage.openSignInPage();
		hPage = new HomePage(driver);
		Thread.sleep(2000);

	}

}
