package com.rimuut.pages;

import com.rimuut.utils.UtilityClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PricingPage extends BasePage {

	@FindBy(css = "div#vs1__combobox span.vs__selected")
	private WebElement invoiceAmountDropdown;

	@FindBy(css = "div#vs2__combobox span.vs__selected")
	private WebElement payOutDropdown;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement invoiceAmount;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	public WebElement amountYouGet;

	@FindBy(css = "div.calculator__bottom span.hint")
	private WebElement rate;

	@FindBy(xpath = "//div[@class='input-wrapper']/span")
	private WebElement resultCurrency;

	//--------------------------------

	public void clickInvCurrDropd() {
		UtilityClass.waitClickability(invoiceAmountDropdown, 1);
		invoiceAmountDropdown.click();
	}

	public void clickPayOutCurrDropd(){
		UtilityClass.waitClickability(payOutDropdown,1);
		payOutDropdown.click();
	}

	public List<String> getInvoiceAmountCurr(){
		List<WebElement> currWebElList = driver.findElements(By.cssSelector("li span"));
		return UtilityClass.getTextasList(currWebElList);
	}

	public void verifyInvoiceAmountCurrencies(List<String> expectedList){
		Assert.assertEquals(getInvoiceAmountCurr(), expectedList);
	}

	public void selectInvoiceCurrency(String currency){
		clickInvCurrDropd();
		driver.findElement(By.xpath("//span[text()='" + currency + "']")).click();
	}

	public void selectPayOutCurrency(String currency){
		clickPayOutCurrDropd();
		driver.findElement(By.xpath("//span[text()='" + currency + "']")).click();
	}

	public void setInvoiceAmount(String amount){

		UtilityClass.staticWait(1);
		invoiceAmount.clear();
		invoiceAmount.sendKeys(amount);

	}

	public void getRate(String expectedRate){
		UtilityClass.staticWait(1);
		String[] actualRate = rate.getText().split("Applied rate is ");
		System.out.println(actualRate[1]);
		Assert.assertEquals(actualRate[1],expectedRate);
	}

	public String getResultCurrency() {
		return resultCurrency.getText();
	}


}
