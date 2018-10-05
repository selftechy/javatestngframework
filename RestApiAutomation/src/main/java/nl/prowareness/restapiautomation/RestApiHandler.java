package nl.prowareness.restapiautomation;

import static io.restassured.RestAssured.get;

import java.util.Map;

import io.restassured.response.Response;
import nl.prowareness.restapi.exceptions.InvalidMethodTypeException;


public class RestApiHandler {
	
	private String baseUrl;
	private Map<String,String> getParameters = null;
	private Response response;
	private MethodType methodType;
	
	
	public RestApiHandler(String baseUrl, MethodType methodType) {
		this.baseUrl = baseUrl;
		this.methodType = methodType;
	}

	
	public void setParametersForGetCall(Map<String,String> getParameters) {
		this.getParameters = getParameters;
	}
	
	
	public Response getResponse() {
		return response;
	}
	
	
	public void setMethodType(MethodType methodType) {
		this.methodType = methodType;
	}
	
	
	public Response executeMethod() throws InvalidMethodTypeException {
		Response resp = null;
		
		switch (this.methodType) {
		
		case GET:
			if(this.getParameters!=null) {
				resp = get(this.baseUrl,this.getParameters);
			   }
			else
				resp = get(this.baseUrl);
			
			break;

		case POST:
			resp = get(this.baseUrl);
			break;

		case PUT:
			resp = get(this.baseUrl);
			break;

		case DELETE:
			resp = get(this.baseUrl);
			break;

		case PATCH:
			resp = get(this.baseUrl);
			break;
			
		default:
			throw new InvalidMethodTypeException("Please provide valid Method type: "+this.methodType);
		}
		
		return resp;
		
	}
	

}
