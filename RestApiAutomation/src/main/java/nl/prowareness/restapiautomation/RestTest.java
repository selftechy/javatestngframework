package nl.prowareness.restapiautomation;

import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.exception.JsonPathException;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class RestTest {

	@Test
	public void getRequestFindCapital() throws JsonPathException {
		
		//make get request to fetch capital of norway
		Response resp = get("http://restcountries.eu/rest/v1/name/norway");
		
		System.out.println(resp.getContentType());
		//Fetching response in JSON
		JSONArray jsonResponse = new JSONArray(resp.asString());
		
		//Fetching value of capital parameter
		String capital = jsonResponse.getJSONObject(0).getString("capital");
		String name = jsonResponse.getJSONObject(0).getString("name");
		
		//Asserting that capital of Norway is Oslo
		Assert.assertEquals(capital, "Oslo");
		Assert.assertEquals(name, "Norway");
	}

	//@Test
	public void getRequestThomasBayer() throws JsonPathException {
		
		//make get request to fetch capital of norway
		Response resp = get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/7/");
		System.out.println(resp.getContentType());
		System.out.println(resp.xmlPath().get("CUSTOMER.ID"));
		System.out.println(resp.asString());
		//Fetching response in JSON
		//JSONArray jsonResponse = new JSONArray(resp.asString());
		
		//Fetching value of capital parameter
/*		String capital = jsonResponse.getJSONObject(0).getString("capital");
		String name = jsonResponse.getJSONObject(0).getString("name");
*/		
	}
	
}