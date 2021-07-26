
package br.ufsc.bridge.cursojunit.validation;

import org.junit.Assert;
import org.junit.Test;

public class CpfValidatorTest {

	@Test
	public void verificaSeCpfMaiorQue11EhInvalido() {
		// Descrição dos passos
		String cpf = "012345678902";

		// Descrição das ações
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assert
		Assert.assertFalse(isValid);
	}

	@Test
	public void verificaSeCpfMenorQue11EhInvalido() {
		// Descrição dos passos
		String cpf = "0123456789";

		// Descrição das ações
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assert
		Assert.assertFalse(isValid);
	}

	@Test
	public void verificaSeCpfVazioEhInvalido() {
		// Descrição dos passos
		String cpf = "";

		// Descrição das ações
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assert
		Assert.assertFalse(isValid);
	}

	@Test
	public void verificaSeCpfEmBrancoEhInvalido() {
		// Descrição dos passos
		String cpf = "           ";

		// Descrição das ações
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assert
		Assert.assertFalse(isValid);
	}

	@Test
	public void verificaSeCpfNuloEhInvalido() {
		// Descrição dos passos
		String cpf = null;

		// Descrição das ações
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assert
		Assert.assertFalse(isValid);
	}

	@Test
	public void verificaSeCpfComLetrasEhInvalido() {
		// Descrição dos passos
		String cpf = "A123456789A";

		// Descrição das ações
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assert
		Assert.assertFalse(isValid);
	}

	@Test
	public void verificaSeCpfComSimbolosEhInvalido() {
		// Descrição dos passos
		String cpf = "0123@56789@";

		// Descrição das ações
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assert
		Assert.assertFalse(isValid);
	}

	@Test
	public void verificaSeCpfComNumerosErradosEhInvalido() {
		// Descrição dos passos
		String cpf = "01234567891";

		// Descrição das ações
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assert
		Assert.assertFalse(isValid);
	}
}
