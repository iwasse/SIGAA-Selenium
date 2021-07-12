package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Helper.BrowserFactory;
import pageGrad.LoginPageFactory;
import pageGrad.MenuGradCATG;
import pageGrad.MenuPrincipalPage;
import pageGrad.CATG.Matriz.AdicionarComponentesMatriz;
import pageGrad.CATG.Matriz.ComponentesMatriz;
import pageGrad.CATG.Matriz.DadosGeraisMatriz;
import pageGrad.CATG.Matriz.DadosMatrizConfirmacao;
import pageGrad.CATG.Matriz.ListarAlterarMatriz;


public class ListarAlterarMatriz_TC {

	// Descrição dos Casos de Teste : http://goo.gl/0c8Xki

	private WebDriver driver;
	LoginPageFactory login;
	MenuPrincipalPage menuPrincipal;
	MenuGradCATG menuCATG;
	ListarAlterarMatriz alteraMatriz;
	DadosGeraisMatriz dadosGeraisMatriz;
	AdicionarComponentesMatriz addCompMatriz;
	ComponentesMatriz componentesMatriz;
	DadosMatrizConfirmacao confirmaEdicao;

	
		
	@BeforeTest
	public void setUp() {

		driver = BrowserFactory.startBroswer("firefox", "http://200.137.217.51:8081/sigaa/logar.do?dispatch=logOn");
		login = new LoginPageFactory(driver);
		menuPrincipal = PageFactory.initElements(driver, MenuPrincipalPage.class);
		menuCATG = PageFactory.initElements(driver, MenuGradCATG.class);
		alteraMatriz = PageFactory.initElements(driver, ListarAlterarMatriz.class);
		dadosGeraisMatriz = PageFactory.initElements(driver, DadosGeraisMatriz.class);
		addCompMatriz = PageFactory.initElements(driver, AdicionarComponentesMatriz.class);
		componentesMatriz = PageFactory.initElements(driver, ComponentesMatriz.class);
		confirmaEdicao = PageFactory.initElements(driver, DadosMatrizConfirmacao.class);
		login.logar("admin", "secret");
		menuPrincipal.modGrad();
		menuCATG.clicCATGmenu();
	}

	// @AfterMethod
	public void cancelarOperação() throws InterruptedException {
		menuCATG.clickListAlteraMatriz();
	}

	
	@Test(description = "CT 01 - Alterar matriz sem alterar dados",priority = 1)
	public void alterarMatriz() throws InterruptedException {
		menuCATG.clickListAlteraMatriz();
		alteraMatriz.informaCodMatriz("FIS-LN-1");
		alteraMatriz.clickBuscar();
		alteraMatriz.clickbtnEditar();
		dadosGeraisMatriz.clickBtnProxPasso();
		addCompMatriz.clickBtnProxPasso();
		componentesMatriz.clickBtnProxPasso();
		confirmaEdicao.inputSenha("1234");
		confirmaEdicao.clickConfirmar();
		Assert.assertEquals(menuCATG.verificaMensagem(), true);
	}

	@Test(description = "CT 02 -  Remover componente da Matriz",priority = 2 )
	public void removerComponenteMatriz() throws InterruptedException {

		menuCATG.clickListAlteraMatriz();
		alteraMatriz.informaCodMatriz("FIS-LN-1");
		alteraMatriz.clickBuscar();
		alteraMatriz.clickbtnEditar();
		dadosGeraisMatriz.clickBtnProxPasso();
		addCompMatriz.clickExcluirComponente("IFI0151 - LABORATÓRIO DE FÍSICA IV - 48h");
		Assert.assertEquals(addCompMatriz.verificarMensagemExlcusao(), true);
		addCompMatriz.clickBtnProxPasso();
		componentesMatriz.clickBtnProxPasso();
		confirmaEdicao.inputSenha("1234");
		confirmaEdicao.clickConfirmar();
		Assert.assertEquals(menuCATG.verificaMensagem(), true);
	}

	@Test(description = "CT 03 -  Adicionar Componente Matriz",priority = 3)
	public void adicionarComponenteMatriz() throws InterruptedException {

		menuCATG.clickListAlteraMatriz();
		alteraMatriz.informaCodMatriz("FIS-LN-1");
		alteraMatriz.clickBuscar();
		alteraMatriz.clickbtnEditar();
		dadosGeraisMatriz.clickBtnProxPasso();
		addCompMatriz.inputComponente("IFI0151");
		addCompMatriz.selecionaComponente("IFI0151 - LABORATÓRIO DE FÍSICA IV - 48h");
		addCompMatriz.selecionaSemestre("1");
		addCompMatriz.clickAddAtualizarComponente();
		Assert.assertEquals(addCompMatriz.verificarMensagemComponenteAdd(), true);
		addCompMatriz.clickBtnProxPasso();
		componentesMatriz.clickBtnProxPasso();
		confirmaEdicao.inputSenha("1234");
		confirmaEdicao.clickConfirmar();
		Assert.assertEquals(menuCATG.verificaMensagem(), true);
	}

	@Test(description = "CT 04 -  Adicionar  Equivalênca Específica  em um Componente Matriz", priority = 4)
	public void adicionarEquivalenciaComponente() {
		menuCATG.clickListAlteraMatriz();
		alteraMatriz.informaCodMatriz("FIS-LN-1");
		alteraMatriz.clickBuscar();
		alteraMatriz.clickbtnEditar();
		dadosGeraisMatriz.clickBtnProxPasso();
		addCompMatriz.clickEditarComponente("IFI0151 - LABORATÓRIO DE FÍSICA IV - 48h");
		addCompMatriz.inputEquivalenciaEspecifica("( IFQ0074 OU ICE0227 ) ");
		addCompMatriz.clickAddAtualizarComponente();
		Assert.assertEquals(addCompMatriz.verificarMensagemComponenteAtualizado(), true);
		addCompMatriz.clickBtnProxPasso();
		componentesMatriz.clickBtnProxPasso();
		confirmaEdicao.inputSenha("1234");
		confirmaEdicao.clickConfirmar();
		Assert.assertEquals(menuCATG.verificaMensagem(), true);
	}
	
	@Test(description = "CT 05 -  Alterar o semestre de um componente da matriz", priority = 5)
	public void alteraSemestreComponente() throws InterruptedException{
		menuCATG.clickListAlteraMatriz();
		alteraMatriz.informaCodMatriz("FIS-LN-1");
		alteraMatriz.clickBuscar();
		alteraMatriz.clickbtnEditar();
		dadosGeraisMatriz.clickBtnProxPasso();			
		addCompMatriz.clickEditarComponenteRandom();
		addCompMatriz.alteraSemestre();
		addCompMatriz.clickAddAtualizarComponente();
		Assert.assertEquals(addCompMatriz.verificarMensagemComponenteAtualizado(), true);
		addCompMatriz.clickBtnProxPasso();
		componentesMatriz.clickBtnProxPasso();
		confirmaEdicao.inputSenha("1234");
		confirmaEdicao.clickConfirmar();
		Assert.assertEquals(menuCATG.verificaMensagem(), true);
		
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}
