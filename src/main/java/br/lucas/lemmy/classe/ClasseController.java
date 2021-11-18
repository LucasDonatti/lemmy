package br.lucas.lemmy.classe;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.lucas.lemmy.base.BaseCrudController;

@RestController
@RequestMapping("/api/classes")
public class ClasseController extends BaseCrudController<Classe, ClasseRepository, ClasseService> {
	
}
