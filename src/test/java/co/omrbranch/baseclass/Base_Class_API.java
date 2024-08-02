package co.omrbranch.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base_Class_API {

	RequestSpecification reqSpe;
	protected  Response res;
	public void addHeader(String headerName, String headerValue) {
		 reqSpe = RestAssured.given().header(headerName, headerValue);
	}
	
	public void addHeaders(Headers headers) {
		reqSpe = RestAssured.given().headers(headers);

	}
	
	public void addRequestBody(String body) {
		reqSpe.body(body);
	}
	
	public void addRequestBody(Object body) {
		reqSpe.body(body);
	}
	
	public String getProjectPath() {
		return System.getProperty("user.dir");
	}
	
	public String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream(getProjectPath()+"\\config\\config.properties"));
		String value = (String) prop.get(key);
		return value;
	}
	
	public void addFormData(String key , File pathFile) {
		reqSpe.multiPart(key,pathFile);
	}
	
	public Response addRequestType(String reqType, String endpoint) {
		switch(reqType) {
		case "GET":
			res = reqSpe.when().get(endpoint);
			break;
		case "POST":
			res = reqSpe.when().post(endpoint);
			break;
		case "PUT":
			res = reqSpe.when().put(endpoint);
			break;
		case "DELETE":
			res = reqSpe.when().delete(endpoint);
			break;
			default:
				break;
		}
		return res;
			
		}
	public int getResponseCode(Response res) {
		int statusCode = res.getStatusCode();
		return statusCode;
	}
	public String getResponseBodyAsString(Response res) {
		String body = res.getBody().asString();
		return body;
	}
	
	public String getResponseBodyAsPreetyString(Response res) {
		String body = res.getBody().asPrettyString();
		return body;

	}
	
	public void addBasicAuth(String userName, String password) {
		 reqSpe = reqSpe.auth().preemptive().basic(userName, password);

	}
	public void add_Body_String(String body) {
		reqSpe = reqSpe.body(body);
	}
	public void add_Body_Object(Object body) {
		reqSpe = reqSpe.body(body);
	}
}



