package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Helper.BrowserFactory;
import pageGrad.HabAndConvPage;
import pageGrad.LoginPageFactory;
import pageGrad.MenuGradCATG;
import pageGrad.MenuPrincipalPage;
import pageGrad.ResumoCursoPage;
import pageGrad.CATG.DadosCursoPage;

public class CriarCurso_TC {

	private WebDriver driver;
	LoginPageFactory loginPageFactory;
	MenuPrincipalPage menuPrincipal;
	MenuGradCATG menuGradCATG;
	DadosCursoPage cursoPage;
	ResumoCursoPage resumoPage;
	HabAndConvPage habPage;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = BrowserFactory.startBroswer("firefox", "http://200.137.217.51:8081/sigaa/logar.do?dispatch=logOn");
		loginPageFactory = PageFactory.initElements(driver, LoginPageFactory.class);
		menuGradCATG = PageFactory.initElements(driver, MenuGradCATG.class);
		menuPrincipal = PageFactory.initElements(driver, MenuPrincipalPage.class);
		cursoPage = PageFactory.initElements(driver, DadosCursoPage.class);
		resumoPage = PageFactory.initElements(driver, ResumoCursoPage.class);
		habPage = PageFactory.initElements(driver, HabAndConvPage.class);

	}

	/*
	 * CT01 - Criar curso: 1. Bacharelado 2. Presencial 3. Sem Habilitação 4.
	 * Sem Convênio Acadêmico
	 */

	@Test
	public void criarCursoOne() throws InterruptedException {

		loginPageFactory.logar("admin", "secret");
		menuPrincipal.modGrad();
		menuGradCATG.clickCadastrarCurso();
		cursoPage.cursoNome("Curso TC01");
		cursoPage.cursoMunicipio("Goiânia");
		cursoPage.cursoCampus("68700506");
		cursoPage.grauCurso("BACHARELADO");
		cursoPage.modalidadeCurso("Presencial");
		cursoPage.habCurso("nao");
		cursoPage.convenioCurso("nao");
		cursoPage.codinepCurso("2112");
		cursoPage.turnoCurso(0);
		cursoPage.unidCurso("905");
		cursoPage.ofertaCurso("3");
		cursoPage.regimeCurso("2");
		cursoPage.situCurso("1");
		cursoPage.atoSCurso("10");
		//cursoPage.atoCurso("2112");
		//cursoPage.dataAtoCurso("01/09/1991");
		//cursoPage.dataPubCurso("01/09/1991");
		//cursoPage.clickNext();
		// resumoPage.clickRegister();
	}

	/*
	 * CT02 - Criar curso: 1. Bacharelado 2. Presencial 3. Com Habilitação 4.
	 * Sem Convênio Acadêmico
	 */

	//@Test
	public void criarCursoTwo() throws InterruptedException {

		loginPageFactory.logar("admin", "secret");
		menuPrincipal.modGrad();
		menuGradCATG.clickCadastrarCurso();
		cursoPage.cursoNome("Curso TC02x");
		cursoPage.cursoMunicipio("Goiânia");
		cursoPage.cursoCampus("68700506");
		cursoPage.grauCurso("BACHARELADO");
		cursoPage.modalidadeCurso("Presencial");
		Thread.sleep(1000);
		cursoPage.habCurso("sim");
		cursoPage.convenioCurso("nao");
		Thread.sleep(1000);
		cursoPage.codinepCurso("2113");
		cursoPage.turnoCurso(2);
		cursoPage.unidCurso("880");
		cursoPage.ofertaCurso("3");
		cursoPage.regimeCurso("2");
		cursoPage.situCurso("1");
		cursoPage.atoSCurso("10");
		cursoPage.atoCurso("2113");
		cursoPage.dataAtoCurso("01/09/1991");
		cursoPage.dataPubCurso("01/09/1991");
		cursoPage.clickNext();
		habPage.nomeHabilit("Habilitacion");
		habPage.next();
		// resumoPage.clickRegister();

	}

	/*
	 * CT03 - Criar curso: 1. Bacharelado 2. Presencial 3. Sem Habilitação 4.
	 * Com Convênio Acadêmico
	 */

	//@Test
	public void criarCursoThree() throws InterruptedException {

		loginPageFactory.logar("admin", "secret");
		menuPrincipal.modGrad();
		menuGradCATG.clickCadastrarCurso();
		cursoPage.cursoNome("Curso TC03");
		cursoPage.cursoMunicipio("Goiânia");
		cursoPage.cursoCampus("68700506");
		cursoPage.grauCurso("BACHARELADO");
		cursoPage.modalidadeCurso("Presencial");
		Thread.sleep(2000);
		cursoPage.habCurso("nao");
		cursoPage.convenioCurso("SIM");
		Thread.sleep(2000);
		cursoPage.codinepCurso("2113");
		cursoPage.turnoCurso(2);
		cursoPage.unidCurso("880");
		cursoPage.ofertaCurso("3");
		cursoPage.regimeCurso("2");
		cursoPage.situCurso("1");
		cursoPage.atoSCurso("10");
		cursoPage.atoCurso("2113");
		cursoPage.dataAtoCurso("01/09/1991");
		cursoPage.dataPubCurso("01/09/1991");
		cursoPage.clickNext();
		habPage.possuiConv("sim");
		habPage.nomeConv("BB");
		habPage.next();
		// resumoPage.clickRegister();
	}

	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

}
