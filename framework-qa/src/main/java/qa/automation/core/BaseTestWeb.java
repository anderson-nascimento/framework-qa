package qa.automation.core;

import static qa.automation.core.DriverManager.getDriver;
import static qa.automation.core.DriverManager.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import qa.automation.pages.LoginPage;
import qa.automation.utils.ReadConfigProperties;

public class BaseTestWeb extends ReportExtentReport{
	
	@Rule
	public static TestName testName = new TestName();
	private static LoginPage page = new LoginPage();

	
	@BeforeClass
	public static void inicializa(){
		iniciarReport(ReadConfigProperties.getProperties("report-path"),ReadConfigProperties.getProperties("report-name"));
		page.acessarTelaInicial();	
		page.setEmail(ReadConfigProperties.getProperties("usurio"));
		page.setSenha(ReadConfigProperties.getProperties("senha"));
		page.entrar();
	}
	
	public static String addPrint() throws IOException{
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		File evidencia = new File("target" + File.separator + "screenshot" +
				File.separator + testName.getMethodName() + ".png");
		FileUtils.copyFile(arquivo, evidencia);
		
		return evidencia.getAbsolutePath();
	}
	
	@AfterClass
	public static void fecharBrowser() throws IOException{
				
		if(ReadConfigProperties.getProperties("fechar-browser").equals("SIM")) {
			killDriver();
		}
	}
	
	@AfterClass
	public static void finaliza() {
		finalizarReport();
	}
}
