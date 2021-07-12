package pageGrad;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MenuGradCATG {

	WebDriver driver;

	@FindBy(how = How.ID, using = "elgen-26")
	WebElement clickCATG;
	@FindBy(how = How.XPATH, using = ".//*[@id='cdp-cadastros']/ul/li[3]/ul/li[1]/a")
	WebElement cadastrarCurso;
	@FindBy(how = How.XPATH, using = ".//*[@id='cdp-cadastros']/ul/li[3]/ul/li[2]/a")
	WebElement alterarCurso;
	@FindBy(how = How.XPATH, using=".//*[@id='cdp-cadastros']/ul/li[7]/ul/li[1]/a")
	WebElement cadastrarComponente;

	@FindBy(how = How.XPATH, using = "html/body/div[2]/div[2]/form[2]/div/div[2]/div[3]/ul/li[8]/ul/li[2]/a")
	WebElement linkListarAlterarMatriz;

	@FindBy(how = How.XPATH, using = ".//*[@id='painel-erros']/ul/li")
	WebElement labelMensagens;

	public MenuGradCATG(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Clicar na Aba CATG
	public void clicCATGmenu() {
		clickCATG.click();
	}

	// Link Cadastrar (Curso)
	public void clickCadastrarCurso() {
		clicCATGmenu();
		cadastrarCurso.click();
	}

	// Link Listar/Alterar (Curso)
	public void clickAlterarCurso() {
		clicCATGmenu();
		alterarCurso.click();
	}

	public void clickListAlteraMatriz() {
		clicCATGmenu();
		linkListarAlterarMatriz.click();
	}
	
	//Link Cadastrar (Componente)
	public void clickCadastrarComp(){
		clicCATGmenu();
		cadastrarComponente.click();
	}

	// Mensagens de Sucesso Erro
	public boolean verificaMensagem() {
		if ((labelMensagens.getText().equalsIgnoreCase("Matriz Curricular alterada com sucesso."))) {
			return true;
		} else
			return false;
	}
}
