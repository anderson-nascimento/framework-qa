package qa.automation.tests;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import io.restassured.response.Response;
import qa.automation.core.BaseTestAPI;
import qa.automation.pages.RestContasPage;
import qa.automation.pages.RestLoginPage;
import qa.automation.utils.ReadConfigProperties;

public class RestContaTest extends BaseTestAPI{
	
	static RestLoginPage login = new RestLoginPage();
	RestContasPage contas = new RestContasPage();
	static String token;
	String idConta = "";
	
	@Rule
	public TestName testName = new TestName();
	
	@BeforeClass
	public static void login() throws IOException {
		adicionarSuiteTeste("Rest Conta Test","Suite Conta");
		adicionarTeste("Login","Realizar Login Rest");
		try {
			Assert.assertEquals("200", login.restLogin().statusCode());
			token = login.restLogin().jsonPath().getString("token");
		}catch(Exception e) {		
			adicionarLog("FAIL","Erro no Login");
			Assert.fail();
		}
	}
	
	@Test
	public void inserirConta() throws IOException {
		adicionarTeste(testName.getMethodName(),"Inserir conta");
		try{	
		Response response = contas.inserirConta("Aluguel Bruxa", token, 
							ReadConfigProperties.getProperties("path-inserir"));
		String statusCode = String.valueOf(response.getStatusCode());
		Assert.assertEquals("201", statusCode);
		adicionarLog("PASS","Teste finalizado com sucesso");
		
		}catch(Exception e) {
			adicionarLog("FAIL","Teste finalizado com erro");
			Assert.fail();
		}	
	}
	
	@Test
	public void alterarConta() throws IOException {
		adicionarTeste(testName.getMethodName(),"Alterar conta");
		try{
		Response response = contas.alterarConta(ReadConfigProperties.getProperties("conta-alterada"),
							token, 
							ReadConfigProperties.getProperties("path-alterar")+idConta);
		String statusCode = String.valueOf(response.getStatusCode());
		Assert.assertEquals("200", statusCode);
		adicionarLog("PASS","Teste finalizado com sucesso");
		
		}catch(Exception e) {
			adicionarLog("FAIL","Teste finalizado com erro");
			Assert.fail();
		}
	}

}
