package pageGrad.portalCoordenador.turmas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author iwasse Página que define o horário da turma
 *
 */

public class HorarioTurma {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = ".//*[@id='formHorarios:expressaoHorario']")
	WebElement codigoHorario;
	@FindBy(how = How.XPATH, using = ".//*[@id='formHorarios:defineTabelaHorario']")
	WebElement clickit;
	@FindBy(how = How.XPATH, using = ".//*[@id='formHorarios:btnAvancar']")
	WebElement nextStep;

	public HorarioTurma(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Método que preenche o campo de expressão de horário, atualiza e clica em
	// "Próximo Passo >>"
	public void setHorarioAndNext(String codigo) throws InterruptedException {
		codigoHorario.clear();
		codigoHorario.sendKeys(codigo);
		clickit.click();
		Thread.sleep(1500);
		nextStep.click();
	}

}
