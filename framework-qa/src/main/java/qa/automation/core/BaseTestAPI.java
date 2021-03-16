package qa.automation.core;

import org.hamcrest.Matchers;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import qa.automation.utils.ReadConfigProperties;

public class BaseTestAPI extends ReportExtentReport{
	
	@BeforeClass
	public static void configuracao(){
		
		iniciarReport(ReadConfigProperties.getProperties("report-path"),ReadConfigProperties.getProperties("report-name"));
		
		Long TIME_OUT = 5000L;
		
		RestAssured.baseURI = ReadConfigProperties.getProperties("uri-api");
		
		RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
		requestBuilder.setContentType(ContentType.JSON);
		RestAssured.requestSpecification = requestBuilder.build();
		
		ResponseSpecBuilder responseBuilder = new ResponseSpecBuilder();
		responseBuilder.expectResponseTime(Matchers.lessThan(TIME_OUT));
		RestAssured.responseSpecification = responseBuilder.build();
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	}
	
	@AfterClass
	public static void finaliza() {
		finalizarReport();
	}

}
