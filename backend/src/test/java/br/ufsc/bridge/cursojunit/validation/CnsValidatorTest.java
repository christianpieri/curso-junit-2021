package br.ufsc.bridge.cursojunit.validation;

import org.junit.Assert;
import org.junit.Test;

public class CnsValidatorTest {

	public void testaTudo() {
		this.assegureQueCnsCom14EhInvalido();
		this.assegureQueCnsCom16EhInvalido();
		this.assegureQueCnsComCaracteresEspeciaisInvalido();
		this.assegureQueCnsComEspacoEhInvalido();
		this.assegureQueCnsNuloEhInvalido();
		this.assegureQueCnsSejaValido();
		this.assegureQueCnsVazioEhInvalido();
	}

	// Testes cns validator
	@Test
	public void assegureQueCnsSejaValido() {

		// Descricoes dos passos
		String cns = "888888888000000";

		// Descricoes das acoes
		boolean isValid = CnsValidator.isValid(cns);

		// Assegure que
		Assert.assertTrue(isValid);
	}

	@Test
	public void assegureQueCnsCom16EhInvalido() {

		// Descricoes dos passos
		String cns = "1888888888000000";

		// Descricoes das acoes
		boolean isValid = CnsValidator.isValid(cns);

		// Assegure que
		Assert.assertFalse(isValid);
	}

	@Test
	public void assegureQueCnsCom14EhInvalido() {

		// Descricoes dos passos
		String cns = "88888888000000";

		// Descricoes das acoes
		boolean isValid = CnsValidator.isValid(cns);

		// Assegure que
		Assert.assertFalse(isValid);
	}

	@Test
	public void assegureQueCnsNuloEhInvalido() {

		// Descricoes dos passos
		String cns = null;

		// Descricoes das acoes
		boolean isValid = CnsValidator.isValid(cns);

		// Assegure que
		Assert.assertFalse(isValid);
	}

	@Test
	public void assegureQueCnsVazioEhInvalido() {

		// Descricoes dos passos
		String cns = "";

		// Descricoes das acoes
		boolean isValid = CnsValidator.isValid(cns);

		// Assegure que
		Assert.assertFalse(isValid);
	}

	@Test
	public void assegureQueCnsComEspacoEhInvalido() {

		// Descricoes dos passos
		String cns = "  ";

		// Descricoes das acoes
		boolean isValid = CnsValidator.isValid(cns);

		// Assegure que
		Assert.assertFalse(isValid);
	}

	@Test
	public void assegureQueCnsComCaracteresEspeciaisInvalido() {

		// Descricoes dos passos
		String cns = "@@##$!@#!@#!@$";

		// Descricoes das acoes
		boolean isValid = CnsValidator.isValid(cns);

		// Assegure que
		Assert.assertFalse(isValid);
	}

}
