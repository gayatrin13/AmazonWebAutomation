package com.qa.amazon.util;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.amazon.base.BasePage;

public class WebDriverWaitHandler extends BasePage {

	public void waitForPageLoad(WebDriver driver, WebElement waitForElement) {

		new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(props.getProperty("elementWaitTimeoutSeconds"))))
				.until(ExpectedConditions.visibilityOf(waitForElement));

	}
}
