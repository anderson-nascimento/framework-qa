package qa.automation.core;

import static qa.automation.core.BaseTestWeb.addPrint;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportExtentReport {
	
	public static ExtentReports extent;
	public static ExtentTest suiteTeste;
	public static ExtentTest teste;
	public static ExtentSparkReporter htmlReporter;
	public static Boolean reportInicializado = false;
	
	public static void iniciarReport(String diretorioReport, String nomeReport) {
		if(!reportInicializado) {
			extent = new ExtentReports();
			File diretorioEvidencia = new File (diretorioReport);
			if(!diretorioEvidencia.exists()) {
				diretorioEvidencia.mkdirs();
			}
			
			htmlReporter = new ExtentSparkReporter(diretorioReport + nomeReport + ".html");
			htmlReporter.config().setEncoding("ISO-8859-1");
			htmlReporter.config().setDocumentTitle("Report de execucao");
			htmlReporter.config().setReportName("Report de execucao");
			extent.attachReporter(htmlReporter);
			reportInicializado = true;
		}		
	}
	
	public static void adicionarSuiteTeste(String nomeClasseTeste, String descricaoTeste) {
		suiteTeste = extent.createTest(nomeClasseTeste, descricaoTeste);
	}
	
	public static void adicionarTeste(String nomeNomeTeste, String descricaoTeste) {
		teste = suiteTeste.createNode(nomeNomeTeste, descricaoTeste);
	}
	
	public static void adicionarLog(String status, String detalhe, String print) throws IOException {
		
		Status result = Status.valueOf(status);
	
		switch(result) {
			case FAIL:
				teste.fail(detalhe).addScreenCaptureFromPath(addPrint());
				break;
			case INFO:
				teste.info(detalhe);
				break;
			case PASS:
				teste.pass(detalhe).addScreenCaptureFromPath(addPrint());
				break;
		}
	}
	
	public static void adicionarLog(String status, String detalhe) throws IOException {
		
		Status result = Status.valueOf(status);
	
		switch(result) {
			case FAIL:
				teste.fail(detalhe);
				break;
			case INFO:
				teste.info(detalhe);
				break;
			case PASS:
				teste.pass(detalhe);
				break;
		}
	}

	private enum Status {
	    FAIL, INFO, PASS;
	}
	
	public static void finalizarReport() {
		extent.flush();
	}

}
