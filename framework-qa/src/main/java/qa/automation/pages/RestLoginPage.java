package qa.automation.pages;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;
import qa.automation.utils.ReadConfigProperties;

public class RestLoginPage {
	
	public Response restLogin() {
	
	Map<String,String> jsonLogin = new HashMap<>(); 
	jsonLogin.put("email", ReadConfigProperties.getProperties("usuario"));
	jsonLogin.put("senha", ReadConfigProperties.getProperties("senha"));
	
	Response token = 
		given()
			.body(jsonLogin)
		.when()
			.post("/signin")
		.then()
			.extract().response()
		;
		return token;
	}
}
