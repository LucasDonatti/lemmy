package br.lucas.lemmy.magia;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.lucas.lemmy.base.BaseCrudController;

@RestController
@RequestMapping("/api/magias")	
public class MagiaController extends BaseCrudController<Magia, MagiaRepository, MagiaService> {
	
}
