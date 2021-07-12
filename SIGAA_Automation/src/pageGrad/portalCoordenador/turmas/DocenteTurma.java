package pageGrad.portalCoordenador.turmas;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DocenteTurma {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = ".//*[@id='paramAjaxDocente_1']")
	WebElement docenteBox;
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/form[2]/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td/div/ul/li")
	List<WebElement> listaDocentes;
	@FindBy(xpath = ".//*[@id='formDocentes:chDedicadaTeorica']")
	WebElement teorica;
	@FindBy(xpath = ".//*[@id='formDocentes:chDedicadaPratica']")
	WebElement pratica;
	@FindBy(xpath = ".//*[@id='formDocentes:btnAdicionarDocente']")
	WebElement add;
	@FindBy(xpath = ".//*[@id='formBotoes:btnProximo']")
	WebElement next;
	private String STATUS = "/html/body/div[2]/div[2]/form[2]/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td/div/ul/li/div/div[2]/span[contains(., '(ATIVO)')]";

	public DocenteTurma(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Método seleciona aleatoriamente um docente ativo
	public void selectDocente() {
		docenteBox.sendKeys("%%%");
		int min = 1;
		Random random = new Random();
		List<WebElement> docentes = driver.findElements(By.xpath(STATUS));
		int index = random.nextInt((docentes.size() - min + 1) + min);
		docentes.get(index).click();
	}

	public void setTeorica(String horariot) {
		teorica.sendKeys(horariot);
	}

	public void setPratica(String horariop) {
		pratica.sendKeys(horariop);
	}

	public void add(){
		add.click();
	}
	
	public void nextStep() {
		next.click();
	}

}
