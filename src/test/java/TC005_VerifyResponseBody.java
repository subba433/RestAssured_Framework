import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_VerifyResponseBody {
	
	@Test
	void verifyResponseBody() {
		
        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/";
		
		RequestSpecification httprequest=RestAssured.given();
		
		Response response=httprequest.request(Method.GET, "/Hyderabad");
		
		String result=response.getBody().asString();
		
		//JsonPath will store all the response nodes, we can verify the required nodes
		JsonPath jsonpath=response.jsonPath();
		
		System.out.println("City is:  "+jsonpath.get("City"));
		System.out.println("Temperature is:  "+jsonpath.get("Temperature"));
		System.out.println("Humidity is:  "+jsonpath.get("Humidity"));
		System.out.println("WindSpeed is:  "+jsonpath.get("WindSpeed"));
		System.out.println("WindDirectionDegree is:  "+jsonpath.get("WindDirectionDegree"));
		
		
		
	}

}
