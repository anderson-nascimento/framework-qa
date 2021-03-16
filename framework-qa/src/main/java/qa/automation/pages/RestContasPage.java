package qa.automation.pages;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;


public class RestContasPage {
	
	public Response inserirConta(String nomeConta, String token, String path) {
		
	Map<String,String> conta = new HashMap<>(); 
	conta.put("nome", nomeConta);
	
	Response results =
	given()
		.header("Authorization","JWT " + token)
		.body(conta)
	.when()
		.post(path)
	.then()
		.extract().response()
	;
	return results;
	}
	
	public Response alterarConta(String nomeConta, String token, String path) {
		
	Map<String,String> conta = new HashMap<>(); 
	conta.put("nome", nomeConta);
	
	Response results =
	given()
		.header("Authorization","JWT " + token)
		.body(conta)
	.when()
		.put(path)
	.then()
		.extract().response()
	;
	return results;
	}

}
