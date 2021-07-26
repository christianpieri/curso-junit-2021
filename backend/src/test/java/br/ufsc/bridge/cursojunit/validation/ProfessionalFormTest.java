package br.ufsc.bridge.cursojunit.validation;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ufsc.bridge.cursojunit.model.form.ProfissionalForm;
import br.ufsc.bridge.cursojunit.utils.ErrosEnum;
import br.ufsc.bridge.cursojunit.utils.FormError;
import br.ufsc.bridge.cursojunit.utils.SexoEnum;
import br.ufsc.bridge.cursojunit.utils.UbsDataFactory;

public class ProfessionalFormTest {

	public ProfissionalForm form;

	@Before
	public void setup() {
		form = new ProfissionalForm();
		form.setCnsProfissional("211641718920000");
		form.setCpfProfissional("01234567890");
		form.setDtNascProfissional(LocalDate.now().withYear(1990));
		form.setNomeProfissional("Nome Aceitável");
		form.setSexoProfissional(SexoEnum.FEMININO);
		form.setTelefoneProfissional("48999999998");
		form.setUbsReferencia(UbsDataFactory.createFullUbs());
	}

	// Testes de validação do CNS

	@Test
	public void verificaSeProfissionalComCnsVazioEhInvalido() {
		form.setCnsProfissional("");
		FormError erros = new FormError();

		ProfissionalFormValidator.validate(form, erros);

		String atual = erros.getErrorList().get(0);
		String esperado = "Erro do tipo " + ErrosEnum.REQUIRED + " no campo cns profissional";
		Assert.assertEquals(esperado, atual);
	}

	@Test
	public void verificaSeProfissionalComCnsEmBrancoEhInvalido() {
		form.setCnsProfissional("               ");
		FormError erros = new FormError();

		ProfissionalFormValidator.validate(form, erros);

		String atual = erros.getErrorList().get(0);
		String esperado = "Erro do tipo " + ErrosEnum.REQUIRED + " no campo cns profissional";
		Assert.assertEquals(esperado, atual);
	}

	@Test
	public void verificaSeProfissionalComCnsNuloEhInvalido() {
		form.setCnsProfissional(null);
		FormError erros = new FormError();

		ProfissionalFormValidator.validate(form, erros);

		String atual = erros.getErrorList().get(0);
		String esperado = "Erro do tipo " + ErrosEnum.REQUIRED + " no campo cns profissional";
		Assert.assertEquals(esperado, atual);
	}

	@Test
	public void verificaSeProfissionalComCnsContendoCaracteresEspeciaisEhInvalido() {
		form.setCnsProfissional("211@41718920000");
		FormError erros = new FormError();

		ProfissionalFormValidator.validate(form, erros);

		String atual = erros.getErrorList().get(0);
		String esperado = "Erro do tipo " + ErrosEnum.MALFORMED + " no campo cns profissional";
		Assert.assertEquals(esperado, atual);
	}

	@Test
	public void verificaSeProfissionalComCnsContendoLetrasEhInvalido() {
		form.setCnsProfissional("211A41718920000");
		FormError erros = new FormError();

		ProfissionalFormValidator.validate(form, erros);

		String atual = erros.getErrorList().get(0);
		String esperado = "Erro do tipo " + ErrosEnum.MALFORMED + " no campo cns profissional";
		Assert.assertEquals(esperado, atual);
	}

	@Test
	public void verificaSeProfissionalComCnsMaiorQue15CaracteresEhInvalido() {
		form.setCnsProfissional("2116417189200000");
		FormError erros = new FormError();

		ProfissionalFormValidator.validate(form, erros);

		String atual = erros.getErrorList().get(0);
		String esperado = "Erro do tipo " + ErrosEnum.MALFORMED + " no campo cns profissional";
		Assert.assertEquals(esperado, atual);
	}

	@Test
	public void verificaSeProfissionalComCnsMenorQue15CaracteresEhInvalido() {
		form.setCnsProfissional("21164171892000");
		FormError erros = new FormError();

		ProfissionalFormValidator.validate(form, erros);

		String atual = erros.getErrorList().get(0);
		String esperado = "Erro do tipo " + ErrosEnum.MALFORMED + " no campo cns profissional";
		Assert.assertEquals(esperado, atual);
	}

	// Testes de validacao do CPF

	@Test
	public void verificaSeProfissionalComCpfVazioEhInvalido() {
		form.setCpfProfissional("");
		FormError erros = new FormError();

		ProfissionalFormValidator.validate(form, erros);

		String atual = erros.getErrorList().get(0);
		String esperado = "Erro do tipo " + ErrosEnum.REQUIRED + " no campo cpf profissional";
		Assert.assertEquals(esperado, atual);
	}

	@Test
	public void verificaSeProfissionalComCpfEmBrancoEhInvalido() {
		form.setCpfProfissional("           ");
		FormError erros = new FormError();

		ProfissionalFormValidator.validate(form, erros);

		String atual = erros.getErrorList().get(0);
		String esperado = "Erro do tipo " + ErrosEnum.REQUIRED + " no campo cpf profissional";
		Assert.assertEquals(esperado, atual);
	}

	@Test
	public void verificaSeProfissionalComCpfNuloEhInvalido() {
		form.setCpfProfissional(null);
		FormError erros = new FormError();

		ProfissionalFormValidator.validate(form, erros);

		String atual = erros.getErrorList().get(0);
		String esperado = "Erro do tipo " + ErrosEnum.REQUIRED + " no campo cpf profissional";
		Assert.assertEquals(esperado, atual);
	}

	@Test
	public void verificaSeProfissionalComCpfContendoCaracteresEspeciaisEhInvalido() {
		form.setCpfProfissional("01@34567890");
		FormError erros = new FormError();

		ProfissionalFormValidator.validate(form, erros);

		String atual = erros.getErrorList().get(0);
		String esperado = "Erro do tipo " + ErrosEnum.MALFORMED + " no campo cpf profissional";
		Assert.assertEquals(esperado, atual);
	}

	@Test
	public void verificaSeProfissionalComCpfContendoLetrasEhInvalido() {
		form.setCpfProfissional("01A3456789");
		FormError erros = new FormError();

		ProfissionalFormValidator.validate(form, erros);

		String atual = erros.getErrorList().get(0);
		String esperado = "Erro do tipo " + ErrosEnum.MALFORMED + " no campo cpf profissional";
		Assert.assertEquals(esperado, atual);
	}

	@Test
	public void verificaSeProfissionalComCpfMaiorQue11CaracteresEhInvalido() {
		form.setCpfProfissional("012345678901");
		FormError erros = new FormError();

		ProfissionalFormValidator.validate(form, erros);

		String atual = erros.getErrorList().get(0);
		String esperado = "Erro do tipo " + ErrosEnum.MALFORMED + " no campo cpf profissional";
		Assert.assertEquals(esperado, atual);
	}

	@Test
	public void verificaSeProfissionalComCnsMenorQue11CaracteresEhInvalido() {
		form.setCpfProfissional("0123456789");
		FormError erros = new FormError();

		ProfissionalFormValidator.validate(form, erros);

		String atual = erros.getErrorList().get(0);
		String esperado = "Erro do tipo " + ErrosEnum.MALFORMED + " no campo cpf profissional";
		Assert.assertEquals(esperado, atual);
	}

	// Testes Sexo

	@Test
	public void verificaSeProfissionalComSexoNuloEhInvalido() {
		form.setSexoProfissional(null);
		FormError erros = new FormError();

		ProfissionalFormValidator.validate(form, erros);

		String atual = erros.getErrorList().get(0);
		String esperado = "Erro do tipo " + ErrosEnum.REQUIRED + " no campo sexo profissional";
		Assert.assertEquals(esperado, atual);
	}

	// Testes Nome
	@Test
	public void verificaSeProfissionalComNomeVazioEhInvalido() {
		form.setNomeProfissional("");
		FormError erros = new FormError();

		ProfissionalFormValidator.validate(form, erros);

		String atual = erros.getErrorList().get(0);
		String esperado = "Erro do tipo " + ErrosEnum.REQUIRED + " no campo nome profissional";
		Assert.assertEquals(esperado, atual);
	}

	@Test
	public void verificaSeProfissionalComNomeEmBrancoEhInvalido() {
		form.setNomeProfissional("               ");
		FormError erros = new FormError();

		ProfissionalFormValidator.validate(form, erros);

		String atual = erros.getErrorList().get(0);
		String esperado = "Erro do tipo " + ErrosEnum.REQUIRED + " no campo nome profissional";
		Assert.assertEquals(esperado, atual);
	}

	@Test
	public void verificaSeProfissionalComNomeEmNuloEhInvalido() {
		form.setNomeProfissional(null);
		FormError erros = new FormError();

		ProfissionalFormValidator.validate(form, erros);

		String atual = erros.getErrorList().get(0);
		String esperado = "Erro do tipo " + ErrosEnum.REQUIRED + " no campo nome profissional";
		Assert.assertEquals(esperado, atual);
	}

	@Test
	public void verificaSeProfissionalComNumerosNoNomeEhInvalido() {
		form.setNomeProfissional("Jorge Souza 3");
		FormError erros = new FormError();

		ProfissionalFormValidator.validate(form, erros);

		String atual = erros.getErrorList().get(0);
		String esperado = "Erro do tipo " + ErrosEnum.MALFORMED + " no campo nome profissional";
		Assert.assertEquals(esperado, atual);
	}

	@Test
	public void verificaSeProfissionalComCaracteresEspeciaisNoNomeEhInvalido() {
		form.setNomeProfissional("Jorge Souza!");
		FormError erros = new FormError();

		ProfissionalFormValidator.validate(form, erros);

		String atual = erros.getErrorList().get(0);
		String esperado = "Erro do tipo " + ErrosEnum.MALFORMED + " no campo nome profissional";
		Assert.assertEquals(esperado, atual);
	}

	@Test
	public void verificaSeProfissionalComNomeMaiorQue70CaracteresEhInvalido() {
		form.setNomeProfissional("Pedro de Alcântara João  Xavier de Rafael Gonzaga de Bragança e Bourbon");
		FormError erros = new FormError();

		ProfissionalFormValidator.validate(form, erros);

		String atual = erros.getErrorList().get(0);
		String esperado = "Erro do tipo " + ErrosEnum.MALFORMED + " no campo nome profissional";
		Assert.assertEquals(esperado, atual);
	}


	// Testes UBS do Profissional
	Test
	public void verificaSeProfissionalComUBSNuloEhInvalido() {
		form.setNomeProfissional("");
		FormError erros = new FormError();

		ProfissionalFormValidator.validate(form, erros);

		String atual = erros.getErrorList().get(0);
		String esperado = "Erro do tipo " + ErrosEnum.REQUIRED + " no campo nome profissional";
		Assert.assertEquals(esperado, atual);
	}



	// TODO DATA
	// TODO TELEFONE

}