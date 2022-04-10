package com.rimuut.stepdefs;

import com.rimuut.pages.HomePage;
import com.rimuut.utils.Driver;
import com.rimuut.utils.PropertyReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class ImageStepDef {

	WebDriver driver = Driver.getDriver();
	List<String> srcList = new ArrayList<>();
	private HomePage homePage = new HomePage();

	@Given("The user is on the homepage")
	public void the_user_is_on_the_homepage() {
		driver.get(PropertyReader.getProperty("url"));

	}

	@When("the user checks the images")
	public void the_user_checks_the_images() {
		srcList = homePage.getImageSRCs();
	}

	@Then("There is no any broken image on the page")
	public void there_is_no_any_broken_image_on_the_page() {
		homePage.ifBrokenImage(srcList);
	}

	@Given("The user is on the business page")
	public void the_User_Is_On_The_Business_Page() {
		homePage.goToBusinessPage();
	}
}
