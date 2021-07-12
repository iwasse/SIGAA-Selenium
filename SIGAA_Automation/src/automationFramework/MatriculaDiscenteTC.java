package automationFramework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Helper.BrowserFactory;
import Utility.Discente;
import Utility.ExcelDataConfig;
import pageGrad.AdministracaoPage;
import pageGrad.HeaderPage;
import pageGrad.LoginPageFactory;
import pageGrad.MenuPrincipalPage;
import pageGrad.portalDiscente.PortalDiscentePage;
import pageGrad.portalDiscente.ensino.ConfirmacaoTurmasPage;
import pageGrad.portalDiscente.ensino.TurmasAbertasMatrizPage;
import pageGrad.portalDiscente.ensino.TurmasSelecPage;

public class MatriculaDiscenteTC {

	private WebDriver driver;
	
	@BeforeClass
	public void setUp(){
		//Ambiente de testes
		driver = BrowserFactory.startBroswer("firefox", "http://200.137.217.51:8081/sigaa/logar.do?dispatch=logOn");
	}
	
	@Test(dataProvider="dadosDiscente")
	//Matrícular x alunos
	public void ctMatricula01(){
		
		LoginPageFactory loginPageNew = new LoginPageFactory(driver);
		MenuPrincipalPage menuPrincipal = PageFactory.initElements(driver, MenuPrincipalPage.class);
		HeaderPage headerPage = new HeaderPage(driver);
		PortalDiscentePage portalDiscentePage = new PortalDiscentePage(driver);
		TurmasAbertasMatrizPage matriculaTurmaRegular = new TurmasAbertasMatrizPage(driver);
		TurmasSelecPage turmasSelecPage = new TurmasSelecPage(driver);
		ConfirmacaoTurmasPage confirmacaoTurmasPage = new ConfirmacaoTurmasPage(driver);
		AdministracaoPage administracaoPage = new AdministracaoPage(driver);

		Discente discente1 = new Discente();
		Discente discente2 = new Discente();
		Discente discente3 = new Discente();
		Discente discente4 = new Discente();
		LinkedList<String> turmas = new LinkedList<>();
		int i;
		
		turmas.add("862290");

		discente1.setCpf("2152441176");
		discente1.setDtnasc("18/09/1989");
		discente1.setMatricula("200800751");
		
		discente2.setCpf("508099110");
		discente2.setDtnasc("01/12/1983");
		discente2.setMatricula("200901489");
		
		discente3.setCpf("3326364105");
		discente3.setDtnasc("12/11/1990");
		discente3.setMatricula("200901593");
		
		discente4.setCpf("2012102158");
		discente4.setDtnasc("09/07/1990");
		discente4.setMatricula("200902480");
		
		//lista para inserir vários objetos do tipo Discente
		List<Discente> lista = new ArrayList<Discente>();
		lista.add(discente1);
		lista.add(discente2);
		lista.add(discente3);
		lista.add(discente4);
		
		System.out.println(lista.size());
		
		loginPageNew.logar("guilhermeiwasse", "guilhermeiwasse");
		headerPage.clickAreaAdm();
		

		//loop utilizado para matricular mais de um discente.
		for(i = 0; i < lista.size(); i++){
			
		Discente dc = (Discente) lista.get(i);
		System.out.println("Matrícula: " + dc.getMatricula());
		administracaoPage.logarComo(dc.getMatricula());
		menuPrincipal.portalDisc();
		portalDiscentePage.clickRealizarMat();
		matriculaTurmaRegular.initMatricula();
		matriculaTurmaRegular.selectTurmas(turmas);
		matriculaTurmaRegular.addTurmas();
		turmasSelecPage.confirmarSoli();
		confirmacaoTurmasPage.validateInsert(dc.getCpf(), dc.getDtnasc(), "secret");
		System.out.println("CPF: " + dc.getCpf());
		System.out.println("Data Nascimento: " + dc.getDtnasc());
		headerPage.clickDeslog();
		}
		
		driver.quit();
		
	}
	
	@DataProvider(name="dadosDiscente")
	public Object[][] passData(){
		
		ExcelDataConfig config = new ExcelDataConfig("/home/iwasse/workspace/SIGAA_Automation/TestData/Inputdata.xlsx");
		//Discente discente = new Discente();
		
		//conta o número de linhas e colunas do arquivo
		int rows = config.getRowCount(0);
		int columns = config.getColumnCount(0);
		
		System.out.println("Número de coluns: " + columns);
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
