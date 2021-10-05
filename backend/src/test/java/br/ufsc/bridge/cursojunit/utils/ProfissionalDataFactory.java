package br.ufsc.bridge.cursojunit.utils;

import br.ufsc.bridge.cursojunit.model.form.ProfissionalForm;

public class ProfissionalDataFactory {

	public static ProfissionalForm createFullProfissional() {
		ProfissionalForm form = new ProfissionalForm();
		form.setCnsProfissional("900000000000008");
		form.setCpfProfissional("01234567890");
		form.setDtNascProfissional(null);
		form.setNomeProfissional("Chris Pieri");
		form.setSexoProfissional(SexoEnum.MASCULINO);
		form.setTelefoneProfissional("99999999");
		form.setUbsReferencia(null);

		return form;
	}
}
