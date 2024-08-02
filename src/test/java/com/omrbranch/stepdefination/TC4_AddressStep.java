package com.omrbranch.stepdefination;

import java.util.ArrayList;
import java.util.List;

import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.pojo.address.Address_Input_Pojo;
import com.omrbranch.pojo.address.Address_Output_Pojo;
import com.omrbranch.pojo.address.DeleteAddress_Output_Pojo;
import com.omrbranch.pojo.address.Deleteaddress_Input_Pojo;
import com.omrbranch.pojo.address.GetUserAddress_Output_Pojo;
import com.omrbranch.pojo.address.Updateaddress_Input_Pojo;
import com.omrbranch.pojo.address.Updateaddress_Output_Pojo;

import co.omrbranch.baseclass.Base_Class_API;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import org.junit.Assert;

public class TC4_AddressStep extends Base_Class_API{
	Response res;


	@Given("User add header and bearer authorization for accessing adddress endpoints")
	public void user_add_header_and_bearer_authorization_for_accessing_adddress_endpoints() {
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept","application/json");
		Header h2 = new Header("Authorization", "Bearer "+ TC1_LoginStep.globalData.getLogToken());
		Header h3 = new Header("Content-Type","application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers = new Headers(listHeader);
		addHeaders (headers);
	}
	@When("User add requestbody for add new address {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void user_add_requestbody_for_add_new_address(String firstName, String lastName, String mobile, String apartment, String state, String city, String country, String zipcode, String address, String address_type) {
	   Address_Input_Pojo aip = new Address_Input_Pojo(firstName,lastName,mobile,apartment,TC1_LoginStep.globalData.getStateIdNum(),TC1_LoginStep.globalData.getCityIdNum(),Integer.parseInt(country),zipcode,address,address_type);
	   addRequestBody(aip);
	}
	@When("User send {string} request for Add UserAddress endpoint")
	public void user_send_request_for_add_user_address_endpoint(String reqType) {
	 res = addRequestType(reqType, Endpoints.ADDUSERADDRESS);
	  int rescode = getResponseCode(res);
	  TC1_LoginStep.globalData.setStatusCode(rescode);
	}

	@Then("User should verify add useraddress response message matches {string}")
	public void user_should_verify_add_useraddress_response_message_matches(String expAddMsg) {
	   Address_Output_Pojo aop = res.as(Address_Output_Pojo.class);
	   String actAddMesg = aop.getMessage();
	   Assert.assertEquals("Verify the Addd Address Success Mesg", expAddMsg,actAddMesg);
	   int address_id = aop.getAddress_id();
	   String addId = String.valueOf(address_id);
	   TC1_LoginStep.globalData.setAddressIdText(addId);
	   System.out.println(addId);   
	}

// updateuseraddress

	@Given("User add headers and bearer authorization for accesing adddress endpoints")
	public void user_add_headers_and_bearer_authorization_for_accesing_adddress_endpoints() {
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept","application/json");
		Header h2 = new Header("Authorization", "Bearer "+ TC1_LoginStep.globalData.getLogToken());
		Header h3 = new Header("Content-Type","application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers = new Headers(listHeader);
		addHeaders (headers);
	}
	@When("User add request body to UpdateNewAddress {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void user_add_request_body_to_update_new_address(String add_id, String firstName, String lastName, String mobile, String apartment, String state, String city, String country, String zipcode, String address, String address_type) {
		Updateaddress_Input_Pojo aip = new Updateaddress_Input_Pojo(TC1_LoginStep.globalData.getAddressIdText(),firstName,lastName,mobile,apartment,TC1_LoginStep.globalData.getStateIdNum(),TC1_LoginStep.globalData.getCityIdNum(),Integer.parseInt(country),zipcode,address,address_type);
		   addRequestBody(aip);
	}
	@When("User send {string} request for update UserAddress endpoint")
	public void user_send_request_for_update_user_address_endpoint(String reqType) {
		res = addRequestType(reqType, Endpoints.UPDATEUSERADDRESS);
		int responseCode = getResponseCode(res);
		TC1_LoginStep.globalData.setStatusCode(responseCode);
	    
	}
	@Then("User should verify update useraddress response message matches {string}")
	public void user_should_verify_update_useraddress_response_message_matches(String expUpdAddMesg) {
		Updateaddress_Output_Pojo uop = res.as(Updateaddress_Output_Pojo.class);
		String actUpdAddMesg = uop.getMessage();
		Assert.assertEquals("Verify Update Add Mesg", expUpdAddMesg, actUpdAddMesg);
	}

// Get User Address

	@Given("User add headers and bearer authorization for accesing getuseradddress endpoints")
	public void user_add_headers_and_bearer_authorization_for_accesing_getuseradddress_endpoints() {
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept","application/json");
		Header h2 = new Header("Authorization", "Bearer "+ TC1_LoginStep.globalData.getLogToken());
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers = new Headers(listHeader);
		addHeaders (headers);
	}
	@When("User send {string} request for GetUserAddress endpoint")
	public void user_send_request_for_get_user_address_endpoint(String reqType) {
	 res = addRequestType(reqType, Endpoints.GETUSERADDRESS);
	 int responseCode = getResponseCode(res);
	 TC1_LoginStep.globalData.setStatusCode(responseCode);
	}
	
	@Then("User should verify getuseraddress response message matches {string}")
	public void user_should_verify_getuseraddress_response_message_matches(String expMesg) {
	   GetUserAddress_Output_Pojo gop = res.as(GetUserAddress_Output_Pojo.class);
	   String actMesg = gop.getMessage();
	   Assert.assertEquals("verify the Get User Address Msg", expMesg,actMesg);
	}

// Delete User Address

	@Given("User add headers and bearer authorization for accesing deleteuseradddress endpoints")
	public void user_add_headers_and_bearer_authorization_for_accesing_deleteuseradddress_endpoints() {
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept","application/json");
		Header h2 = new Header("Authorization", "Bearer "+ TC1_LoginStep.globalData.getLogToken());
		Header h3 = new Header("Content-Type","application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers = new Headers(listHeader);
		addHeaders (headers);
	}
	@When("User add request body for address ID")
	public void user_add_request_body_for_address_id() {
	    Deleteaddress_Input_Pojo dio = new Deleteaddress_Input_Pojo(TC1_LoginStep.globalData.getAddressIdText());
	    addRequestBody(dio);
	}
	@When("User send {string} request for DeleteAddress endpoint")
	public void user_send_request_for_delete_address_endpoint(String reqType) {
		res = addRequestType(reqType, Endpoints.DELETEUSERADDRESS);
	    int responseCode = getResponseCode(res);
	    TC1_LoginStep.globalData.setStatusCode(responseCode);
	
	}
	@Then("User should verify DeleteAddress response message matches {string}")
	public void user_should_verify_delete_address_response_message_matches(String expMesg) {
		DeleteAddress_Output_Pojo dop = res.as(DeleteAddress_Output_Pojo.class);
		   String actMesg = dop.getMessage();
		   Assert.assertEquals("verify the Get User Address Msg", expMesg,actMesg);
	}





	



}
