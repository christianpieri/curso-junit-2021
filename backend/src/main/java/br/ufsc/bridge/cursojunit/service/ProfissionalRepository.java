package br.ufsc.bridge.cursojunit.service;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufsc.bridge.cursojunit.model.entity.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

	Profissional findByNome(String nome);

	Profissional findById(String id);

	Profissional findByCpf(String cpf);

}
