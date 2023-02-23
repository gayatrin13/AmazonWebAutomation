package com.qa.amazon.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.amazon.base.BasePage;
import com.qa.amazon.util.Utility;

public class LoginPage extends BasePage {
	WebDriver driver;

	private static final String LOGIN_BUTTON_ID = "nav-link-accountList-nav-line-1";
	private static final String EMAIL_ID = "ap_email";
	private static final String CONTINUE_BUTTON_ID = "continue";
	private static final String PASSWORD_ID = "ap_password";
	private static final String SIGN_IN_BTN = "signInSubmit";
	private static final String PROTECT_ACCOUNT_TEXT = "//span[contains(text(),' To better protect your account, please re-enter your password ')]";
	private static final String CAPTCHA_TEXTBOX_ID = "auth-captcha-guess";
	@FindBy(id = LOGIN_BUTTON_ID)
	WebElement loginBTN;

	@FindBy(id = EMAIL_ID)
	WebElement emailTxt;

	@FindBy(id = CONTINUE_BUTTON_ID)
	WebElement continueBtn;

	@FindBy(id = PASSWORD_ID)
	WebElement passwordText;

	@FindBy(id = SIGN_IN_BTN)
	WebElement signInBTN;

	//// span[@class='a-list-item']
	//
	@FindBy(xpath = PROTECT_ACCOUNT_TEXT)
	WebElement protectAccntText;

	@FindBy(id = CAPTCHA_TEXTBOX_ID)
	WebElement captchaTextField;

	public LoginPage(WebDriver driver) {
		System.out.println("LoginPage Constructor");
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void openSignInPage() {
		System.out.println("open Sign in Page");
		waitHandler.waitForPageLoad(driver, loginBTN);

		loginBTN.click();
		enterEmail(props.getProperty("email"));
		continueBtn.click();
		enterPass();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		signInBTN.click();
//		waitForPageLoad(captchaTextField);
		try {
			while (protectAccntText.isDisplayed()) {
				System.out.println("Protect Account text is displayed.. Need to enter the password and captcha");
				enterPass();
				enterCaptcha();
				signInBTN.click();
			}
		} catch (NoSuchElementException e) {
			System.out.println(
					"Captcha Accepted... So not able to find the Text:'Protect Account text is displayed'.. So getting exception");
		}
	}

	private void enterEmail(String email) {
		emailTxt.clear();
		emailTxt.sendKeys(email);
	}

	private void enterPass() {
		passwordText.clear();
		passwordText.sendKeys(System.getenv(props.getProperty("pass")));

	}

	public String getPageTitle() {
		System.out.println("LoginPage getPageTitle");
		LOG.info("PageTitle");
		return this.driver.getTitle();
	}

	private void enterCaptcha() {
		File src = driver.findElement(By.id("auth-captcha-image")).getScreenshotAs(OutputType.FILE);
		System.out.println("Captcha image");
		String path = System.getProperty("user.dir") + "captcha.png";
		try {
			FileHandler.copy(src, new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		captchaTextField.clear();
		captchaTextField.sendKeys(Utility.captureTextFromImage(path));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
