package br.lucas.lemmy.escola;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.lucas.lemmy.base.BaseCrudController;

@RestController
@RequestMapping("/api/escolas")
public class EscolaController extends BaseCrudController<Escola, EscolaRepository, EscolaService> {

}
