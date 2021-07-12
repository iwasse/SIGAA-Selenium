package pageGrad;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author iwasse
 *
 *         Header do módulo graduação (onde tem o "deslogar", "Módulos", etc)
 */

public class HeaderPage {

	WebDriver driver;
	@FindBy(how = How.ID, using = "show-modulos")
	WebElement idModulos;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Área Admin.")
	WebElement idAreaAdm;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "(Deslogar)")
	WebElement deslogar;

	public HeaderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void clickMenuModulos() {
		idModulos.click();
	}

	public void clickAreaAdm() {
		idAreaAdm.click();
	}

	public void clickDeslog() {
		deslogar.click();
	}

}
