package br.ufsc.bridge.cursojunit.validation;

import org.junit.Assert;
import org.junit.Test;

public class CpfValidatorTest {

	public static void testaTudo() {
		assegureQueCpfComCaracteresEspeciaisSejaInvalido();
		assegureQueCpfComEspaçosSejaInvalido();
		assegureQueCpfComExatamente10SejaInvalido();
		assegureQueCpfComExatamente12SejaInvalido();
		assegureQueCpfComLetrasSejaInvalido();
		assegureQueCpfComValorCorretoEComCaracteresEspeciaisSejaInvalido();
		assegureQueCpfComValorDeCalculoDoCpfErradoSejaInvalido();
		assegureQueCpfCorretoSejaValido();
		assegureQueCpfNuloSejaInvalido();
		assegureQueCpfNumerosIguaisSejaInvalido();
		assegureQueCpfVazioSejaInvalido();
	}

	// testes cpf validator
	@Test
	public static void assegureQueCpfComExatamente12SejaInvalido() {

		// Descricoes dos passos
		String cpf = "012345678901";

		// Descricoes das acoes
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assegure que
		Assert.assertFalse(isValid);
	}

	@Test
	public static void assegureQueCpfComExatamente10SejaInvalido() {

		// Descricoes dos passos
		String cpf = "0123456789";

		// Descricoes das acoes
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assegure que
		Assert.assertFalse(isValid);
	}

	@Test
	public static void assegureQueCpfNuloSejaInvalido() {

		// Descricoes dos passos
		String cpf = null;

		// Descricoes das acoes
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assegure que
		Assert.assertFalse(isValid);
	}

	@Test
	public static void assegureQueCpfComEspaçosSejaInvalido() {

		// Descricoes dos passos
		String cpf = "           ";

		// Descricoes das acoes
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assegure que
		Assert.assertFalse(isValid);
	}

	@Test
	public static void assegureQueCpfComLetrasSejaInvalido() {

		// Descricoes dos passos
		String cpf = "Davi";

		// Descricoes das acoes
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assegure que
		Assert.assertFalse(isValid);
	}

	@Test
	public static void assegureQueCpfComCaracteresEspeciaisSejaInvalido() {

		// Descricoes dos passos
		String cpf = "//.._______";

		// Descricoes das acoes
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assegure que
		Assert.assertFalse(isValid);
	}

	@Test
	public static void assegureQueCpfNumerosIguaisSejaInvalido() {

		// Descricoes dos passos
		String cpf = "11111111111";

		// Descricoes das acoes
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assegure que
		Assert.assertFalse(isValid);
	}

	@Test
	public static void assegureQueCpfComValorCorretoEComCaracteresEspeciaisSejaInvalido() {

		// Descricoes dos passos
		String cpf = "085.068.009-35";

		// Descricoes das acoes
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assegure que
		Assert.assertFalse(isValid);
	}

	@Test
	public static void assegureQueCpfVazioSejaInvalido() {

		// Descricoes dos passos
		String cpf = "";

		// Descricoes das acoes
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assegure que
		Assert.assertFalse(isValid);
	}

	@Test
	public static void assegureQueCpfComValorDeCalculoDoCpfErradoSejaInvalido() {

		// Descricoes dos passos
		String cpf = "12345678912";

		// Descricoes das acoes
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assegure que
		Assert.assertFalse(isValid);
	}

	@Test
	public static void assegureQueCpfCorretoSejaValido() {

		// Descricoes dos passos
		String cpf = "08506800935";

		// Descricoes das acoes
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assegure que
		Assert.assertTrue(isValid);
	}
}
