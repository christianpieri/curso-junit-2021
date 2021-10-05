package br.ufsc.bridge.cursojunit.validation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CpfValidatorTest {

	@Before
	public void setup() {
		// faz algo antes de cada teste
	}

	@Test
	public void assegureQueCpfComExatamente12CaracteresSejaInvalido() {
		// Descricao dos passos
		String cpf = "012345678901";

		// Descricao das acoes
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assegure que
		Assert.assertFalse(isValid);
	}

	@Test
	public void asseguraQueCpfComExatamente10CaracteresSejaInvalido() {
		// Descricao dos passos
		String cpf = "0123456789";

		// Descricao das acoes
		boolean isValid = CpfValidator.isCPF(cpf);

		// Assegure que
		Assert.assertFalse(isValid);
	}

	@Test
	public void asseguraQueCpfComCaracteresEspeciaisSejaInvalido() {
		String cpf = "123@4567890";

		boolean isValid = CpfValidator.isCPF(cpf);

		Assert.assertFalse(isValid);
	}

	@Test
	public void assegureQueCpfComValorDeCalculoDeCpfSejaInvalido() {
		String cpf = "12345678912";

		boolean isValid = CpfValidator.isCPF(cpf);

		Assert.assertFalse(isValid);
	}

	@Test
	public void assegureQueCpfNaoCorrespondeAUmaStringVazia() {
		String cpf = "";

		boolean isValid = CpfValidator.isCPF(cpf);

		Assert.assertFalse(isValid);
	}

	@Test
	public void assegureQueCpfNuloSejaInvalido() {
		String cpf = null;

		boolean isValid = CpfValidator.isCPF(cpf);

		Assert.assertFalse(isValid);
	}

	@Test
	public void assegureQueCpfSejaValido() {
		String cpf = "01234567890";

		boolean isValid = CpfValidator.isCPF(cpf);

		Assert.assertTrue(isValid);
	}

	@Test
	public void verificaSeUtilizaSeparadoresComPontoEHifenCorretamente() {
		String cpf = "012.345.678-90";

		boolean isValid = CpfValidator.isCPF(cpf);

		Assert.assertFalse(isValid);
	}

	@Test
	public void testaSeOFormatadorDeCpfEstaFormatandoCorretamente() {
		String cpf = "01234567890";
		String cpfFormatadoEsperado = "012.345.678-90";

		String cpfFormatadoAtual = CpfValidator.formatCpf(cpf);

		Assert.assertEquals(cpfFormatadoEsperado, cpfFormatadoAtual);
	}

}
