package br.ufsc.bridge.cursojunit.utils;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormError {

	private List<String> errorList;

	public FormError() {
		this.errorList = new ArrayList<>();
	}

	public void add(ErrosEnum tipoErro, String localDoErro) {
		this.errorList.add("Erro do tipo " + tipoErro.toString() + " no campo " + localDoErro);
	}
}
