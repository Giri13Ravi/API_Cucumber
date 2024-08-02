package com.omrbranch.stepdefination;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.globaldata.GlobalDatas;
import com.omrbranch.pojo.login.Login_Output_POJO;

import co.omrbranch.baseclass.Base_Class_API;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

public class TC1_LoginStep extends Base_Class_API{
static GlobalDatas globalData = new GlobalDatas();

	@Given("User add Header")
	public void user_add_header(){
		addHeader("accept", "application/json");
	}
	@When("User add basic authentication for login")
	public void user_add_basic_authentication_for_login() throws FileNotFoundException, IOException {
		addBasicAuth(getPropertyFileValue("username"), getPropertyFileValue("password"));
	}
	@When("User send {string} request for login endpoint")
	public void user_send_request_for_login_endpoint(String type) {
	    res = addRequestType(type, Endpoints.LOGIN);
	    int statusCode = getResponseCode(res);
	    globalData.setStatusCode(statusCode);
	    
	}
	@Then("User should verify the login response body firstName present as {string} and get the logtoken saved.")
	public void user_should_verify_the_login_response_body_first_name_present_as_and_get_the_logtoken_saved(String exp_first_name) {
	    Login_Output_POJO lop = res.as(Login_Output_POJO.class);
	    String act_first_name = lop.getData().getFirst_name();
	    String logtoken = lop.getData().getLogtoken();
	    TC1_LoginStep.globalData.setLogToken(logtoken);
	    Assert.assertEquals("Verify FirstName of Login", exp_first_name,act_first_name);
	}




}
