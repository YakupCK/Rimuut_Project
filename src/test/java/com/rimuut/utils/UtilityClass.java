package com.rimuut.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UtilityClass {

	//driver object initialized by Hooks
	private static WebDriver driver = Driver.getDriver();

	//wait for an element to be clickable (with web element)
	public static void waitClickability(WebElement element, int timeOut){
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//wait for an element to be clickable (with By locator)
	public static void waitClickability(By locator, int timeOut){
		try {
			WebDriverWait wait = new WebDriverWait(driver,timeOut);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//wait till URL contains a specific text
	public static void waitForURLContains(String urlPart, int timeOut) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.urlContains(urlPart));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//wait for visibility of a web element
	public static void waitForVisibility(WebElement element, int timeOut) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//wait for visibility of a web element
	public static void waitForVisibilityAll(List<WebElement> elementList, int timeOut) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//wait till a new window gets opened
	public static void waitForNewWindow(){
		try {
			WebDriverWait wait = new WebDriverWait(driver, 4);
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//switch to another window by passing index number
	public static void switchToWindow(int index){
		try {
			waitForNewWindow();
			Set<String> windowHandles = driver.getWindowHandles();
			ArrayList<String> allTabs = new ArrayList<>(windowHandles);
			driver.switchTo().window(allTabs.get(index));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//wait for a web element till has a specific text
	public static void waitForText(WebElement element, String text){
		try {
			WebDriverWait wait = new WebDriverWait(driver, 6);
			wait.until(ExpectedConditions.textToBePresentInElement(element,text));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//click on a web element using JSexecutor
	public static void clickWithJSExe(WebElement element) {
		waitClickability(element,3);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	//attempt to click on a web element a couple of times
	public static void clickManyTimes(WebElement element) {
		waitClickability(element,3);
		for (int i = 0; i < 3; i++) {
			try {
				element.click();
			} catch (Exception e) {
				e.printStackTrace();
				try {
					Thread.sleep(1000);
				} catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		}
	}

	//open a new tab using JSexecutor
	public static void openNewTab(){
		((JavascriptExecutor) driver).executeScript("window.open();");
	}

	public static List<String> getTextasList(List<WebElement> elementList){
		List<String> textList = new ArrayList<>();

		for (int i = 0; i < elementList.size(); i++) {
			textList.add(elementList.get(i).getText());
		}

		return textList;
	}

	public static void staticWait(int time){
		try {
			Thread.sleep(time * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
