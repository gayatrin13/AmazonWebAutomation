package com.qa.amazon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.qa.amazon.util.WebDriverWaitHandler;

public class BasePage {

//	WebDriver driver;
	public Logger LOG;
	public static Properties props;
	public static WebDriverWaitHandler waitHandler = new WebDriverWaitHandler();

	public BasePage() {// WebDriver driver) {
		System.out.println("BasePage Constructor");
		PropertyConfigurator.configure(System.getProperty("user.dir") + "//log4j.properties");
		LOG = Logger.getLogger(BasePage.class);
		props = new Properties();
		try {
			props.load(new FileInputStream(System.getProperty("user.dir") + "//config.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
