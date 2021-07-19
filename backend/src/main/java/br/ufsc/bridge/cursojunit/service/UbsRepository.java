package br.ufsc.bridge.cursojunit.service;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufsc.bridge.cursojunit.model.entity.UnidadeBasicaSaude;

public interface UbsRepository extends JpaRepository<UnidadeBasicaSaude, Long> {

	UnidadeBasicaSaude findByNome(String nome);

	UnidadeBasicaSaude findById(String id);

}
