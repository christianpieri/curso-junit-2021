package br.ufsc.bridge.cursojunit.validation;

import org.junit.Assert;
import org.junit.Test;

import br.ufsc.bridge.cursojunit.model.form.UnidadeBasicaSaudeForm;
import br.ufsc.bridge.cursojunit.utils.FormError;

public class UnidadeBasicaSaudeValidatorTest {

	@Test
	public void assegureQueNomeIdealDeSaudeSejaValido() {

		// Descricao passos
		FormError erros = new FormError();
		UnidadeBasicaSaudeForm formUbs = new UnidadeBasicaSaudeForm();
		formUbs.setNomeUbs("UBS Trindade");

		// Descricoes de acoes
		UnidadeBasicaSaudeValidator.validate(formUbs, erros);
		int size = erros.getErrorList().size();

		// Assegure que
		Assert.assertEquals(size, 0);
	}
}
