package br.ufsc.bridge.cursojunit.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//@RequiredArgsConstructor
@RestController
public class BoasVindasController {

	@RequestMapping(value = "/")
	public ModelAndView welcomePage() throws Exception {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index.html");
		return modelAndView;

	}
}
