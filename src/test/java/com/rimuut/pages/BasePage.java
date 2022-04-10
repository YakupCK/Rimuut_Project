package com.rimuut.pages;

import com.rimuut.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {

	protected WebDriver driver;

	//to initialize @FindBy annotations with PageFactory class
	BasePage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}





}
