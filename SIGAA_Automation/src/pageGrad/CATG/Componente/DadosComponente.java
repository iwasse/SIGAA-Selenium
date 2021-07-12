package pageGrad.CATG.Componente;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DadosComponente {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = ".//*[@id='form:unidades']")
	WebElement unidade;
	@FindBy(how = How.XPATH, using = ".//*[@id='tableDadosGerais']/tbody/tr[4]/td/a/img")
	WebElement gerarCodigo;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:nome']")
	WebElement nome;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:chAula']")
	WebElement chTeorica;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:chLab']")
	WebElement chPratica;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:chEad']")
	WebElement chEad;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:chPcc']")
	WebElement chPCC;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:radioMatriculavelOnline:0']")
	WebElement matriculavelOnlineYes;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:radioMatriculavelOnline:1']")
	WebElement matriculavelOnlineNo;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:checkPermiteChCompartilhada:0']")
	WebElement permiteCompartilhadaYes;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:checkPermiteChCompartilhada:1']")
	WebElement permiteCompartilhadaNo;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:radioFlexibilidadeHorario:0']")
	WebElement flexivelYes;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:radioFlexibilidadeHorario:1']")
	WebElement flexivelNo;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:checkPermiteHorarioDocenteFlexivel:0']")
	WebElement docenteFlexYes;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:checkPermiteHorarioDocenteFlexivel:1']")
	WebElement docenteFlexNo;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:radioTurmasSemSolicitacao:0']")
	WebElement turmasSemSolicitacaoYes;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:radioTurmasSemSolicitacao:1']")
	WebElement turmasSemSolicitacaoNo;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:radioPermiteCargaHorariaLivreAtividade:0']")
	WebElement chLivreYes;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:radioPermiteCargaHorariaLivreAtividade:1']")
	WebElement chLivreNo;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:radioAceitaSubTurma:0']")
	WebElement subTurmaYes;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:radioAceitaSubTurma:1']")
	WebElement subTurmaNo;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:radioNecessitaNotaFinal:0']")
	WebElement notalFinalYes;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:radioNecessitaNotaFinal:1']")
	WebElement notalFinalNo;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:checkExigeHorarioEmTurmas:0']")
	WebElement exigeHorarioYes;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:checkExigeHorarioEmTurmas:1']")
	WebElement exigeHorarioNo;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:checkConteudoVariavel:0']")
	WebElement temaVariadoYes;
	@FindBy(how = How.XPATH, using = ".//*[@id='tableDadosGerais']/tbody/tr[3]/td/input")
	WebElement qtde;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:checkConteudoVariavel:1']")
	WebElement temaVariadoNo;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:checkImpedirOfertaTurma:0']")
	WebElement impedirOfertaYes;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:checkImpedirOfertaTurma:1']")
	WebElement impedirOfertaNo;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:checkDisciplinaEstagio:0']")
	WebElement estagioYes;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:checkDisciplinaEstagio:1']")
	WebElement estagioNo;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:checkPermiteTurmasConjugadas:0']")
	WebElement conjugadaYes;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:checkPermiteTurmasConjugadas:1']")
	WebElement conjugadaNo;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:checkPermiteTurmasAnuais:0']")
	WebElement turmaAnualYes;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:checkPermiteTurmasAnuais:1']")
	WebElement turmaAnualNo;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:ementa']")
	WebElement ementa;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:preReq']")
	WebElement preReq;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:coReq']")
	WebElement coReq;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:equivalencia']")
	WebElement equivalencia;
	@FindBy(how = How.XPATH, using = ".//*[@id='tableDadosGerais']/tbody/tr[1]/td/input")
	WebElement reqNc;
	@FindBy(how = How.XPATH, using = ".//*[@id='tableDadosGerais']/tbody/tr[2]/td/input")
	WebElement reqNeOpt;
	@FindBy(how = How.XPATH, using = ".//*[@id='tableDadosGerais']/tbody/tr[3]/td/input")
	WebElement reqNeObr;
	@FindBy(how = How.XPATH, using = ".//*[@id='tableDadosGerais']/tbody/tr[4]/td/input")
	WebElement reqNl;
	@FindBy(how = How.XPATH, using = ".//*[@id='form:avancar']")
	WebElement next;

	public DadosComponente(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Seleciona a unidade por seu value do elemento, gera o código
	// automaticamente e preenche o nome do componente
	public void selectUnidade(String value, String name) throws InterruptedException {
		new Select(unidade).selectByValue(value);
		Thread.sleep(2000);
		gerarCodigo.click();
		nome.sendKeys(name);
	}

	//Seta a carga horária do componente
	public void setCargaHoraria(String teorica, String pratica, String ead, String pcc) {
		chTeorica.clear();
		chTeorica.sendKeys(teorica);
		chPratica.clear();
		chPCC.sendKeys(pratica);
		chEad.clear();
		chEad.sendKeys(ead);
		chPCC.clear();
		chPCC.sendKeys(pcc);
	}

	public void setMatriculaOnline(String b) {
		if (b.equalsIgnoreCase("sim")) {
			matriculavelOnlineYes.click();
		} else
			matriculavelOnlineNo.click();
	}
	
	public void setChCompartilhada(String b){
		if (b.equalsIgnoreCase("sim")){
			permiteCompartilhadaYes.click();
		} else
			permiteCompartilhadaNo.click();
	}

	public void setFlexibilidadeHorario(String b){
		if (b.contentEquals("sim")){
			flexivelYes.click();
		} else
			flexivelNo.click();
	}
	
	public void setEmenda(String texto){
		ementa.sendKeys(texto);
	}
	
	public void goNext(){
		next.click();
	}
	
}
