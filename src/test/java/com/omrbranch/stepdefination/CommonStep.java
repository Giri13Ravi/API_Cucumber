package com.omrbranch.stepdefination;

import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CommonStep {
	
	@Then("User should verify the status code is {int}")
	public void user_should_verify_the_status_code_is(int exp_Status_Code) {
		int statusCode = TC1_LoginStep.globalData.getStatusCode();
	//	Assert.assertEquals("Verify the Status Code", exp_Status_Code, Status_Code);
		Assert.assertEquals("Verify the Status Code", exp_Status_Code, statusCode);
	}

}
