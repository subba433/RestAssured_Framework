import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC004_GET_allHeaders {
	
	@Test
	void allheaders() {
		

		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/";
		
		RequestSpecification httprequest=RestAssured.given();
		
		Response response=httprequest.request(Method.GET, "/Hyderabad");
		
		String result=response.getBody().asString();
		
		System.out.println(result);
		int status=response.getStatusCode();
		System.out.println("Status code is:  "+status);
		
		Assert.assertEquals(status, 200);
		
		String Statusline=response.getStatusLine();
		System.out.println("Status line is:  "+Statusline);
		
		Headers headers=response.headers();
		
		for (Header header:headers) {
			System.out.println(header.getName() +" ::::  "+header.getValue());
		}
		
	}

}
