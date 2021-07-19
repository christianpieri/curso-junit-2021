package br.ufsc.bridge.cursojunit.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import br.ufsc.bridge.cursojunit.model.entity.Profissional;
import br.ufsc.bridge.cursojunit.model.entity.UnidadeBasicaSaude;
import br.ufsc.bridge.cursojunit.model.form.ProfissionalForm;

@Service
@RequiredArgsConstructor
public class ProfissionalService {

	private final ProfissionalRepository repository;

	public Profissional save(ProfissionalForm form, UnidadeBasicaSaude ubsReferencia) {

		Profissional profissional = new Profissional();
		profissional.setCns(form.getCnsProfissional());
		profissional.setCpf(form.getCpfProfissional());
		profissional.setNome(form.getNomeProfissional());
		profissional.setDataNascimento(form.getDtNascProfissional());
		profissional.setSexo(form.getSexoProfissional());
		profissional.setTelefone(form.getTelefoneProfissional());
		profissional.setUnidadeBasicaSaude(ubsReferencia);

		return this.repository.save(profissional);
	}

	public Profissional loadByName(String nome) {
		return this.repository.findByNome(nome);
	}

	public Profissional loadById(Long id) {
		return this.repository.findById(id).orElse(null);
	}

	public Profissional loadByCpf(String cpf) {
		return this.repository.findByCpf(cpf);
	}

	public Profissional update(ProfissionalForm form, UnidadeBasicaSaude ubsReferencia, Long id) {

		Profissional profissional = this.loadById(id);

		profissional.setCns(form.getCnsProfissional());
		profissional.setCpf(form.getCpfProfissional());
		profissional.setNome(form.getNomeProfissional());
		profissional.setDataNascimento(form.getDtNascProfissional());
		profissional.setSexo(form.getSexoProfissional());
		profissional.setTelefone(form.getTelefoneProfissional());
		profissional.setUnidadeBasicaSaude(ubsReferencia);

		return this.repository.save(profissional);
	}
}
