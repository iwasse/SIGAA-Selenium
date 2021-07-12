package pageGrad.portalDiscente.ensino;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ConfirmacaoTurmasPage {

	WebDriver driver;

	public ConfirmacaoTurmasPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='j_id_jsp_1645539603_318:senha']")
	WebElement password;
	@FindBy(how = How.ID, using = "j_id_jsp_1645539603_318:btnConfirmar")
	WebElement confirm;
	@FindBy(how = How.ID, using = "j_id_jsp_1645539603_318:cpf")
	WebElement cpferino;
	@FindBy(how = How.ID, using = "j_id_jsp_1645539603_318:Data")
	WebElement dtnasc;
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/form/table/tbody/tr[6]/td/div/div/table/tbody/tr[1]/th")
	WebElement nome;

	// Método para decidir se vai inserir o CPF ou a Data de Nascimento para
	// validação
	public void validateInsert(String cpfx, String dnascx, String senha) {
		if (nome.getText().trim().equalsIgnoreCase("CPF:")) {
			cpferino.sendKeys(cpfx);
		} else {
			dtnasc.sendKeys(dnascx);
		}
		password.sendKeys(senha);
		confirm.click();
	}

}
