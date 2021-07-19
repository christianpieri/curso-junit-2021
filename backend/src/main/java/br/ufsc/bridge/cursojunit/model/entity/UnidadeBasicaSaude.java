package br.ufsc.bridge.cursojunit.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Getter
@Setter
@Table(name = "TB_UBS")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UnidadeBasicaSaude {

	private static final String SEQUENCE_NAME = "SQ_UBS_COSEQPROF";

	@Id
	@SequenceGenerator(initialValue = 1, allocationSize = 1, sequenceName = UnidadeBasicaSaude.SEQUENCE_NAME, name = UnidadeBasicaSaude.SEQUENCE_NAME)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = UnidadeBasicaSaude.SEQUENCE_NAME)
	@Column(name = "CO_SEQ_UBS")
	private Long id;

	@Column(name = "NO_UBS", nullable = false)
	private String nome;

}
