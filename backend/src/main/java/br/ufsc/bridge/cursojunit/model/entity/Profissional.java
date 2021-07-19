package br.ufsc.bridge.cursojunit.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.joda.time.LocalDate;

import br.ufsc.bridge.cursojunit.utils.SexoEnum;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Getter
@Setter
@Table(name = "TB_PROF")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Profissional {

	private static final String SEQUENCE_NAME = "SQ_PROF_COSEQPROF";

	@Id
	@SequenceGenerator(initialValue = 1, allocationSize = 1, sequenceName = Profissional.SEQUENCE_NAME, name = Profissional.SEQUENCE_NAME)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = Profissional.SEQUENCE_NAME)
	@Column(name = "CO_SEQ_PROF")
	private Long id;

	@Column(name = "NU_CPF", length = 11, nullable = false)
	private String cpf;

	@Column(name = "NU_CNS", length = 15, nullable = false)
	private String cns;

	@Column(name = "NO_PROFISSIONAL", nullable = false)
	private String nome;

	@Enumerated
	@Column(name = "CO_SEXO", nullable = false)
	private SexoEnum sexo;

	@Column(name = "DT_NASCIMENTO")
	private LocalDate dataNascimento;

	@Column(name = "NU_TELEFONE")
	private String telefone;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CO_SEQ_UBS")
	private UnidadeBasicaSaude unidadeBasicaSaude;
}
