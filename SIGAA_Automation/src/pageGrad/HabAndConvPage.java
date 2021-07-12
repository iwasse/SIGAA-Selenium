package pageGrad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 * @author iwasse
 *
 *         Página de dados da Habilitação e Convenio do fluxo de criação do
 *         curso
 */

public class HabAndConvPage {

	WebDriver driver;

	@FindBy(how = How.ID, using = "formulario:nome")
	WebElement idNomeH;
	@FindBy(how = How.ID, using = "formulario:j_id_jsp_736296542_11")
	WebElement idPossuiConv;
	@FindBy(how = How.NAME, using = "formulario:convenio")
	WebElement idConvenio;
	@FindBy(how = How.NAME, using = "formulario:j_id_jsp_736296542_17")
	WebElement idDescConv;
	@FindBy(how = How.NAME, using = "formulario:j_id_jsp_736296542_18")
	WebElement idInstituicao;
	@FindBy(how = How.NAME, using = "formulario:j_id_jsp_736296542_19")
	WebElement idMotivacao;
	@FindBy(how = How.ID, using = "formulario:pais")
	WebElement idPais;
	@FindBy(how = How.ID, using = "formulario:uf")
	WebElement idEstado;
	@FindBy(how = How.NAME, using = "formulario:j_id_jsp_736296542_28")
	WebElement idMunicipio;
	@FindBy(how = How.ID, using = "formulario:proximoPasso")
	WebElement idNext;
	@FindBy(how = How.ID, using = "formulario:cancelar")
	WebElement idCancel;
	@FindBy(how = How.ID, using = "formulario:dadosMatriz")
	WebElement idDadosCurso;

	public HabAndConvPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// se não possuir convênio CADASTRADO

	// Nome da Nova Habilitação:*
	public void nomeHabilit(String sNome) {
		idNomeH.sendKeys(sNome);
	}

	// true or false
	// Possui convênio já cadastrado:
	public void possuiConv(String sConv) {
		if (sConv == "sim") {
			driver.findElement(By
					.xpath("/html/body/div[2]/div[2]/form/table/tbody/tr/td/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/input"))
					.click();
		} else if (sConv == "nao") {
			driver.findElement(By
					.xpath("/html/body/div[2]/div[2]/form/table/tbody/tr/td/table/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/input"))
					.click();
		}

	}

	// if true
	// Convênio:*
	public void nomeConv(String sNomeConv) {
		new Select(idConvenio).selectByVisibleText(sNomeConv);
	}

	// if false
	// Descrição do Novo Convênio:*
	public void novoConv(String sNovoConv) {
		idDescConv.sendKeys(sNovoConv);
	}

	// Instituição Envolvida:
	public void nomeInst(String sNomeInst) {
		idInstituicao.sendKeys(sNomeInst);
	}

	// Motivação:
	public void motivacao(String sMotivacao) {
		idInstituicao.sendKeys(sMotivacao);
	}

	// País:*
	public void nomePais(String sNomePais) {
		new Select(idPais).selectByValue(sNomePais);
	}

	// Estado:*
	public void nomeEstado(String sNomeEstado) {
		new Select(idEstado).selectByValue(sNomeEstado);
	}

	// Município:*
	public void nomeMunicipio(String sNomeMunicipio) {
		new Select(idMunicipio).selectByValue(sNomeMunicipio);
	}

	// botão Próximo Passo >>
	public void next() {
		idNext.click();
	}

	// botão Cancelar
	public void cancel() {
		idCancel.click();
	}

	// botão << Dados do Curso
	public void backToDadosCurso() {
		idDadosCurso.click();
	}
}
