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
	public void verificaSeOCampodeCpfEhObrigatorio() {

		// passos
		this.form.setCpfProfissional(null);

		// validator
		ProfissionalFormValidator.validate(this.form, this.erros);

		// assegure
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeOCampodeCnsEhObrigatorio() {

		// passos
		this.form.setCnsProfissional(null);

		// validator
		ProfissionalFormValidator.validate(this.form, this.erros);

		// assegure
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeOCampodeNomeEhObrigatorio() {

		// passos
		this.form.setNomeProfissional(null);

		// validator
		ProfissionalFormValidator.validate(this.form, this.erros);

		// assegure
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	// Teste mostrou erro nas especificacoes
	@Test
	public void verificaSeOCampodeDataNascEhObrigatorio() {

		// passos
		this.form.setDtNascProfissional(null);

		// validator
		ProfissionalFormValidator.validate(this.form, this.erros);

		// assegure
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeOCpfComCampovazioEhValido() {

		// passos
		this.form.setCpfProfissional("");

		// validator
		ProfissionalFormValidator.validate(this.form, this.erros);

		// assegure
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeOCpfComNumerosIguaisEhValido() {

		// passos
		CpfValidatorTest.testaTudo();

	}

	// Fazer CNS

	@Test
	public void verificaSeUbsReferenciaNuloEhValido() {

		// passos
		this.form.setUbsReferencia(null);

		// validator
		ProfissionalFormValidator.validate(this.form, this.erros);

		// assegure
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeUbsReferenciaComNomeDiferenteEhValido() {

		// passos
		this.formUbs = new UnidadeBasicaSaudeForm();
		this.formUbs.setNomeUbs("Floripa");
		this.form.setUbsReferencia(this.formUbs);

		// validator
		ProfissionalFormValidator.validate(this.form, this.erros);

		// assegure
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeUbsReferenciaSemNadaEhValido() {

		// passos
		this.formUbs = new UnidadeBasicaSaudeForm();
		this.formUbs.setNomeUbs("");
		this.form.setUbsReferencia(this.formUbs);

		// validator
		ProfissionalFormValidator.validate(this.form, this.erros);

		// assegure
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeADataNascNulaEhValido() {

		// passos
		this.form.setDtNascProfissional(null);

		// validator
		ProfissionalFormValidator.validate(this.form, this.erros);

		// assegure
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeADataNascAgoraEhValido() {

		// passos
		this.form.setDtNascProfissional(this.localDate = LocalDate.parse("2000-09-29"));

		// validator
		ProfissionalFormValidator.validate(this.form, this.erros);

		// assegure
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeONumeroMaxDeCaracteresDoNomeCom71EhInvalido() {

		// passos
		this.form.setNomeProfissional("abcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdea");

		// validator
		ProfissionalFormValidator.validate(this.form, this.erros);

		// assegure
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeONumeroMaxDeCaracteresDoNomeCom70EhValido() {

		// passos
		this.form.setNomeProfissional("abcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcde");

		// validator
		ProfissionalFormValidator.validate(this.form, this.erros);

		// assegure
		Assert.assertEquals(0, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeONomeComNumeroEhInvalido() {

		// passos
		this.form.setNomeProfissional("1234567890123");

		// validator
		ProfissionalFormValidator.validate(this.form, this.erros);

		// assegure
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeONomeComCaracteresCEhInvalido() {

		// passos
		this.form.setNomeProfissional("...@@!#!@#!@#!@#");

		// validator
		ProfissionalFormValidator.validate(this.form, this.erros);

		// assegure
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeNumeroDeTelefoneVazioEhInvalido() {

		// passos
		this.form.setTelefoneProfissional("");

		// validator
		ProfissionalFormValidator.validate(this.form, this.erros);

		// assegure
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeNumeroDeTelefoneComEspaçoEhInvalido() {

		// passos
		this.form.setTelefoneProfissional("  ");

		// validator
		ProfissionalFormValidator.validate(this.form, this.erros);

		// assegure
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeNumeroDeTelefoneSemDDDEhInvalido() {

		// passos
		this.form.setTelefoneProfissional("991072375");

		// validator
		ProfissionalFormValidator.validate(this.form, this.erros);

		// assegure
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeNumeroDeTelefoneComDDDErradoEhInvalido() {

		// passos
		this.form.setTelefoneProfissional("111991072375");

		// validator
		ProfissionalFormValidator.validate(this.form, this.erros);

		// assegure
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

	@Test
	public void verificaSeNumeroDeTelefoneCom7NumerosEhInvalido() {

		// passos
		this.form.setTelefoneProfissional("0481072375");

		// validator
		ProfissionalFormValidator.validate(this.form, this.erros);

		// assegure
		Assert.assertEquals(1, this.erros.getErrorList().size());

	}

}
