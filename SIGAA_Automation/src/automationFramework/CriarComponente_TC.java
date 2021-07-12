package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Helper.BrowserFactory;
import pageGrad.LoginPageFactory;
import pageGrad.MenuGradCATG;
import pageGrad.MenuPrincipalPage;
import pageGrad.CATG.Componente.DadosComponente;
import pageGrad.CATG.Componente.ResumoDadosComponente;
import pageGrad.CATG.Componente.TipoComponente;

public class CriarComponente_TC {

	WebDriver driver;
	LoginPageFactory login;
	MenuPrincipalPage menuPrincipal;
	MenuGradCATG menuGradCATG;
	TipoComponente componente;
	DadosComponente dadosComponente;
	ResumoDadosComponente resumo;
	
	@BeforeMethod
	public void setUp(){
		driver = BrowserFactory.startBroswer("firefox", "http://200.137.217.51:8081/sigaa/logar.do?dispatch=logOn");
		login = PageFactory.initElements(driver, LoginPageFactory.class);
		menuPrincipal = PageFactory.initElements(driver, MenuPrincipalPage.class);
		menuGradCATG = PageFactory.initElements(driver, MenuGradCATG.class);
		componente = PageFactory.initElements(driver, TipoComponente.class);
		dadosComponente = PageFactory.initElements(driver, DadosComponente.class);
		resumo = PageFactory.initElements(driver, ResumoDadosComponente.class);
	}
	
	@Test
	public void criarComponente() throws InterruptedException{
		login.logar("admin", "secret");
		menuPrincipal.modGrad();
		menuGradCATG.clickCadastrarComp();
		componente.setTipo("2");
		componente.setNext();
		dadosComponente.selectUnidade("863", "Disciplina Artes I");
		dadosComponente.setCargaHoraria("64", "0", "0", "0");
		dadosComponente.setEmenda("Ementa teste");
		dadosComponente.goNext();
		resumo.cadastrar();
		
	}
	
}
