package qa.automation.pages;

import qa.automation.core.BasePage;

public class MenuPage extends BasePage {
	
	public void acessarTelaInserirConta(){
		clicarLink("Contas");
		clicarLink("Adicionar");
	}
	
	public void acessarTelaListarConta(){
		clicarLink("Contas");
		clicarLink("Listar");
	}
	
	public void acessarTelaPrincipal(){
		clicarLink("Home");
	}

}
