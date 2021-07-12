package pageGrad.portalCoordenador.turmas;

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
 *         Página dos dados da oferta de turma como ano-periodo, vagas, etc.
 * 
 */

public class DadosTurma {

	@FindBy(how = How.XPATH, using = ".//*[@id='cadastroTurma:tipoTurma']")
	WebElement tipoTurma;
	@FindBy(how = How.XPATH, using = ".//*[@id='cadastroTurma']/table/tbody/tr[8]/td/select")
	WebElement responsavel;
	@FindBy(how = How.XPATH, using = ".//*[@id='cadastroTurma:ano']")
	WebElement ano;
	@FindBy(how = How.XPATH, using = ".//*[@id='cadastroTurma:periodo']")
	WebElement periodo;
	@FindBy(how = How.XPATH, using = ".//*[@id='cadastroTurma:campus']")
	WebElement campus;
	@FindBy(how = How.XPATH, using = ".//*[@id='cadastroTurma:vagas']")
	WebElement vagas;
	@FindBy(how = How.XPATH, using = ".//*[@id='cadastroTurma:vagasNucleoLivre']")
	WebElement vagasnl;
	@FindBy(how = How.XPATH, using = ".//*[@id='cadastroTurma:local']")
	WebElement local;
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/form[2]/table/tbody/tr[14]/td/table/tbody/tr/td[1]/input")
	WebElement yesOne;
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/form[2]/table/tbody/tr[14]/td/table/tbody/tr/td[2]/input")
	WebElement noOne;
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/form[2]/table/tbody/tr[15]/td/table/tbody/tr/td[1]/input")
	WebElement yesTwo;
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/form[2]/table/tbody/tr[15]/td/table/tbody/tr/td[2]/input")
	WebElement noTwo;
	@FindBy(how = How.XPATH, using = ".//*[@id='cadastroTurma:dataInicioTurma']")
	WebElement inicio;
	@FindBy(how = How.XPATH, using = ".//*[@id='cadastroTurma']/table/tbody/tr[19]/td/table/tbody/tr[1]/td/select")
	WebElement matrix;
	@FindBy(how = How.XPATH, using = ".//*[@id='cadastroTurma:dataFimTurma']")
	WebElement fim;
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/form[2]/table/tbody/tr[19]/td/table/tbody/tr[2]/td[1]/table/tbody/tr/td[1]/input")
	WebElement yesThree;
	@FindBy(how = How.XPATH, using = ".//*[@id='cadastroTurma:td-reservadas']/input")
	WebElement numreservas;
	@FindBy(how = How.XPATH, using = ".//*[@id='cadastroTurma']/table/tbody/tr[19]/td/table/tfoot/tr/td/input")
	WebElement adicionarOferta;
	@FindBy(how = How.XPATH, using = ".//*[@id='cadastroTurma:dataTableReserva:tbody_element']/tr/td[4]/a/img")
	WebElement excluir;
	@FindBy(how = How.XPATH, using = ".//*[@id='cadastroTurma:proximoPasso']")
	WebElement next;

	public DadosTurma(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Selecionar o tipo da turma (ex.: Regular, verão/inverno)
	public void tipoTurma(String tipo) {
		new Select(tipoTurma).selectByVisibleText(tipo);
	}

	// Curso responsável pela oferta
	public void cursoResponsavel(String valor) throws InterruptedException {
		new Select(responsavel).selectByValue(valor);
		Thread.sleep(500);
	}

	// Ano da oferta
	public void setAno(String year) {
		ano.clear();
		ano.sendKeys(year);
	}

	// Período da oferta
	public void setPeriodo(String semester) throws InterruptedException {
		periodo.clear();
		periodo.sendKeys(semester);
		Thread.sleep(500);
	}

	// Selecionar campus
	public void selectCampus(String valor) throws InterruptedException {
		new Select(campus).selectByValue(valor);
	}

	// Quantidade de Vagas
	public void setVagas(String numero) {
		vagas.clear();
		vagas.sendKeys(numero);
	}

	// Quantidade de vagas para núcleo livre
	public void setVagasnl(String numeronl) {
		vagasnl.clear();
		vagasnl.sendKeys(numeronl);
	}

	// Local da turma
	public void setLocal(String place) {
		local.clear();
		local.sendKeys(place);
	}

	public void setImpedirMatricula(String booleano) {
		if (booleano.equalsIgnoreCase("sim")) {
			yesOne.click();
		} else
			noOne.click();
	}

	// Impedir nl ou não
	public void setImpedirNl(String booleano) {
		if (booleano.equalsIgnoreCase("sim")) {
			yesTwo.click();
		} else
			noTwo.click();
	}

	// Data início da turma
	public void setDataInicio(String data) {
		inicio.clear();
		inicio.sendKeys(data);
	}

	// Data fim da turma
	public void setDataFim(String data) {
		fim.clear();
		fim.sendKeys(data);
	}

	// Selecionar matriz para a oferta
	public void selectMatrix(String valor) throws InterruptedException {
		new Select(matrix).selectByValue(valor);
		Thread.sleep(2000);
	}

	// Vagas reservadas
	public void reservarVagas(String reservadas) {
		yesThree.click();
		numreservas.sendKeys(reservadas);
	}

	// clicar em adicionar oferta
	public void adicionarOferta() throws InterruptedException {
		adicionarOferta.click();
		Thread.sleep(1500);
	}

	public void excluirMatrix() {
		excluir.click();
	}

	public void clickNext() {
		next.click();
	}

}
