package br.ufsc.bridge.cursojunit.validation;

import org.junit.Assert;
import org.junit.Test;

public class CnsValidatorTest {

	@Test
	public void verificaSeCnsMaiorQue15EhInvalido() {
		// Descrição dos passos
		String Cns = "0123456789123456";

		// Descrição das ações
		boolean isValid = CnsValidator.isValid(Cns);

		// Assert
		Assert.assertFalse(isValid);
	}

	@Test
	public void verificaSeCnsMenorQue15EhInvalido() {
		// Descrição dos passos
		String Cns = "01234567891234";

		// Descrição das ações
		boolean isValid = CnsValidator.isValid(Cns);

		// Assert
		Assert.assertFalse(isValid);
	}

	@Test
	public void verificaSeCnsVazioEhInvalido() {
		// Descrição dos passos
		String Cns = "";

		// Descrição das ações
		boolean isValid = CnsValidator.isValid(Cns);

		// Assert
		Assert.assertFalse(isValid);
	}

	@Test
	public void verificaSeCnsEmBrancoEhInvalido() {
		// Descrição dos passos
		String Cns = "           ";

		// Descrição das ações
		boolean isValid = CnsValidator.isValid(Cns);

		// Assert
		Assert.assertFalse(isValid);
	}

	@Test
	public void verificaSeCnsNuloEhInvalido() {
		// Descrição dos passos
		String Cns = null;

		// Descrição das ações
		boolean isValid = CnsValidator.isValid(Cns);

		// Assert
		Assert.assertFalse(isValid);
	}

	@Test
	public void verificaSeCnsComLetrasEhInvalido() {
		// Descrição dos passos
		String Cns = "A1234567891234A";

		// Descrição das ações
		boolean isValid = CnsValidator.isValid(Cns);

		// Assert
		Assert.assertFalse(isValid);
	}

	@Test
	public void verificaSeCnsComSimbolosEhInvalido() {
		// Descrição dos passos
		String Cns = "0123@567891234@";

		// Descrição das ações
		boolean isValid = CnsValidator.isValid(Cns);

		// Assert
		Assert.assertFalse(isValid);
	}

}
