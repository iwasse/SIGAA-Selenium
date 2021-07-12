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
 *         Página na qual o discente é direcionado antes de acessar a matrícula
 *         online onde ele atualiza seus dados pessoais
 * 
 *         OBS.: essa página não é exibida novamente ao clicar em
 *         "Realizar Matricula Online" quando o discente atualiza seus dados
 *         pessoais
 */

public class AtualizarDadosMatricula {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//*[@id='painel-erros']/ul/li")
	WebElement msg;
	@FindBy(how = How.ID, using = "formDiscente:endCEP")
	WebElement cep;
	@FindBy(how = How.XPATH, using = ".//*[@id='formDiscente:txtRendaFamiliar']")
	WebElement renda;
	@FindBy(how = How.XPATH, using = ".//*[@id='formDiscente:txtQuantidadeMembros']")
	WebElement qtde;
	@FindBy(how = How.XPATH, using = ".//*[@id='formDiscente:btnConfirmar']")
	WebElement confirm;
	@FindBy(how = How.ID, using = "formDiscente:Data")
	WebElement data;
	@FindBy(how = How.ID, using = "formDiscente:cpf")
	WebElement cpf;
	@FindBy(how = How.ID, using = "formDiscente:senha")
	WebElement password;
	@FindBy(how = How.XPATH, using = ".//*[@id='formDiscente']/table/tbody/tr[34]/td/div/div/table/tbody/tr[1]/th")
	WebElement name;

	public AtualizarDadosMatricula(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean checkPage() {
		if (msg.getText().equals("Atualize seus dados pessoais antes de efetuar a matrícula.")) {
			return true;
		} else
			return false;
	}

	public void setCep(String setcep) {
		cep.clear();
		cep.sendKeys(setcep);
	}

	public void putRenda(String dinheiro) {
		renda.clear();
		renda.sendKeys(dinheiro);

	}

	public void putQtde(String quantidade) {
		renda.clear();
		qtde.sendKeys(quantidade);
	}

	public void validateInsert(String cpfx, String dnascx, String senha) {

		System.out.println(name.getText());
		if (name.getText().equals("CPF:")) {
			cpf.sendKeys(cpfx);
		} else
			data.sendKeys(dnascx);

		password.sendKeys(senha);
		confirm.click();
	}

}
