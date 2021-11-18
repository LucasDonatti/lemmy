package br.lucas.lemmy.escola;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.lucas.lemmy.base.BaseCrudService;

@Service
@Transactional
public class EscolaService extends BaseCrudService<Escola, EscolaRepository> {

}
