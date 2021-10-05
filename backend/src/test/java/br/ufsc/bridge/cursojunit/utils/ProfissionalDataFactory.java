package br.ufsc.bridge.cursojunit.utils;

import org.joda.time.LocalDate;

import br.ufsc.bridge.cursojunit.model.form.ProfissionalForm;

public class ProfissionalDataFactory {

	public static ProfissionalForm createFullProfissional() {
		ProfissionalForm profissionalForm = new ProfissionalForm();
		profissionalForm.setCpfProfissional("01234567890");
		profissionalForm.setCnsProfissional("888888888000000");
		profissionalForm.setNomeProfissional("Davi");
		profissionalForm.setDtNascProfissional(LocalDate.now());
		profissionalForm.setSexoProfissional(SexoEnum.MASCULINO);
		profissionalForm.setTelefoneProfissional("048991072375");
		profissionalForm.setUbsReferencia(UbsDataFactory.createFullUbs());

		return profissionalForm;
	}
}
