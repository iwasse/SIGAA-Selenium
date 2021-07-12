package pageGrad.portalDiscente.ensino;

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
 *         Páginas de turmas abertas de núcleo livre
 */

public class TurmasAbertasNlPage {

	WebDriver driver;
	@FindBy(how = How.ID, using = "form:txtCodigo")
	WebElement codComp;
	@FindBy(how = How.ID, using = "form:buscar")
	WebElement search;
	@FindBy(how = How.ID, using = "form:comboDepartamento")
	WebElement unidade;

	public TurmasAbertasNlPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Campo "Código do Componente"
	public void insCodComp(String componente) {
		codComp.sendKeys(componente);
	}

	// Botão "Buscar"
	public void buscar() {
		search.click();
	}

	// Campo "Unidade Responsável"
	public void insUnid(String vunidade) {
		new Select(unidade).selectByValue(vunidade);
	}

}
