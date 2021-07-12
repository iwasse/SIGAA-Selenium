package pageGrad.portalCoordenador.turmas;

import java.util.List;

import org.openqa.selenium.By;
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
 *         Página de listagem dos componentes curriculares com a opção de filtro
 *         por matriz
 */

public class ListaComponentes {

	WebDriver driver;

	public ListaComponentes(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/form/table/tbody/tr/td/select")
	WebElement matrix;
	@FindBy(how = How.XPATH, using = ".//*[@id='listaDisciplinas']/tbody/tr/td[1]")
	List<WebElement> code;
	private String SELECT_COMPONENT = ".//*[@id='listaDisciplinas']/tbody/tr[%d]/td[6]/input[2]";

	
	// Método que seleciona a matriz desejada de acordo com o value do elemento
	public void selectMatrix(String matriz) throws InterruptedException {
		new Select(matrix).selectByValue(matriz);
		Thread.sleep(1000);
	}

	// Método no qual seleciona o componente desejado
	public void selectComponent(String codigo) {

		for (int i = 0; i < code.size(); i++) {
			if (code.get(i).getText().equalsIgnoreCase(codigo)) {
				WebElement elecode = driver.findElement(By.xpath(String.format(SELECT_COMPONENT, i + 1)));
				elecode.click();
				return;
			}
		}
		throw new RuntimeException("Não foi possível encontrar nenhum curso com o codigo " + codigo);
	}
}