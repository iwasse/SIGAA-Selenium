package pageGrad.MenuAluno;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utility.SeleniumExtras;

public class BuscarDiscente {
	
	
	WebDriver driver;
	Random random;

	public BuscarDiscente(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		random = new Random();
	}

	@FindBy(how = How.ID, using = "formulario:matriculaDiscente")
	WebElement matricula;

	@FindBy(how = How.ID, using = "formulario:cpfDiscente")
	WebElement cpf;

	@FindBy(how = How.ID, using = "formulario:nomeDiscente")
	WebElement nomeDiscente;

	@FindBy(how = How.ID, using = "formulario:curso")
	WebElement curso;

	@FindBy(how = How.XPATH, using = ".//*[@id='formulario:buscar']")
	WebElement btnBuscar;

	@FindBy(how = How.XPATH, using = ".//*[@id='formulario:cancelar']")
	WebElement btnCancelar;

	@FindBy(how = How.XPATH, using = ".//*[@id='form']/table/tfoot/tr/td")
	WebElement lblDiscenteEncontrado;

	@FindBy(how = How.XPATH, using = ".//*[@id='painel-erros']/ul/li")
	WebElement lblMsgErro;
	
	@FindBy(how = How.XPATH, using = "html/body/div[2]/div[2]/form[2]/table/tbody/tr[td[contains(text(),'ATIVO')]]/td[6]/input")
	List<WebElement> selecionarDiscentesAtivo;

	public void buscarMatricula(String mat) {
		matricula.sendKeys(mat);
		btnBuscar.click();
	}

	public void buscarCPF(String numcpf) {
		cpf.sendKeys(numcpf);
		btnBuscar.click();
	}

	public void buscarNomeDiscente(String nome) {
		nomeDiscente.sendKeys(nome);
		btnBuscar.click();
	}

	public void buscarCurso(String nomeCurso) {
		curso.sendKeys(nomeCurso);
		btnBuscar.click();
	}

	public void clickCancelar() {
		btnCancelar.click();

	}

	public boolean labelDiscentesEncontrados() {
		if ((lblDiscenteEncontrado.getText()).length() > 0) {
			return true;
		} else
			return false;
	}

	public boolean labelDiscentesNAOEncontrados() {
		if ((lblMsgErro.getText()).length() > 0) {
			return true;
		} else
			return false;
	}
	
	
	public void selecionarRandomDiscenteAtivo(){
	//	selecionarDiscentesAtivo.get(Random)
	//	String desricaoComponente = selecionarDiscentesAtivo.get(random.nextInt(selecionarDiscentesAtivo.size())).getText());
		
	for (WebElement webElement : selecionarDiscentesAtivo) {
		System.out.println(selecionarDiscentesAtivo);
	}	

	}
	
	
	
	

}
