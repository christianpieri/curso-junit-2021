package br.ufsc.bridge.cursojunit.validation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ufsc.bridge.cursojunit.model.form.UnidadeBasicaSaudeForm;
import br.ufsc.bridge.cursojunit.utils.FormError;

public class UnidadeBasicaSaudeValidatorTest {

	private FormError erros;
	private UnidadeBasicaSaudeForm formUbs;

	@Before
	public void setup() {
		this.erros = new FormError();
		this.formUbs = new UnidadeBasicaSaudeForm();
	}

	@Test
	public void assegureQueNomeRealDeUnidadeDeSaudeSejaValido() {

		// Descricao dos passos
		this.formUbs.setNomeUbs("UBS Trindade");

		// Descricao das acoes
		UnidadeBasicaSaudeValidator.validate(this.formUbs, this.erros);
		int size = this.erros.getErrorList().size();

		// Assegure que
		Assert.assertEquals(0, size);
	}

	@Test
	public void assegureQueNomeDeUbsNaoPossaSerUmaStringVazia() {

		// Descricao dos passos
		this.formUbs.setNomeUbs("");

		// Descricao das acoes
		UnidadeBasicaSaudeValidator.validate(this.formUbs, this.erros);
		int size = this.erros.getErrorList().size();

		// Assegure que
		Assert.assertEquals(1, size);
	}

	@Test
	public void assegureQueNomeDeUbsNaoPossaSerNulo() {

		// Descricao dos passos
		this.formUbs.setNomeUbs(null);

		// Descricao das acoes
		UnidadeBasicaSaudeValidator.validate(this.formUbs, this.erros);
		int size = this.erros.getErrorList().size();

		// Assegure que
		Assert.assertEquals(1, size);
	}

	@Test
	public void assegureQueNomeDeUbsNaoPossaSerCaracteresEmBranco() {

		// Descricao dos passos
		this.formUbs.setNomeUbs("   ");

		// Descricao das acoes
		UnidadeBasicaSaudeValidator.validate(this.formUbs, this.erros);
		int size = this.erros.getErrorList().size();

		// Assegure que
		Assert.assertEquals(1, size);
	}

}
