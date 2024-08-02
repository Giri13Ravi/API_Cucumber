package com.omrbranch.stepdefination;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.pojo.changeprofilepic.Change_Profile_Pic_Output_Pojo;

import co.omrbranch.baseclass.Base_Class_API;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class TC6_ChangeProfilePicStep extends Base_Class_API{

	@Given("user add header and bearer authorization for accessing ChangeProfilePic endpoints")
	public void user_add_header_and_bearer_authorization_for_accessing_change_profile_pic_endpoints() {
		List<Header> list_Header = new ArrayList<>();
		Header h1 = new Header ("accept","application/json");
		Header h2 = new Header("Authorization", "Bearer "+ TC1_LoginStep.globalData.getLogToken());
		Header h3 = new Header ("Content-Type","multipart/form-data");
		list_Header.add(h1);
		list_Header.add(h2);
		list_Header.add(h3);
		Headers head = new Headers(list_Header);
		addHeaders(head);
	}
	@When("user add formdata for ChangeProfilePic")
	public void user_add_formdata_for_change_profile_pic() {
		addFormData("profile_picture", new File(getProjectPath()+"\\img\\spiderman.png"));
	}
	@When("user send {string} request for ChangeProfilePic endpoint")
	public void user_send_request_for_change_profile_pic_endpoint(String reqType) {
		res = addRequestType(reqType, Endpoints.CHANGEPROPIC);
		  int rescode = getResponseCode(res);
		  TC1_LoginStep.globalData.setStatusCode(rescode);
	}
	@Then("user should verify the ChangeProfilePic response message matches {string}")
	public void user_should_verify_the_change_profile_pic_response_message_matches(String expMsg) {
	    Change_Profile_Pic_Output_Pojo pop = res.as(Change_Profile_Pic_Output_Pojo.class);
	    String actMesg = pop.getMessage();
	    Assert.assertEquals("Verify Change Pro Pic Mesg", expMsg, actMesg);
	}




}
