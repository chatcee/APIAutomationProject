import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredAPI {

	@Test(priority =1)
	public void get_request() {
		
		 String URL = "http://dummy.restapiexample.com/";
		Response response = RestAssured.get(URL);
		
		//check status code
		Assert.assertEquals(response.getStatusCode(),200);
		 
		
		
		
		
	}
	@Test(priority=2)
	
	public void  get_request_specificUserID() {
		
		String URL = "http://dummy.restapiexample.com/api/v1/employee/1";
		Response response = RestAssured .get(URL);
		
		Assert.assertEquals(response.getStatusCode(),200);
		
		String responseBody =  response.getBody().asString();
		System.out.println(responseBody);  
		
	
}
	@Test(priority =3)
	public  void delete_request_toCheckStatusCode() {
		 String URL = "	http://dummy.restapiexample.com/api/v1/delete/2";
			Response response = RestAssured.delete(URL);
			
			//check status code
			Assert.assertEquals(response.getStatusCode(),204);
			String jsonString =  response.asString();
			
			//check delete message
			Assert.assertEquals(jsonString.contains("message: successfully! deleted Records"), true);
	}
			 
	
}