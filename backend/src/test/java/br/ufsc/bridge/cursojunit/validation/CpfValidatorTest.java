package br.ufsc.bridge.cursojunit.validation;

import org.junit.Assert;
import org.junit.Test;

public class CpfValidatorTest {

	public void testaTudo() {
		this.assegureQueCpfComCaracteresEspeciaisSejaInvalido();
		this.assegureQueCpfComEspaçosSejaInvalido();
		this.assegureQueCpfComExatamente10SejaInvalido();
		this.assegureQueCpfComExatamente12SejaInvalido();
		this.assegureQueCpfComLetrasSejaInvalido();
		this.assegureQueCpfComValorCorretoEComCaracteresEspeciaisSejaInvalido();
		this.assegureQueCpfComValorDeCalculoDoCpfErradoSejaInvalido();
		this.assegureQueCpfCorretoSejaValido();
		this.assegureQueCpfNuloSejaInvalido();
		this.assegureQueCpfNumerosIguaisSejaInvalido();
		this.assegureQueCpfVazioSejaInvalido();
	}

	// testes cpf validator
	@Test
	public void assegureQueCpfComExatamente12SejaInvalido() {

		// Descricoes dos passos
		String cpf = "012345678901";

		// Descricoes das acoes
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assegure que
		Assert.assertFalse(isValid);
	}

	@Test
	public void assegureQueCpfComExatamente10SejaInvalido() {

		// Descricoes dos passos
		String cpf = "0123456789";

		// Descricoes das acoes
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assegure que
		Assert.assertFalse(isValid);
	}

	@Test
	public void assegureQueCpfNuloSejaInvalido() {

		// Descricoes dos passos
		String cpf = null;

		// Descricoes das acoes
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assegure que
		Assert.assertFalse(isValid);
	}

	@Test
	public void assegureQueCpfComEspaçosSejaInvalido() {

		// Descricoes dos passos
		String cpf = "           ";

		// Descricoes das acoes
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assegure que
		Assert.assertFalse(isValid);
	}

	@Test
	public void assegureQueCpfComLetrasSejaInvalido() {

		// Descricoes dos passos
		String cpf = "Davi";

		// Descricoes das acoes
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assegure que
		Assert.assertFalse(isValid);
	}

	@Test
	public void assegureQueCpfComCaracteresEspeciaisSejaInvalido() {

		// Descricoes dos passos
		String cpf = "//.._______";

		// Descricoes das acoes
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assegure que
		Assert.assertFalse(isValid);
	}

	@Test
	public void assegureQueCpfNumerosIguaisSejaInvalido() {

		// Descricoes dos passos
		String cpf = "11111111111";

		// Descricoes das acoes
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assegure que
		Assert.assertFalse(isValid);
	}

	@Test
	public void assegureQueCpfComValorCorretoEComCaracteresEspeciaisSejaInvalido() {

		// Descricoes dos passos
		String cpf = "085.068.009-35";

		// Descricoes das acoes
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assegure que
		Assert.assertFalse(isValid);
	}

	@Test
	public void assegureQueCpfVazioSejaInvalido() {

		// Descricoes dos passos
		String cpf = "";

		// Descricoes das acoes
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assegure que
		Assert.assertFalse(isValid);
	}

	@Test
	public void assegureQueCpfComValorDeCalculoDoCpfErradoSejaInvalido() {

		// Descricoes dos passos
		String cpf = "12345678912";

		// Descricoes das acoes
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assegure que
		Assert.assertFalse(isValid);
	}

	@Test
	public void assegureQueCpfCorretoSejaValido() {

		// Descricoes dos passos
		String cpf = "08506800935";

		// Descricoes das acoes
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assegure que
		Assert.assertTrue(isValid);
	}
}
