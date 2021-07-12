package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Helper.BrowserFactory;
import pageGrad.LoginPageFactory;
import pageGrad.MenuGradAlunos;
import pageGrad.MenuPrincipalPage;
import pageGrad.MenuAluno.BuscarDiscente;


//Descrição dos Casos de Teste :: http://goo.gl/3JXS1N

public class BuscarDiscente_TC {
	
	
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
		
	@AfterMethod
	public void cancelarOperação() throws InterruptedException{

		buscaDiscente.clickCancelar();
		Thread.sleep(10);
		Thread.sleep(10);
		driver.switchTo().alert().accept();
	}
	
	//CT 01 - Buscar Discente pela Matrícula Correta - Formulario Consultar Dados do Aluno
	@Test(priority=1)
	public void buscaDiscenteMatricula() throws InterruptedException{
		alunos.clickConsultarDadosAluno();
		buscaDiscente.buscarMatricula("201603259");
		Assert.assertEquals(buscaDiscente.labelDiscentesEncontrados(),true);
	}

	//CT 02 - Buscar Discente pelo CPF correto - Formulario Consultar Dados do Aluno
	
	@Test(priority=2)
	public void buscaDiscenteCPF(){
		alunos.clickConsultarDadosAluno();
		buscaDiscente.buscarCPF("04123893120");
		Assert.assertEquals(buscaDiscente.labelDiscentesEncontrados(),true);
	}
	
	//CT 03 - Buscar Discente pelo Nome correto - Formulario Consultar Dados do Aluno
	@Test(priority=3)
	public void bucaDiscenteNome(){
	
		alunos.clickConsultarDadosAluno();
		buscaDiscente.buscarNomeDiscente("HUGO RODRIGUES PESSONI ");
		Assert.assertEquals(buscaDiscente.labelDiscentesEncontrados(),true);

	}

	//CT 04 - Buscar Discente pelo Curso correto - Formulario Consultar Dados do Aluno
	@Test(priority=4)
	public void buscaDiscenteCurso(){
		alunos.clickConsultarDadosAluno();
		buscaDiscente.buscarCurso("ENGENHARIA DE TRANSPORTES");
		Assert.assertEquals(buscaDiscente.labelDiscentesEncontrados(),true);
	}
	
	//CT 05 - Buscar Discente pela Matrícula Incorreta - Formulario Consultar Dados do Aluno
	@Test(priority=5)
	public void buscaDiscenteMatriculaERRO() throws InterruptedException{
		alunos.clickConsultarDadosAluno();
		buscaDiscente.buscarMatricula("111111111111");
		Assert.assertEquals(buscaDiscente.labelDiscentesNAOEncontrados(),true);
	}
	
	//CT 06 - Buscar Discente pelo CPF Incorreto - Formulario Consultar Dados do Aluno
	@Test(priority=6)
	public void buscaDiscenteCPFERRO(){
		alunos.clickConsultarDadosAluno();
		buscaDiscente.buscarCPF("1111111111111");
		Assert.assertEquals(buscaDiscente.labelDiscentesNAOEncontrados(),true);
	}
	
	//CT 07 - Buscar Discente pelo Nome Incorreto - Formulario Consultar Dados do Aluno
	@Test(priority=7)
	public void bucaDiscenteNomeERRO(){
		alunos.clickConsultarDadosAluno();
		buscaDiscente.buscarNomeDiscente("asdasdasda asd as d asssssssll~çloeopwoeo=-121@#?!@#}!@?:#");
		Assert.assertEquals(buscaDiscente.labelDiscentesNAOEncontrados(),true);
	}
	
	//CT 08 - Buscar Discente pelo Curso Incorreto - Formulario Consultar Dados do Aluno
	@Test(priority=8)
	public void buscaDiscenteCursoERRO(){
		alunos.clickConsultarDadosAluno();
		buscaDiscente.buscarCurso("12312 sdklnfklsdm 0-1-= -1203 0-123-091--90129 12093-12opo12");
		Assert.assertEquals(buscaDiscente.labelDiscentesNAOEncontrados(),true);
	}
	
	
	@AfterSuite
	public void tearDown(){
		driver.quit();
	}
}
