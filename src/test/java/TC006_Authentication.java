import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_Authentication {
	
	@Test
	void authentication() {
		
        RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
        
        //Setting up the user authentication
        PreemptiveBasicAuthScheme authuser=new PreemptiveBasicAuthScheme();
        authuser.setUserName("ToolsQA");
        authuser.setPassword("TestPassword");
        
        //assigning the authentication to RestAssured
        RestAssured.authentication=authuser;
        
		RequestSpecification httprequest=RestAssured.given();
		
		Response response=httprequest.request(Method.GET, "/");
		
		String result=response.body().asString();
		
		System.out.println("Response body is: "+result);
		
	}

}
