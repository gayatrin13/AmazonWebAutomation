package com.qa.amazon.util;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Utility {

	public static int randomGenerator(int max) {
		return (int) (Math.random() * max);
	}

	public static WebElement selectRandomSuggestion(String xpath, WebDriver driver) {

		List<WebElement> elmts = driver.findElements(By.xpath(xpath));

		int selectedSuggestion = Utility.randomGenerator(elmts.size());
		System.out.println("random suggestion:" + selectedSuggestion);
		return elmts.get(selectedSuggestion);
	}

	public static void main(String[] args) {
//		System.out.println(randomGenerator(5));
//		captureTextFromImage("C:\\Users\\gayat\\OneDrive\\Pictures\\CodeCertificate.jpg");

	}

	public void captureScreenshot(WebDriver driver, WebElement elemnt) {

	}

	public static String captureTextFromImage(String path) {
		ITesseract image = new Tesseract();
		String captchaText = null;
		try {
			captchaText = image.doOCR(new File(path));

		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		captchaText = captchaText.replace(" ", "");
		System.out.println("Captcha Text :" + captchaText);
		return captchaText;
	}
}
