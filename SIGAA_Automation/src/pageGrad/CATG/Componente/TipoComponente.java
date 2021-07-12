package pageGrad.CATG.Componente;

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
 *			Pagina de criação de componente
 */

public class TipoComponente {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = ".//*[@id='form:tipo']")
	WebElement tipo;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='form:tipoAtividade']")
	WebElement tipoAtividades;
	
	@FindBy(how = How.XPATH, using=".//*[@id='form:formaParticipacao']")
	WebElement formaParticipacao;

	@FindBy(how = How.XPATH, using = ".//*[@id='form:avancar']")
	WebElement next;


	
	
	public TipoComponente(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void setTipo(String value){
		new Select(tipo).selectByValue(value);
	}
	
	public void setAtividade(String valueOne, String valueTwo){
		new Select(tipoAtividades).selectByValue(valueOne);
		new Select(formaParticipacao).selectByValue(valueTwo);
		next.click();
	}
	
	public void setNext(){
		next.click();
	}
}
