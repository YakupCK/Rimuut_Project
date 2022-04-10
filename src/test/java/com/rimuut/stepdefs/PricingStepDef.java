package com.rimuut.stepdefs;

import com.rimuut.pages.HomePage;
import com.rimuut.pages.PricingPage;
import com.rimuut.utils.PropertyReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

public class PricingStepDef {

	private HomePage homePage = new HomePage();
	private PricingPage pricingPage = new PricingPage();
	String invoiceAmount;
	String invoiceCurrency;
	String payoutCurrency;

	@Given("The user navigates to {string} page")
	public void the_user_navigates_to_page(String menu) {
		homePage.navigateToMenu(menu);
	}

	@When("the user clicks on currency dropdown in Invoice AMount")
	public void the_user_clicks_on_currency_dropdown_in_Invoice_AMount() {
		pricingPage.clickInvCurrDropd();
	}

	@Then("Currencies should be listed as shown below")
	public void currencies_should_be_listed_as_shown_below(List<String> expectedList) {
		pricingPage.verifyInvoiceAmountCurrencies(expectedList);
	}

	@When("the user clicks on currency dropdown in Pay Out Method")
	public void the_user_clicks_on_currency_dropdown_in_Pay_Out_Method() {
		pricingPage.clickPayOutCurrDropd();
	}

	//--------------

	@When("The user selects {string} from Invoice Amount")
	public void theUserSelectsFromInvoiceAmount(String currency) {
		invoiceCurrency = currency;
		pricingPage.selectInvoiceCurrency(currency);
	}

	@And("The user type {string}")
	public void theUserType(String amount) {
		invoiceAmount = amount;
		pricingPage.setInvoiceAmount(amount);
	}

	@When("The user selects {string} from Payout Method")
	public void the_user_selects_from_Payout_Method(String currency) {
		payoutCurrency = currency;
		pricingPage.selectPayOutCurrency(currency);
	}

	@Then("Applied rate is {string}")
	public void applied_rate_is(String rate) {
		pricingPage.getRate(rate);
	}

	@Then("the user gets {string} in {string}")
	public void the_user_gets_in(String expectedAmount, String expectedCurrency) {
		String jsonBody = "{\n" +
				"  \"type\": 1,\n" +
				"  \"invoice_total\": "+ invoiceAmount +",\n" +
				"  \"invoice_currency\": \""+invoiceCurrency+"\",\n" +
				"  \"payout_currency\": \""+payoutCurrency+"\",\n" +
				"  \"payout_method\": \"bank_account\",\n" +
				"  \"payout_total\": 951\n" +
				"}";

		Response response = RestAssured.given().accept(ContentType.JSON)
				.and().contentType(ContentType.JSON)
				.and().body(jsonBody)
				.post(PropertyReader.getProperty("calculatorURL"));

		String payout_format = response.path("payout_format");
		payout_format = payout_format.replace(",", "");
		payout_format = payout_format.replace(".", "");
		expectedAmount = expectedAmount.replace(",", "");
		expectedAmount = expectedAmount.replace(".", "");

		Assert.assertEquals(payout_format,expectedAmount);
		Assert.assertEquals(pricingPage.getResultCurrency(),expectedCurrency);


	}



}
