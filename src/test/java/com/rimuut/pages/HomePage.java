package com.rimuut.pages;

import com.rimuut.utils.PropertyReader;
import com.rimuut.utils.UtilityClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage{

	@FindBy(css = ".input-control-icon.bg-heading")
	private WebElement businessBtn;

	@FindBy(css = "div.cookieControl__BarButtons")
	private WebElement acceptCookies;



	public void goToHomePage(){
		driver.get(PropertyReader.getProperty("url"));
		try {
			UtilityClass.waitClickability(acceptCookies,2);
			acceptCookies.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToMenu(String menu){
		String path = "//div[@id='navigation']//*[contains(text(),'"+menu+"')]";
		UtilityClass.waitClickability(driver.findElement(By.xpath(path)),2);
		driver.findElement(By.xpath(path)).click();
		try {
			UtilityClass.waitClickability(acceptCookies,2);
			acceptCookies.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void goToBusinessPage(){
		goToHomePage();
		UtilityClass.waitClickability(businessBtn,2);
		businessBtn.click();
	}


	public List<WebElement> getImageList(){

		UtilityClass.waitForVisibilityAll(driver.findElements(By.tagName("img")),2);
		List<WebElement> imageList = driver.findElements(By.tagName("img"));
		System.out.println(imageList.size());

		return imageList;
	}

	public List<String> getImageSRCs(){

		List<WebElement> imageList = getImageList();
		List<String> srcList = new ArrayList<>();
		for (int i = 0; i < imageList.size(); i++) {
			srcList.add(imageList.get(i).getAttribute("src"));
			System.out.println(srcList.get(i));
		}
		return srcList;
	}

	public void ifBrokenImage(List<String> list){

		int brokenImg = 0;

		for (int i = 0; i < list.size(); i++) {
			Response response = RestAssured.when().get(list.get(i));
			if (response.statusCode() != 200) {
				brokenImg++;
			}
		}

		Assert.assertEquals("there are " + brokenImg + " broken image on the page", brokenImg,0  );
	}




}
