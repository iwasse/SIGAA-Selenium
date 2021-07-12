package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Helper.BrowserFactory;
import pageGrad.AdministracaoPage;
import pageGrad.HeaderPage;
import pageGrad.LoginPageFactory;
import pageGrad.MenuPrincipalPage;
import pageGrad.portalCoordenador.PortalCoordPage;
import pageGrad.portalCoordenador.turmas.DadosTurma;
import pageGrad.portalCoordenador.turmas.DadosTurmaResumo;
import pageGrad.portalCoordenador.turmas.DocenteTurma;
import pageGrad.portalCoordenador.turmas.HorarioTurma;
import pageGrad.portalCoordenador.turmas.ListaComponentes;

/**
 * 
 * @author iwasse
 *
 *         Casos de testes para oferta de turmas através do Portal do
 *         Coordenador
 */
public class OfertarTurmas_TC {

	private WebDriver driver;

	private static final String TELA_LOGIN = "http://200.137.217.51:8081/sigaa/verTelaLogin.do";

	LoginPageFactory loginpage;
	HeaderPage header;
	AdministracaoPage adm;
	MenuPrincipalPage menuprincipal;
	PortalCoordPage portal;
	ListaComponentes lista;
	DadosTurma turma;
	HorarioTurma horario;
	DocenteTurma docente;
	DadosTurmaResumo resumo;

	@BeforeTest
	public void setUp() {
		driver = BrowserFactory.startBroswer("firefox", TELA_LOGIN);
		loginpage = PageFactory.initElements(driver, LoginPageFactory.class);
		header = PageFactory.initElements(driver, HeaderPage.class);
		adm = PageFactory.initElements(driver, AdministracaoPage.class);
		menuprincipal = PageFactory.initElements(driver, MenuPrincipalPage.class);
		portal = PageFactory.initElements(driver, PortalCoordPage.class);
		lista = PageFactory.initElements(driver, ListaComponentes.class);
		turma = PageFactory.initElements(driver, DadosTurma.class);
		horario = PageFactory.initElements(driver, HorarioTurma.class);
		docente = PageFactory.initElements(driver, DocenteTurma.class);
		resumo = PageFactory.initElements(driver, DadosTurmaResumo.class);
	}

	@Test(description="Criar turma regular")
	public void testcaneOne() throws InterruptedException {

		loginpage.logar("admin", "secret");
		header.clickAreaAdm();
		adm.logarComo("adriano");
		menuprincipal.portCoord();
		portal.clickOfertarTurma();
		lista.selectComponent("EMC0011");
		turma.tipoTurma("REGULAR");
		turma.cursoResponsavel("69678369");
		turma.selectCampus("68700500");
		turma.setVagas("10");
		turma.setLocal("Sala 666");
		turma.setImpedirMatricula("não");
		turma.setImpedirNl("sim");
		turma.selectMatrix("1394294");
		turma.adicionarOferta();
		turma.clickNext();
		horario.setHorarioAndNext("2M2345");
		docente.selectDocente();
		docente.setTeorica("60");
		docente.add();
		docente.nextStep();
		resumo.register();
		Assert.assertEquals(portal.verifyMsg(),true);

	}

}
