package com.omrbranch.stepdefination;

import java.util.ArrayList;
import java.util.List;

import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.pojo.address.CityList_Input_Pojo;
import com.omrbranch.pojo.address.CityList_Output_Pojo;
import com.omrbranch.pojo.address.City_Data;

import co.omrbranch.baseclass.Base_Class_API;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.Assert;

public class TC3_CityListStep extends Base_Class_API{
	Response res;
	@Given("user add header for citylist name")
	public void user_add_header_for_citylist_name() {
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept","application/json");
		Header h2 = new Header("Content-Type","application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);
	    
	}
	@When("user add request body stateid for get citylist")
	public void user_add_request_body_stateid_for_get_citylist() {
		CityList_Input_Pojo cip = new CityList_Input_Pojo(TC1_LoginStep.globalData.getStateIdText());
		add_Body_Object(cip);   
	}
	@When("user send {string} request for citylist endpoint")
	public void user_send_request_for_citylist_endpoint(String type) {
		res = addRequestType(type, Endpoints.CITYLIST);
		int stateCode = getResponseCode(res);
		TC1_LoginStep.globalData.setStatusCode(stateCode);
		System.out.println(stateCode);
	}
	
	@Then("user should verify the city list response message matches {string} and saved cityid")
	public void user_should_verify_the_city_list_response_message_matches_and_saved_cityid(String expCityName) {
		CityList_Output_Pojo cop = res.as(CityList_Output_Pojo.class);
		ArrayList<City_Data>cl=cop.getData();
		for (City_Data eachCityData : cl) {
			String name = eachCityData.getName();
			if (name.equals(expCityName)) {
				int cityIdNum = eachCityData.getId();
				System.out.println(cityIdNum);
				Assert.assertEquals("Verify City Name", expCityName, name);
				break;
			}
		}
	 
	}

}
