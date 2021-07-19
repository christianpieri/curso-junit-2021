package br.ufsc.bridge.cursojunit.validation;

public class CnsValidator {

	public static boolean isValid(String cns) {

		if (cns == null) {
			return false;
		}

		if (cns.matches("[1-2]\\d{10}00[0-1]\\d") || cns.matches("[7-9]\\d{14}")) {
			return somaPonderada(cns) % 11 == 0;
		}
		return false;
	}

	private static int somaPonderada(String cns) {
		char[] cs = cns.toCharArray();
		int soma = 0;
		for (int i = 0; i < cs.length; i++) {
			soma += Character.digit(cs[i], 10) * (15 - i);
		}
		return soma;
	}

}
