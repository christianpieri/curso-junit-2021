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

import br.ufsc.bridge.cursojunit.model.entity.UnidadeBasicaSaude;
import br.ufsc.bridge.cursojunit.model.form.UnidadeBasicaSaudeForm;
import br.ufsc.bridge.cursojunit.service.UnidadeBasicaSaudeService;
import br.ufsc.bridge.cursojunit.utils.FormError;
import br.ufsc.bridge.cursojunit.validation.UnidadeBasicaSaudeValidator;

@RequiredArgsConstructor
@RestController
public class UnidadeBasicaSaudeController {

	private final UnidadeBasicaSaudeService ubsService;

	@PostMapping("/saveUbs")
	public ResponseEntity<UnidadeBasicaSaude> saveUbs(@RequestBody UnidadeBasicaSaudeForm form) {

		FormError erros = new FormError();
		UnidadeBasicaSaudeValidator.validate(form, erros);

		if (!erros.getErrorList().isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, erros.getErrorList().get(0).toString());
		}

		UnidadeBasicaSaude ubsRetornada = this.ubsService.save(form);

		return new ResponseEntity<UnidadeBasicaSaude>(ubsRetornada, HttpStatus.CREATED);

	}

	@PostMapping("/updateUbs/{id}")
	public ResponseEntity<UnidadeBasicaSaude> updateUbs(@RequestBody UnidadeBasicaSaudeForm form, @PathVariable Long id) {

		FormError erros = new FormError();
		UnidadeBasicaSaudeValidator.validate(form, erros);

		if (!erros.getErrorList().isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, erros.getErrorList().get(0).toString());
		}

		UnidadeBasicaSaude ubsRetornada = this.ubsService.update(form, id);

		return new ResponseEntity<UnidadeBasicaSaude>(ubsRetornada, HttpStatus.OK);

	}

	@GetMapping("/obterUbsByNome/{nome}")
	public ResponseEntity<UnidadeBasicaSaude> obterUbs(@PathVariable String nome) {

		UnidadeBasicaSaude ubsRetornada = this.ubsService.loadByName(nome);

		if (ubsRetornada == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma ubs com nome " + nome + " encontrada na base de dados");
		}

		return new ResponseEntity<UnidadeBasicaSaude>(ubsRetornada, HttpStatus.OK);
	}

	@GetMapping("/obterUbsById/{id}")
	public ResponseEntity<UnidadeBasicaSaude> obterUbsById(@PathVariable Long id) {

		UnidadeBasicaSaude ubsRetornada = this.ubsService.loadById(id);

		if (ubsRetornada == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma ubs com id " + id + " encontrada na base de dados");
		}

		return new ResponseEntity<UnidadeBasicaSaude>(ubsRetornada, HttpStatus.OK);
	}
}
