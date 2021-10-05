package br.ufsc.bridge.cursojunit.validation;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ufsc.bridge.cursojunit.model.form.ProfissionalForm;
import br.ufsc.bridge.cursojunit.model.form.UnidadeBasicaSaudeForm;
import br.ufsc.bridge.cursojunit.utils.FormError;
import br.ufsc.bridge.cursojunit.utils.ProfissionalDataFactory;

public class ProfissionalFormValidatorTest {

	private ProfissionalForm form;
	private FormError erros;
	private UnidadeBasicaSaudeForm formUbs;
	private LocalDate localDate;

	@Before
	public void setup() {
		this.form = ProfissionalDataFactory.createFullProfissional();
		this.erros = new FormError();
	}

	@Test
	public void verificaSeOCampodeNomeEhObrigatorio() {

		// Descricoes dos passos
		this.form.setNomeProfissional(null);

		// Descricoes das acoes
		ProfissionalFormValidator.validate(this.form, this.erros);

		// Assegure que
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeOCampodeSexoEhObrigatorio() {

		// Descricoes dos passos
		this.form.setSexoProfissional(null);

		// Descricoes das acoess
		ProfissionalFormValidator.validate(this.form, this.erros);

		// Assegure que
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeOCampodeDataNascEhObrigatorio() {

		// Descricoes dos passos
		this.form.setDtNascProfissional(null);

		// Descricoes das acoes
		ProfissionalFormValidator.validate(this.form, this.erros);

		// Assegure que
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void fazAVerificacaoDoCpf() {

		// Descricoes dos passos
		CpfValidatorTest test = new CpfValidatorTest();
		test.testaTudo();

	}

	@Test
	public void fazAVerificacaoDoCns() {

		// Descricoes dos passos
		CnsValidatorTest test = new CnsValidatorTest();
		test.testaTudo();

	}

	@Test
	public void verificaSeUbsReferenciaNuloEhInvalido() {

		// Descricoes dos passos
		this.form.setUbsReferencia(null);

		// Descricoes das acoes
		ProfissionalFormValidator.validate(this.form, this.erros);

		// Assegure que
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeUbsReferenciaComNomeDiferenteEhInvalido() {

		// Descricoes dos passos
		this.formUbs = new UnidadeBasicaSaudeForm();
		this.formUbs.setNomeUbs("Floripa");
		this.form.setUbsReferencia(this.formUbs);

		// Descricoes das acoes
		ProfissionalFormValidator.validate(this.form, this.erros);

		// Assegure que
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeUbsReferenciaSemNadaEhInvalido() {

		// Descricoes dos passos
		this.formUbs = new UnidadeBasicaSaudeForm();
		this.formUbs.setNomeUbs("");
		this.form.setUbsReferencia(this.formUbs);

		// Descricoes das acoes
		ProfissionalFormValidator.validate(this.form, this.erros);

		// Assegure que
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeADataNascNulaEhInvalido() {

		// Descricoes dos passos
		this.form.setDtNascProfissional(null);

		// Descricoes das acoes
		ProfissionalFormValidator.validate(this.form, this.erros);

		// Assegure que
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeADataNascAntesEhInvalido() {

		// Descricoes dos passos
		this.form.setDtNascProfissional(this.localDate = LocalDate.parse("2000-09-29"));

		// Descricoes das acoes
		ProfissionalFormValidator.validate(this.form, this.erros);

		// Assegure que
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeADataNascDepoisEhValido() {

		// Descricoes dos passos
		this.form.setDtNascProfissional(this.localDate = LocalDate.parse("2022-09-29"));

		// Descricoes das acoes
		ProfissionalFormValidator.validate(this.form, this.erros);

		// Assegure que
		Assert.assertEquals(0, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeONumeroMaxDeCaracteresDoNomeCom71EhInvalido() {

		// Descricoes dos passos
		this.form.setNomeProfissional("abcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdea");

		// Descricoes das acoes
		ProfissionalFormValidator.validate(this.form, this.erros);

		// Assegure que
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeONumeroMaxDeCaracteresDoNomeCom70EhValido() {

		// Descricoes dos passos
		this.form.setNomeProfissional("abcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcde");

		// Descricoes das acoes
		ProfissionalFormValidator.validate(this.form, this.erros);

		// Assegure que
		Assert.assertEquals(0, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeONomeComNumeroEhInvalido() {

		// Descricoes dos passos
		this.form.setNomeProfissional("1234567890123");

		// Descricoes das acoes
		ProfissionalFormValidator.validate(this.form, this.erros);

		// Assegure que
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeONomeComCaracteresEspeciaisEhInvalido() {

		// Descricoes dos passos
		this.form.setNomeProfissional("...@@!#!@#!@#!@#");

		// Descricoes das acoes
		ProfissionalFormValidator.validate(this.form, this.erros);

		// Assegure que
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeNumeroDeTelefoneVazioEhInvalido() {

		// Descricoes dos passos
		this.form.setTelefoneProfissional("");

		// Descricoes das acoes
		ProfissionalFormValidator.validate(this.form, this.erros);

		// Assegure que
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeNumeroDeTelefoneComEspaçoEhInvalido() {

		// Descricoes dos passos
		this.form.setTelefoneProfissional("  ");

		// Descricoes das acoes
		ProfissionalFormValidator.validate(this.form, this.erros);

		// Assegure que
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeNumeroDeTelefoneSemDDDEhInvalido() {

		// Descricoes dos passos
		this.form.setTelefoneProfissional("991072375");

		// Descricoes das acoes
		ProfissionalFormValidator.validate(this.form, this.erros);

		// Assegure que
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeNumeroDeTelefoneComDDDErradoEhInvalido() {

		// Descricoes dos passos
		this.form.setTelefoneProfissional("111991072375");

		// Descricoes das acoes
		ProfissionalFormValidator.validate(this.form, this.erros);

		// Assegure que
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeNumeroDeTelefoneComCaracteresEspeciaisEhInvalido() {

		// Descricoes dos passos
		this.form.setTelefoneProfissional("111991072375");

		// Descricoes das acoes
		ProfissionalFormValidator.validate(this.form, this.erros);

		// Assegure que
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeNumeroDeTelefoneCom7NumerosEhInvalido() {

		// Descricoes dos passos
		this.form.setTelefoneProfissional("0481072375");

		// Descricoes das acoes
		ProfissionalFormValidator.validate(this.form, this.erros);

		// Assegure que
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeOFormularioCorretoEhValido() {

		// Descricoes das acoes
		ProfissionalFormValidator.validate(this.form, this.erros);

		// Assegure que
		Assert.assertEquals(0, this.erros.getErrorList().size());

	}

}
