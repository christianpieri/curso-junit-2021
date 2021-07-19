package br.ufsc.bridge.cursojunit.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import br.ufsc.bridge.cursojunit.model.entity.UnidadeBasicaSaude;
import br.ufsc.bridge.cursojunit.model.form.UnidadeBasicaSaudeForm;

@Service
@RequiredArgsConstructor
public class UnidadeBasicaSaudeService {

	private final UbsRepository repository;

	public UnidadeBasicaSaude save(UnidadeBasicaSaudeForm form) {
		UnidadeBasicaSaude ubs = new UnidadeBasicaSaude();
		ubs.setNome(form.getNomeUbs());
		return this.repository.save(ubs);
	}

	public UnidadeBasicaSaude loadByName(UnidadeBasicaSaudeForm form) {
		return this.repository.findByNome(form.getNomeUbs());
	}

	public UnidadeBasicaSaude loadByName(String nome) {
		return this.repository.findByNome(nome);
	}

	public UnidadeBasicaSaude loadById(Long id) {
		return this.repository.findById(id).orElse(null);
	}

	public UnidadeBasicaSaude update(UnidadeBasicaSaudeForm form, Long id) {
		UnidadeBasicaSaude ubs = this.loadById(id);
		ubs.setNome(form.getNomeUbs());
		return this.repository.save(ubs);
	}
}
