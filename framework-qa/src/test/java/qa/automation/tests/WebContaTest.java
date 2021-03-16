package qa.automation.tests;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import qa.automation.core.BaseTestWeb;
import qa.automation.pages.ContasPage;
import qa.automation.pages.MenuPage;
import qa.automation.utils.ReadConfigProperties;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WebContaTest extends BaseTestWeb {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@BeforeClass
	public static void cenarioTeste() {
		adicionarSuiteTeste("ContaTest","Suite Conta");
	}
	
	@Rule
	public TestName testName = new TestName();
	
	@Test
	public void test1_InserirConta() throws IOException{
		adicionarTeste(testName.getMethodName(),"Inserir conta");
		try{	
		menuPage.acessarTelaInserirConta();	
		contasPage.setNome("Aluguel Dona Florinda");
		contasPage.salvar();
		
		adicionarLog("INFO","Step Salvar Conta");

		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
		adicionarLog("PASS","Teste finalizado com sucesso","evidencia");
			
		}catch(Exception e) {
			adicionarLog("FAIL","Teste finalizado com erro","evidencia");
			Assert.fail();
		}	
	}
	
	@Test
	public void test2_AlterarConta() throws IOException{
		adicionarTeste(testName.getMethodName(),"Alterar conta");
		try{
		menuPage.acessarTelaListarConta();		
		contasPage.clicarAlterarConta("Aluguel Dona Florinda");
		contasPage.setNome(ReadConfigProperties.getProperties("conta-alterada"));
		contasPage.salvar();
		
		adicionarLog("INFO","Step Salvar Conta");

		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
		adicionarLog("PASS","Teste finalizado com sucesso","evidencia");
			
		}catch(Exception e) {
			adicionarLog("FAIL","Teste finalizado com erro","evidencia");
			Assert.fail();
		}
	}
	
	@Test
	public void test3_InserirContaMesmoNome() throws IOException{
		adicionarTeste(testName.getMethodName(),"Inserir Conta Duplicada");
		try{
		menuPage.acessarTelaInserirConta();		
		contasPage.setNome(ReadConfigProperties.getProperties("conta-alterada"));
		contasPage.salvar();
		
		adicionarLog("INFO","Step Salvar Conta");

		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
		adicionarLog("PASS","Teste finalizado com sucesso","evidencia");
			
		}catch(Exception e) {
			adicionarLog("FAIL","Teste finalizado com erro","evidencia");
			Assert.fail();
		}
	}
	@Test
	public void test4_ExcluirConta() throws IOException{
		adicionarTeste(testName.getMethodName(),"Excluir Conta");
		try{
		menuPage.acessarTelaListarConta();	
		contasPage.clicarExcluirConta(ReadConfigProperties.getProperties("conta-alterada"));
		
		adicionarLog("INFO","Step Salvar Conta");
			
		Assert.assertEquals("Conta removida com sucesso!", contasPage.obterMensagemSucesso());
		adicionarLog("PASS","Teste finalizado com sucesso","evidencia");
			
		}catch(Exception e) {
			adicionarLog("FAIL","Teste finalizado com erro","evidencia");
			Assert.fail();
		}
	}
}
