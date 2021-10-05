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
	public void assegureQueNomeNuloEhInvalido() {

		// Descricao passos

		this.formUbs.setNomeUbs(null);

		// Descricoes de acoes
		UnidadeBasicaSaudeValidator.validate(this.formUbs, this.erros);
		int size = this.erros.getErrorList().size();

		// Assegure que
		Assert.assertEquals(1, size);
	}

	@Test
	public void assegureQueNomeComNumeroEhInvalido() {

		// Descricao passos

		this.formUbs.setNomeUbs("1231232131");

		// Descricoes de acoes
		UnidadeBasicaSaudeValidator.validate(this.formUbs, this.erros);
		int size = this.erros.getErrorList().size();

		// Assegure que
		Assert.assertEquals(1, size);
	}

	@Test
	public void assegureQueNomeComCaracteresEspeciaisEhInvalido() {

		// Descricao passos

		this.formUbs.setNomeUbs("!@#!@#!@#");

		// Descricoes de acoes
		UnidadeBasicaSaudeValidator.validate(this.formUbs, this.erros);
		int size = this.erros.getErrorList().size();

		// Assegure que
		Assert.assertEquals(1, size);
	}

	@Test
	public void assegureQueNomeVazioEhInvalido() {

		// Descricao passos

		this.formUbs.setNomeUbs("");

		// Descricoes de acoes
		UnidadeBasicaSaudeValidator.validate(this.formUbs, this.erros);
		int size = this.erros.getErrorList().size();

		// Assegure que
		Assert.assertEquals(1, size);
	}

	@Test
	public void assegureQueNomeApenasComEspacoEhInvalido() {

		// Descricao passos

		this.formUbs.setNomeUbs("   ");

		// Descricoes de acoes
		UnidadeBasicaSaudeValidator.validate(this.formUbs, this.erros);
		int size = this.erros.getErrorList().size();

		// Assegure que
		Assert.assertEquals(1, size);
	}

	@Test
	public void assegureQueNomeComTamanho70EhValido() {

		// Descricao passos

		this.formUbs.setNomeUbs("abcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcde");

		// Descricoes de acoes
		UnidadeBasicaSaudeValidator.validate(this.formUbs, this.erros);
		int size = this.erros.getErrorList().size();

		// Assegure que
		Assert.assertEquals(0, size);
	}

	@Test
	public void assegureQueNomeComTamanho71EhInvalido() {

		// Descricao passos

		this.formUbs.setNomeUbs("abcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdee");

		// Descricoes de acoes
		UnidadeBasicaSaudeValidator.validate(this.formUbs, this.erros);
		int size = this.erros.getErrorList().size();

		// Assegure que
		Assert.assertEquals(1, size);
	}
}
