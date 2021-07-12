package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.*;

import Helper.BrowserFactory;
import Utility.ExcelDataConfig;
import Utility.Login;
import pageGrad.LoginPageFactory;

//TestNG study

/*	Hierarquias:
		
	@BeforeSuite
		@BeforeTest
			@BeforeClass
			 	@BeforeMethod
			 		@Test
			 	@AfterMethod
		 	@AfterClass
		 @AfterTest
	@AfterSuite
*/
/*
 * Author: Guilherme Iwasse
 * 
 */

public class SigaaLoginTC {

	private static final String MENU_PRINCIPAL = "http://200.137.217.51:8081/sigaa/verMenuPrincipal.do";
	private static final String TELA_LOGIN = "http://200.137.217.51:8081/sigaa/verTelaLogin.do";
	private static final String DATA_INPUT = "TestData/Inputdata.xlsx";
	
	
	private WebDriver driver;
	
	LoginPageFactory loginPageFactory;
	
	
	@BeforeMethod
	public void setUp(){
		driver = BrowserFactory.startBroswer("firefox", TELA_LOGIN);
		loginPageFactory = PageFactory.initElements(driver, LoginPageFactory.class);
	}
	
	
	@Test(dataProvider="logins", groups = {"checkintest"})
	public void login(Login login) throws InterruptedException{	
		System.setProperty("webdriver.gecko.driver","GeckoDriver/geckodriver");
		loginPageFactory.logar(login.getUsuario(), login.getSenha());

		Thread.sleep(2000);
		
		Assert.assertTrue(driver.getCurrentUrl().contains(MENU_PRINCIPAL), "Usuário ou senha inválidos");	
	}
	 
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	@DataProvider(name="logins")
	public Object[][] passData(){
		
		ExcelDataConfig config = new ExcelDataConfig(DATA_INPUT);
		
		//conta o número de linhas e colunas do arquivo
		int rows = config.getRowCount(0);
		//int columns = config.getColumnCount(0);
		
		//System.out.println("Número de coluns: " + columns);
		System.out.println("Numero de linhas: " + rows);
					
		Object[][] data = new Object[rows][1];
		//loop para buscar os dados de todas as linhas e colunas
		for(int i = 0; i < rows; i++){
			Login login = new Login();
			
			login.setUsuario(config.getData(0, i, 0));
			login.setSenha(config.getData(0, i, 1));
			
				//data[i][j] = config.getData(0, i, j);
			data[i][0] = login;
		}

		return data;
		
	}
}
