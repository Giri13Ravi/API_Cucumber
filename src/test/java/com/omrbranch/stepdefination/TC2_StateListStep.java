package com.omrbranch.stepdefination;

import java.util.ArrayList;

import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.pojo.address.StateList_Output_Pojo;
import com.omrbranch.pojo.address.State_Data;

import co.omrbranch.baseclass.Base_Class_API;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

public class TC2_StateListStep extends Base_Class_API {
	Response res;
	@Given("user add headers for statelist")
	public void user_add_headers_for_statelist() {
		addHeader("accept", "application/json");
	    
	}
	@When("user send {string} request for statelist endpoint")
	public void user_send_request_for_statelist_endpoint(String type) {
		res = addRequestType(type, Endpoints.STATELIST);
		int responseCo = getResponseCode(res);
		System.out.println(responseCo);
		TC1_LoginStep.globalData.setStatusCode(responseCo);
	}
	@Then("user should verify the statelist response message matches {string} and saved stateid")
	public void user_should_verify_the_statelist_response_message_matches_and_saved_stateid(String expStateNum) {
		StateList_Output_Pojo sop = res.as(StateList_Output_Pojo.class);
		// Find the steate ID of TN
		ArrayList<State_Data>stateList = sop.getData();
		// Iterate all List
		for (State_Data eachstateList : stateList) {
			// Get the State Name
			String eachstateName =  eachstateList.getName();
			
			if (eachstateName.equals(expStateNum)) {
				int stateIdNum = eachstateList.getId();
				System.out.println(stateIdNum);
			// conv into String
			String stateId = String.valueOf(stateIdNum);
			TC1_LoginStep.globalData.setStateIdText(stateId);
			Assert.assertEquals("Verify State Name", expStateNum,eachstateName);
			break;
		}
		
	}




	}}
