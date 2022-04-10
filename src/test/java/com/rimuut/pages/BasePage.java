package com.rimuut.pages;

import com.rimuut.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {

	protected WebDriver driver;

	BasePage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}





}
