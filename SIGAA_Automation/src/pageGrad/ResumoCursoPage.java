package pageGrad;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ResumoCursoPage {

	WebDriver driver;

	@FindBy(how = How.ID, using = "formulario:btnConfirmar")
	WebElement idConfirmar;
	@FindBy(how = How.ID, using = "formulario:btnCancelar")
	WebElement idCancelar;

	public ResumoCursoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// esse método serve tanto para alterar quanto para confirmar um novo curso
	// a ser criado.
	public void clickRegister() {
		idConfirmar.click();
	}

	public void clickCancelar() {
		idCancelar.click();
	}

}
