package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import Helper.BrowserFactory;
import pageGrad.LoginPageFactory;

public class TestingSelenium {


		private static final String TELA_LOGIN = "http://200.137.217.51:8081/sigaa/verTelaLogin.do";
		
		WebDriver driver;
		
		LoginPageFactory loginPageFactory;
		
		
		@BeforeMethod
		public void setUp(){
			driver = BrowserFactory.startBroswer("firefox", TELA_LOGIN);
			loginPageFactory = PageFactory.initElements(driver, LoginPageFactory.class);
		}
		
		@Test
		public void newLogin(){
			loginPageFactory.logar("admin", "secret");
		}
	

}
