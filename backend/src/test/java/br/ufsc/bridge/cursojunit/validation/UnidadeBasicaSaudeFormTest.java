package br.ufsc.bridge.cursojunit.validation;

import org.junit.Assert;
import org.junit.Test;

import br.ufsc.bridge.cursojunit.model.form.UnidadeBasicaSaudeForm;
import br.ufsc.bridge.cursojunit.utils.ErrosEnum;
import br.ufsc.bridge.cursojunit.utils.FormError;

public class UnidadeBasicaSaudeFormTest {

	@Test
	public void verificaSeUBSComNomeRealEhValida() {

		UnidadeBasicaSaudeForm ubs = new UnidadeBasicaSaudeForm();
		ubs.setNomeUbs("Centro de Saúde Trindade");
		FormError erros = new FormError();

		UnidadeBasicaSaudeValidator.validate(ubs, erros);
		int length = erros.getErrorList().size();
		Assert.assertEquals(0, length);
	}

	@Test
	public void verificaSeUBSComNomeVazioEhVInvalida() {

		UnidadeBasicaSaudeForm ubs = new UnidadeBasicaSaudeForm();
		ubs.setNomeUbs("");
		FormError erros = new FormError();

		UnidadeBasicaSaudeValidator.validate(ubs, erros);

		String atual = erros.getErrorList().get(0);
		String esperado = "Erro do tipo " + ErrosEnum.REQUIRED + " no campo nome ubs";
		Assert.assertEquals(esperado, atual);
	}

	@Test
	public void verificaSeUBSComNomeMaiorQue70CaractersEhValida() {

		UnidadeBasicaSaudeForm ubs = new UnidadeBasicaSaudeForm();
		ubs.setNomeUbs("Nome Unidade de Saude Invalido Com mais de Setenta Carcteres Teste Test");
		FormError erros = new FormError();

		UnidadeBasicaSaudeValidator.validate(ubs, erros);

		String atual = erros.getErrorList().get(0);
		String esperado = "Erro do tipo " + ErrosEnum.MALFORMED + " no campo nome ubs";
		Assert.assertEquals(esperado, atual);
	}

	@Test
	public void verificaSeUBSComNumerosNoNomeEhInvalida() {

		UnidadeBasicaSaudeForm ubs = new UnidadeBasicaSaudeForm();
		ubs.setNomeUbs("Nome Unidade de Saude 2021");
		FormError erros = new FormError();

		UnidadeBasicaSaudeValidator.validate(ubs, erros);

		String atual = erros.getErrorList().get(0);
		String esperado = "Erro do tipo " + ErrosEnum.MALFORMED + " no campo nome ubs";
		Assert.assertEquals(esperado, atual);
	}

	@Test
	public void verificaSeUBSComSimbolosNoNomeEhInvalida() {

		UnidadeBasicaSaudeForm ubs = new UnidadeBasicaSaudeForm();
		ubs.setNomeUbs("Nome Unidade de Saude #VACINA");
		FormError erros = new FormError();

		UnidadeBasicaSaudeValidator.validate(ubs, erros);

		String atual = erros.getErrorList().get(0);
		String esperado = "Erro do tipo " + ErrosEnum.MALFORMED + " no campo nome ubs";
		Assert.assertEquals(esperado, atual);
	}

}
