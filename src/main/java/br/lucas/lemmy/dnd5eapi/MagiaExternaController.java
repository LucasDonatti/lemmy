package br.lucas.lemmy.dnd5eapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("magia-externa")
public class MagiaExternaController {

	@Autowired
	private MagiaExternaService service;
	
	@GetMapping
	public String get() {
		return service.get();
	}
	
}
