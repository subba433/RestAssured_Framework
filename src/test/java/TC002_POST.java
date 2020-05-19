import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC002_POST {
	
	@Test
	void registration() {
		
	   //Specify base URI
       RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
	   //Create Request Object
       RequestSpecification httprequest=RestAssured.given();
		
       //Create pay load for POST 
		JSONObject jsonparam=new JSONObject();
		jsonparam.put("FirstName", "backspace1");
		jsonparam.put("LastName", "spaceback1");
		jsonparam.put("UserName", "ackspace123");
		jsonparam.put("Password", "paceback12");
		jsonparam.put("Email", "back1@space.com");
		
		httprequest.header("Content-Type", "application/json");
		
		httprequest.body(jsonparam.toJSONString());
		
		//Create Response object
		Response response=httprequest.request(Method.POST, "/register");
		
		//Print response body
		String result=response.body().asString();	
		System.out.println(result);
		
		int status=response.getStatusCode();
		System.out.println("Status code is:  "+status);
		
		//Assert.assertEquals(status, 201);
		
		String successcode=response.jsonPath().get("SuccessCode");
		
		System.out.println("Success Code is:  "+successcode);
		
		
	}
	

}
