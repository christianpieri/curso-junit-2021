package br.ufsc.bridge.cursojunit.validation;

import org.apache.commons.lang3.StringUtils;

import br.ufsc.bridge.cursojunit.model.form.UnidadeBasicaSaudeForm;
import br.ufsc.bridge.cursojunit.utils.ErrosEnum;
import br.ufsc.bridge.cursojunit.utils.FormError;

public class UnidadeBasicaSaudeValidator {

	public static void validate(UnidadeBasicaSaudeForm form, FormError erros) {
		if (StringUtils.isBlank(form.getNomeUbs())) {
			erros.add(ErrosEnum.REQUIRED, "nome ubs");
		} else if (form.getNomeUbs().length() > 70) {
			erros.add(ErrosEnum.MALFORMED, "nome ubs");
		}
	}
}
