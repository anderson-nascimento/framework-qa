package qa.automation.tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import qa.automation.core.BaseTest;
import qa.automation.pages.ContasPage;
import qa.automation.pages.MenuPage;
import qa.automation.utils.ReadConfigProperties;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();

	
	@Test
	public void test1_InserirConta(){
		menuPage.acessarTelaInserirConta();	
		contasPage.setNome("Aluguel Dona Florinda");
		contasPage.salvar();
		
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
	@Test
	public void test2_AlterarConta(){
		menuPage.acessarTelaListarConta();		
		contasPage.clicarAlterarConta("Aluguel Dona Florinda");
		contasPage.setNome(ReadConfigProperties.getProperties("conta-alterada"));
		contasPage.salvar();
		
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
	@Test
	public void test3_InserirContaMesmoNome(){
		menuPage.acessarTelaInserirConta();		
		contasPage.setNome(ReadConfigProperties.getProperties("conta-alterada"));
		contasPage.salvar();
		
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
	}
	@Test
	public void test4_ExcluirConta(){
		menuPage.acessarTelaListarConta();	
		contasPage.clicarExcluirConta(ReadConfigProperties.getProperties("conta-alterada"));
		
		Assert.assertEquals("Conta removida com sucesso!", contasPage.obterMensagemSucesso());
	}
}
