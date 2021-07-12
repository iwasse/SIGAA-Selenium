package automationFramework;

import java.util.LinkedList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Helper.BrowserFactory;
import Utility.ExcelDataConfig;
import pageGrad.AdministracaoPage;
import pageGrad.HeaderPage;
import pageGrad.LoginPageFactory;
import pageGrad.MenuPrincipalPage;
import pageGrad.portalDiscente.PortalDiscentePage;
import pageGrad.portalDiscente.ensino.AtualizarDadosMatricula;
import pageGrad.portalDiscente.ensino.ConfirmacaoTurmasPage;
import pageGrad.portalDiscente.ensino.TurmasAbertasMatrizPage;
import pageGrad.portalDiscente.ensino.TurmasSelecPage;

public class MatricularTC {

	private WebDriver driver;
	
	@BeforeClass
	public void setUp(){
		//Ambiente de testes
		driver = BrowserFactory.startBroswer("firefox", "http://200.137.217.51:8081/sigaa/logar.do?dispatch=logOn");
	}
	
	
	@Test(dataProvider="dadosDiscente")
	public void testcaseOne(String cpf, String datanasc, String matricula){
		
		LoginPageFactory loginPageNew = new LoginPageFactory(driver);
		MenuPrincipalPage menuPrincipal = PageFactory.initElements(driver, MenuPrincipalPage.class);
		HeaderPage headerPage = new HeaderPage(driver);
		PortalDiscentePage portalDiscentePage = new PortalDiscentePage(driver);
		TurmasAbertasMatrizPage matriculaTurmaRegular = new TurmasAbertasMatrizPage(driver);
		TurmasSelecPage turmasSelecPage = new TurmasSelecPage(driver);
		ConfirmacaoTurmasPage confirmacaoTurmasPage = new ConfirmacaoTurmasPage(driver);
		AdministracaoPage administracaoPage = new AdministracaoPage(driver);
		AtualizarDadosMatricula dados = new AtualizarDadosMatricula(driver);
		
		
		LinkedList<String> turmas = new LinkedList<>();
		turmas.add("862290");
		
		loginPageNew.logar("guilhermeiwasse", "guilhermeiwasse");
		headerPage.clickAreaAdm();
		administracaoPage.logarComo(matricula);
		menuPrincipal.portalDisc();
		portalDiscentePage.clickRealizarMat();
		if(dados.checkPage()){
			dados.validateInsert(cpf, datanasc, "12345");
		}
		matriculaTurmaRegular.initMatricula();
		matriculaTurmaRegular.selectTurmas(turmas);
		matriculaTurmaRegular.addTurmas();
		turmasSelecPage.confirmarSoli();
		confirmacaoTurmasPage.validateInsert(cpf, datanasc, "secret");
		//headerPage.clickDeslog();
	}
	
	//Args: cpf, data de nascimento e número de matrícula
	@DataProvider(name="dadosDiscente")
	public Object[][] passData(){
		
		ExcelDataConfig config = new ExcelDataConfig("TestData/dadosDiscente.xlsx");
		
		//conta o número de linhas e colunas do arquivo
		int rows = config.getRowCount(0);
		int columns = config.getColumnCount(0);
		
		System.out.println("Número de colunas: " + columns);
		System.out.println("Numero de linhas: " + rows);
		
		Object[][] data = new Object[rows][columns];
		
		//loop para buscar os dados de todas as linhas e colunas
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){	
				
			data[i][j] = config.getData(0, i, j);
			
			}
		}
	
		return data;
		
	}
}
