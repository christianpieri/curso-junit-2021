package br.ufsc.bridge.cursojunit.model.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.joda.time.LocalDate;

import br.ufsc.bridge.cursojunit.utils.SexoEnum;

@Getter
@Setter
@NoArgsConstructor
public class ProfissionalForm {

	private String cpfProfissional;
	private String cnsProfissional;
	private String nomeProfissional;
	private SexoEnum sexoProfissional;
	private LocalDate dtNascProfissional;
	private String telefoneProfissional;
	private UnidadeBasicaSaudeForm ubsReferencia;

}
