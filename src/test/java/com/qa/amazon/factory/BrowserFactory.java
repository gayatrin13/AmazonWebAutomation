package com.qa.amazon.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	public static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			driver = new ChromeDriver();
		}

		return driver;
	}

	public static WebDriver getDriver(String browser) {
		if (driver == null) {
			if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();

			} else if (browser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();

			} else if (browser.equalsIgnoreCase("IE")) {
				driver = new InternetExplorerDriver();

			} else {
				driver = new ChromeDriver();
			}
		}

		return driver;
	}
}
