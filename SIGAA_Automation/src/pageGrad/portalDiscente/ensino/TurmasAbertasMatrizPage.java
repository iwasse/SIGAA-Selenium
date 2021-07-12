package pageGrad.portalDiscente.ensino;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author iwasse 
 * 
 * 		   Página de seleção de turmas abertas de acordo com a matriz do aluno
 * 
 */

public class TurmasAbertasMatrizPage {

	WebDriver driver;
	@FindBy(how = How.ID, using = "form:btnIniciarSolicit")
	WebElement initMatricula;
	@FindBy(how = How.ID, using = "j_id_jsp_1799600954_358:adicionarTurmasSolicitacaoMatricula")
	WebElement addTurmas;
	@FindBy(how = How.ID, using = "formBotoesSuperiores:btnverTurmasAbertas")
	WebElement searchNL;
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/form[3]/table/tbody/tr/td[3]/input")
	List<WebElement> turmaLista;

	public TurmasAbertasMatrizPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// botão "Iniciar Seleção de Turmas >>"

	public void initMatricula() {
		initMatricula.click();
	}

	// Botão "Adicionar Turmas"

	public void addTurmas() {
		addTurmas.click();
	}

	// Botão "Buscar Turmas de NL"
	public void buscarNl() {
		searchNL.click();
	}

	// Método que seleciona turmas, é passada uma lista de parâmetros, que são
	// os "values" da disciplinas no elemento
	public void selectTurmas(LinkedList<String> turmas) {

		for (int i = 0; i < turmaLista.size(); i++) {
			for (int j = 0; j < turmas.size(); j++) {
				// int valor1 =
				// Integer.parseInt(turmaLista.get(i).getAttribute("value"));
				// int valor2 = Integer.parseInt(turmas.get(j));
				if (turmaLista.get(i).getAttribute("value").equalsIgnoreCase(turmas.get(j))) {
					turmaLista.get(i).click();
				}

			}
		}
	}

}
