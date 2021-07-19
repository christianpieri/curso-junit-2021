package br.ufsc.bridge.cursojunit.utils;

import br.ufsc.bridge.cursojunit.model.form.UnidadeBasicaSaudeForm;

public class UbsDataFactory {

	public static UnidadeBasicaSaudeForm createFullUbs() {

		UnidadeBasicaSaudeForm ubs = new UnidadeBasicaSaudeForm();
		ubs.setNomeUbs("CS Trindade");
		return ubs;
	}
}
