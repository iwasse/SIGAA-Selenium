package pageGrad.portalDiscente.ensino;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author iwasse
 * 
 *         Página das turmas que foram selecionadas pelo discente
 */

public class TurmasSelecPage {

	WebDriver driver;

	@FindBy(how = How.ID, using = "formBotoesSuperiores:linkSubmissao")
	WebElement confirmar;

	public TurmasSelecPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void confirmarSoli() {
		confirmar.click();
	}

}
