package br.ufsc.bridge.cursojunit.validation;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.bridge.cursojunit.model.form.ProfissionalForm;
import br.ufsc.bridge.cursojunit.utils.ProfissionalDataFactory;

public class ProfissionalFormValidatorTest {

	private ProfissionalForm form;

	@Before
	public void setup() {
		this.form = ProfissionalDataFactory.createFullProfissional();
	}

	@Test
	public void testeNome() {
		this.form.setNomeProfissional("Sobrescrevo");
		// validador

		// assert
	}

	@Test
	public void teste2() {
		this.form.setNomeProfissional("outro nome");
		// validador

		// assert
	}

	@Test
	public void teste3() {
		this.form.setCnsProfissional("outro cns");
		// validador

		// assert
	}

	@Test
	public void teste4() {
		this.form.setCnsProfissional("outro cns");
		// validator
		// assert
	}

	@Test
	public void teste5() {
		this.form.setTelefoneProfissional("outro cns");
		// validator
		// assert
	}

}
