package com.omrbranch.stepdefination;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.pojo.address.DeleteAddress_Output_Pojo;
import com.omrbranch.pojo.product.Product_Search_Input_Pojo;
import com.omrbranch.pojo.product.Product_Search_Output_Pojo;

import co.omrbranch.baseclass.Base_Class_API;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC5_ProductSearchStep extends Base_Class_API{
	Response res;

	@Given("user add header for product search")
	public void user_add_header_for_product_search() {
		List<Header> list_Header = new ArrayList<>();
		Header h1 = new Header ("accept","application/json");
		Header h2 = new Header ("Content-Type","application/json");
		list_Header.add(h1);
		list_Header.add(h2);
		Headers head = new Headers(list_Header);
		addHeaders(head);
	}
	@When("user add requestbody for product search {string}")
	public void user_add_requestbody_for_product_search(String text) {
	    Product_Search_Input_Pojo psio = new Product_Search_Input_Pojo(text);
	    addRequestBody(psio);
	}
	@When("user send {string} request for product search endpoint")
	public void user_send_request_for_product_search_endpoint(String reqType) {
		res = addRequestType(reqType, Endpoints.SEARCHPROD);
		 int responseCode = getResponseCode(res);
		 TC1_LoginStep.globalData.setStatusCode(responseCode);
	}
	@Then("user should verify the product search response message matches {string}")
	public void user_should_verify_the_product_search_response_message_matches(String expmesg) {
		Product_Search_Output_Pojo dop = res.as(Product_Search_Output_Pojo.class);
		   String actMesg = dop.getMessage();
		   Assert.assertEquals("verify the Get User Address Msg", expmesg,actMesg);
	}




}





