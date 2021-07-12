package pageGrad.CATG.Matriz;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import Utility.SeleniumExtras;

public class AdicionarComponentesMatriz {

	WebDriver driver;
	SeleniumExtras seleniumExtras;
	Random random;

	public AdicionarComponentesMatriz(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		seleniumExtras = new SeleniumExtras();
		random = new Random();
	}

	@FindBy(how = How.ID, using = "form:submeter")
	WebElement btnProxPasso;

	@FindBy(how = How.ID, using = "form:nomeDisciplina")
	WebElement inputComponente;

	@FindBy(how = How.XPATH, using = ".//*[@id='ajaxAuto_form:nomeDisciplina']/ul/li")
	List<WebElement> listComponentes;

	@FindBy(how = How.XPATH, using = "html/body/div[2]/div[2]/form/table[2]/tbody/tr/td[3]")
	List<WebElement> listComponentesMatriz;

	@FindBy(how = How.XPATH, using = "html/body/div[2]/div[2]/div[1]/ul/li")
	WebElement labelMensagens;

	@FindBy(how = How.XPATH, using = "html/body/div[2]/div[2]/form/table[1]/tfoot/tr[1]/td/input")
	WebElement btnAdicionarAtualizarComponente;

	@FindBy(how = How.XPATH, using = "html/body/div[2]/div[2]/form/table[1]/tbody/tr[2]/td[3]/select")
	WebElement selectSemestre;

	@FindBy(how = How.XPATH, using = "html/body/div[2]/div[2]/form/table[1]/tbody/tr[4]/td/input")
	WebElement inputEquivalenciaEspecifica;
	
	@FindBy(how = How.XPATH, using = "html/body/div[2]/div[2]/form/table[1]/tbody/tr[2]/td[3]/select")
	WebElement selectPeríodo;
	
	//Dannyel - Refatorar com esse método
	//html/body/div[2]/div[2]/form/table[2]/tbody/tr[td[contains(text(),'EVOLUÇÃO DA FÍSICA I ')]]/td[4]
			
	public void clickBtnProxPasso() {
		btnProxPasso.click();
	}

	public void inputComponente(String CodicoComponente) {
		inputComponente.sendKeys(CodicoComponente);
		// inputComponente.click();
	}

	public void selecionaComponente(String componente) throws InterruptedException {
		// parametro exemplo: "IFI0151 - LABORATÓRIO DE  FÍSICA  IV - 48h"
		for (int i = 0; i < listComponentes.size(); i++) {
			if (listComponentes.get(i).getText().equalsIgnoreCase(componente)) {
				driver.findElement(By.id(listComponentes.get(i).getAttribute("id"))).click();
			}
		}
	}

	public void clickEditarComponente(String descComponente) {
		// parametro exemplo: "IFI0151 - LABORATÓRIO DE FÍSICA IV - 48h"
		driver.findElement(By.xpath(
				"html/body/div[2]/div[2]/form/table[2]/tbody/tr[td[contains(text(),'" + descComponente + "')]]/td[4]"))
				.click();
	}
	

	// Seleciona Randomicamente qualquer disciplina cadastrada na Matriz Curricular
	public void clickEditarComponenteRandom() {

		String desricaoComponente = (listComponentesMatriz.get(random.nextInt(listComponentesMatriz.size())).getText());
		driver.findElement(By.xpath("html/body/div[2]/div[2]/form/table[2]/tbody/tr[td[contains(text(),'"
				+ desricaoComponente + "')]]/td[4]")).click();

	}
	
	//Altera o semestre de um componente previamente cadastrado, para um semestre diferente do atual.
	public void alteraSemestre() throws InterruptedException {

		Select comboSemestre = new Select(selectPeríodo);
		List<WebElement> options = comboSemestre.getOptions();
		Thread.sleep(200);
		for (int i = 1; i < options.size(); i++) {
			// Se o valor do elemento selecionado for diferente de um dos// valores da lista clica.
			if (comboSemestre.getFirstSelectedOption().getText().equalsIgnoreCase(options.get(i).getText()) == false) {
				comboSemestre.selectByVisibleText(options.get(i).getText());
				break;
			}
		}
	}

	public void clickExcluirComponente(String descComponente) {
		// parametro exemplo: "IFI0151 - LABORATÓRIO DE FÍSICA IV - 48h"

		driver.findElement(By.xpath(
				"html/body/div[2]/div[2]/form/table[2]/tbody/tr[td[contains(text(),'" + descComponente + "')]]/td[5]"))
				.click();
		driver.switchTo().alert().accept();
	}

	public boolean verificarMensagemExlcusao() {
		if (labelMensagens.getText().contains("removido(a) com sucesso.")) {
			return true;
		}
		return false;
	}

	public boolean verificarMensagemComponenteAdd() {
		if (labelMensagens.getText().equalsIgnoreCase("Componente Curricular adicionado com sucesso.")) {
			return true;
		}
		return false;
	}

	public boolean verificarMensagemComponenteAtualizado() {
		if (labelMensagens.getText().equalsIgnoreCase("Componente Curricular atualizado com sucesso.")) {
			return true;
		}
		return false;
	}

	public void clickAddAtualizarComponente() {
		btnAdicionarAtualizarComponente.click();
	}

	public void selecionaSemestre(String semestre) {
		new Select(selectSemestre).selectByValue(semestre);
	}

	public void inputEquivalenciaEspecifica(String expressaEquivalencia) {
		inputEquivalenciaEspecifica.clear();
		inputEquivalenciaEspecifica.sendKeys(expressaEquivalencia);
	}



}
