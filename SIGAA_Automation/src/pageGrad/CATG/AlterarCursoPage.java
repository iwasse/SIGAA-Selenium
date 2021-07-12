package pageGrad.CATG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/*
 * Autor: Guilherme Iwasse
 * 
 * Página de busca e edição de curso de graduação
 */

public class AlterarCursoPage {

	WebDriver driver;
	@FindBy(how = How.ID, using = "busca:somenteAtivas")
	WebElement somenteAtivos;
	@FindBy(how = How.ID, using = "checkCurso")
	WebElement checkCurso;
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/form/table/tbody/tr[1]/td[3]/input")
	WebElement campoCurso;
	@FindBy(how = How.ID, using = "checkTodos")
	WebElement checkAll;
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/table/tbody/tr/td[3]/form/input[2]")
	List<WebElement> listaCursos;
	private String EDITAR_CURSO_FORM = "/html/body/div[2]/div[2]/table/tbody/tr[%d]/td[3]/form";

	public AlterarCursoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void unSelectAtivo() {
		somenteAtivos.click();
	}

	public void checkCurso() {
		checkCurso.click();
	}

	public void campoCurso(String nomedocurso) {
		campoCurso.sendKeys(nomedocurso);
	}

	public void checkAll() {
		checkAll.click();
	}

	// clicar em "alterar curso", passando como parâmetro o value (código do
	// curso do banco);
	// este método irá retornar a página "DadosCursoPage".
	public void clickAlterarCurso(String valueCurso) {

		for (int i = 0; i < listaCursos.size(); i++) {
			if (listaCursos.get(i).getAttribute("value").equalsIgnoreCase(valueCurso)) {
				WebElement formElement = driver.findElement(By.xpath(String.format(EDITAR_CURSO_FORM, i + 1)));
				formElement.click();
				return;
			}
		}
		throw new RuntimeException("Não foi possível encontrar nenhum curso com o valor " + valueCurso);

	}

	@FindBy(how = How.ID, using = "busca:btnBusca")
	WebElement idBusca;

	public void clickSearch() {
		idBusca.click();
	}

}
