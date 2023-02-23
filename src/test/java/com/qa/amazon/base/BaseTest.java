package com.qa.amazon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.qa.amazon.factory.BrowserFactory;

public class BaseTest {

	public static WebDriver driver;
	public Logger LOG = Logger.getLogger(BasePage.class);
	public static Properties props;

	@BeforeTest
	public void setup() throws FileNotFoundException, IOException, InterruptedException {
		System.out.println("Before TEst");
		String browser = "chrome";
		driver = BrowserFactory.getDriver(browser);
		PropertyConfigurator.configure(System.getProperty("user.dir") + "//log4j.properties");
		System.out.println(browser);
		System.out.println(driver);
		LOG.info("Browser: " + browser);
		props = new Properties();
		props.load(new FileInputStream(System.getProperty("user.dir") + "//config.properties"));
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(props.getProperty("implicitWait"))));
		driver.manage().window().maximize();
		driver.manage().timeouts()
				.pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(props.getProperty("implicitWait"))));
		driver.get(props.getProperty("baseUrl"));
		System.out.println("amazon.com");
		Thread.sleep(3000);

	}

//	public void setDriver(WebDriver driver) {
//		System.out.println("setDriver");
//
//		this.driver.set(driver);
//	}
//
//	public WebDriver getDriver() {
//		return driver.get();
//	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
