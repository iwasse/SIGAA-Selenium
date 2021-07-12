package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Helper.BrowserFactory;
import pageGrad.LoginPageFactory;
import pageGrad.MenuGradAlunos;
import pageGrad.MenuPrincipalPage;
import pageGrad.MenuAluno.BuscarDiscente;

public class AproveitarCompCurricular_TC {
	
	private WebDriver driver;
	LoginPageFactory login; 
	MenuPrincipalPage menuPrincipal;
	MenuGradAlunos alunos;
	BuscarDiscente buscaDiscente;
	
		
	@BeforeTest
	public void setUp(){
		
		driver = BrowserFactory.startBroswer("firefox", "http://200.137.217.51:8081/sigaa/logar.do?dispatch=logOn");
		login = new LoginPageFactory(driver);
		menuPrincipal = PageFactory.initElements(driver, MenuPrincipalPage.class);
		alunos = PageFactory.initElements(driver, MenuGradAlunos.class);
		buscaDiscente = PageFactory.initElements(driver, BuscarDiscente.class);
		login.logar("admin","secret");
		menuPrincipal.modGrad();
	
	}
	
	@Test
	public void aproveitarComponenteNC() throws InterruptedException{
		//alunos.clickAproveitarCompCurricular();
		//Thread.sleep(2000);
		alunos.clickAproveitarCompCurricular();

		buscaDiscente.buscarNomeDiscente("José");
		Assert.assertEquals(buscaDiscente.labelDiscentesEncontrados(),true);
		buscaDiscente.selecionarRandomDiscenteAtivo();
		Thread.sleep(20000);
	
	}
	
}
