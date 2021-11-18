package br.lucas.lemmy.classe;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.lucas.lemmy.base.BaseCrudService;

@Service
@Transactional
public class ClasseService extends BaseCrudService<Classe, ClasseRepository> {

}
