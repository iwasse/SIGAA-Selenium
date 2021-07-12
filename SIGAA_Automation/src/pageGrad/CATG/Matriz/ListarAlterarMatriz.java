package pageGrad.CATG.Matriz;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;


public class ListarAlterarMatriz {

	@FindBy(how=How.XPATH,using=".//*[@id='busca:municipio']")
	WebElement  comboMunicipio;
	
	@FindBy(how=How.XPATH,using=".//*[@id='busca:curso']")
	WebElement  comboCurso;
	
	@FindBy(how=How.XPATH,using=".//*[@id='busca:turno']")
	WebElement  comboTurno;
	
	@FindBy(how=How.ID,using="busca:codigo")
	WebElement  inputCodigo;
	
	@FindBy(how=How.ID,using="busca:btnBuscar")
	WebElement  btnBuscar;

	@FindBy(how=How.ID,using="busca:btnCancelar")
	WebElement  btnCancelar;
	
	@FindBy(how=How.XPATH,using=".//*[@id='painel-erros']/ul/li")
	WebElement  labelErro;
	
	@FindBy(how=How.XPATH,using=".//*[@id='resultado:alterar']/img")
	WebElement  btnEditarMatriz;
		
	public void selectMunicipio(String municipio){
		new Select(comboMunicipio).selectByVisibleText(municipio);
	}
	
	public void selectCurso(String curso){
		new Select(comboCurso).selectByVisibleText(curso);
	}
	
	public void selectTurno(String turno){
		new Select(comboTurno).selectByVisibleText(turno);
	}
	
	public void informaCodMatriz(String codMatriz){
		inputCodigo.sendKeys(codMatriz);
	}
	
	public void clickBuscar(){
		btnBuscar.click();
	}
	
	public void clickCancelar(){
		btnCancelar.click();
	}
	
	public void clickbtnEditar(){
		btnEditarMatriz.click();
	}
	



}