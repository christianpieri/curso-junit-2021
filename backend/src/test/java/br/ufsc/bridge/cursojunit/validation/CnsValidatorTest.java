package br.ufsc.bridge.cursojunit.validation;

import org.junit.Assert;
import org.junit.Test;

public class CnsValidatorTest {

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

}
