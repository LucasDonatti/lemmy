package br.lucas.lemmy.magia;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.lucas.lemmy.base.BaseCrudService;

@Service
@Transactional
public class MagiaService extends BaseCrudService<Magia, MagiaRepository> {

}
