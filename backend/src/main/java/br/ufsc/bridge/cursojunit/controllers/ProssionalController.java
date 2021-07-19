package br.ufsc.bridge.cursojunit.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.ufsc.bridge.cursojunit.model.entity.Profissional;
import br.ufsc.bridge.cursojunit.model.entity.UnidadeBasicaSaude;
import br.ufsc.bridge.cursojunit.model.form.ProfissionalForm;
import br.ufsc.bridge.cursojunit.service.ProfissionalService;
import br.ufsc.bridge.cursojunit.service.UnidadeBasicaSaudeService;
import br.ufsc.bridge.cursojunit.utils.FormError;
import br.ufsc.bridge.cursojunit.validation.ProfissionalFormValidator;

@RequiredArgsConstructor
@RestController
public class ProssionalController {

	private final ProfissionalService profissionalService;
	private final UnidadeBasicaSaudeService ubsService;

	@PostMapping("/saveProf")
	public ResponseEntity<Profissional> saveProf(@RequestBody ProfissionalForm form) {

		FormError erros = new FormError();
		ProfissionalFormValidator.validate(form, erros);

		if (!erros.getErrorList().isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, erros.getErrorList().get(0).toString());
		}

		UnidadeBasicaSaude ubsReferencia = this.ubsService.loadByName(form.getUbsReferencia());
		if (ubsReferencia == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ubs referência não encontrada na base de dados");
		}

		Profissional profissionalRetornado = this.profissionalService.save(form, ubsReferencia);
		return new ResponseEntity<Profissional>(profissionalRetornado, HttpStatus.CREATED);

	}

	@PostMapping("/updateProf/{id}")
	public ResponseEntity<Profissional> updateProf(@RequestBody ProfissionalForm form, @PathVariable Long id) {

		FormError erros = new FormError();
		ProfissionalFormValidator.validate(form, erros);

		if (!erros.getErrorList().isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, erros.getErrorList().get(0).toString());
		}

		UnidadeBasicaSaude ubsReferencia = this.ubsService.loadByName(form.getUbsReferencia());
		if (ubsReferencia == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ubs referência não encontrada na base de dados");
		}

		Profissional profissionalRetornado = this.profissionalService.update(form, ubsReferencia, id);
		return new ResponseEntity<Profissional>(profissionalRetornado, HttpStatus.OK);

	}

	@GetMapping("/obterProfByNome/{nome}")
	public ResponseEntity<Profissional> obterProfByNome(@PathVariable String nome) {

		Profissional profissionalRetornado = this.profissionalService.loadByName(nome);

		if (profissionalRetornado == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum profissional com nome " + nome + " encontrado na base de dados");
		}

		return new ResponseEntity<Profissional>(profissionalRetornado, HttpStatus.OK);
	}

	@GetMapping("/obterProfByCpf/{cpf}")
	public ResponseEntity<Profissional> obterProfByCpf(@PathVariable String cpf) {

		Profissional profissionalRetornado = this.profissionalService.loadByCpf(cpf);

		if (profissionalRetornado == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum profissional com cpf " + cpf + " encontrado na base de dados");
		}

		return new ResponseEntity<Profissional>(profissionalRetornado, HttpStatus.OK);
	}

	@GetMapping("/obterProfById/{id}")
	public ResponseEntity<Profissional> obterProfByCpf(@PathVariable Long id) {

		Profissional profissionalRetornado = this.profissionalService.loadById(id);

		if (profissionalRetornado == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum profissional com id " + id + " encontrado na base de dados");
		}

		return new ResponseEntity<Profissional>(profissionalRetornado, HttpStatus.OK);
	}

}
