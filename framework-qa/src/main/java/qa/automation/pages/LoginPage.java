package qa.automation.pages;

import qa.automation.core.BasePage;
import qa.automation.core.DriverManager;
import qa.automation.utils.ReadConfigProperties;

public class LoginPage extends BasePage {
	
	public void acessarTelaInicial(){
		DriverManager.getDriver().get(ReadConfigProperties.getProperties("url-web"));
	}
	
	public void setEmail(String email) {
		escrever("email", email);
	}
	
	public void setSenha(String senha) {
		escrever("senha", senha);
	}
	
	public void entrar(){
		clicarBotaoPorTexto("Entrar");
	}
	
	public void logar(String email, String senha) {
		setEmail(email);
		setSenha(senha);
		entrar();
	}

}
