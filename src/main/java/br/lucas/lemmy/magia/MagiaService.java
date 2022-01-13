package br.lucas.lemmy.magia;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.lucas.lemmy.base.BaseCrudService;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

@Service
@Transactional
public class MagiaService extends BaseCrudService<Magia, MagiaRepository> {

	@Autowired
	private MagiaRepository repo;

	public Magia buscarMagiaPorNome(String nome) {
		Magia magia = repo.buscarPeloNome(nome).get(0);
		magia.setDescricao(repo.buscarDescricaoPeloId(magia.getId()));
		magia.setComponentes(repo.buscarComponentesPeloId(magia.getId()));
		magia.setNiveisAcima(repo.buscarNiveisAcimaPeloId(magia.getId()));
		magia.setClasses(repo.buscarClassesPeloId(magia.getId()));
		return magia;
	}
	
	public MessageEmbed criarEmbed(Magia magia) {
		
		EmbedBuilder eb = new EmbedBuilder();
		
		if (magia.getNivel() == 0)
			eb.addField(magia.getNome().toUpperCase(), "Truque de " + magia.getEscola().toString().toLowerCase(), false);
		else if(magia.isRitual())
			eb.addField(magia.getNome().toUpperCase(), magia.getNivel() + "º nível de " + magia.getEscola().toString().toLowerCase() + " (ritual)", false);
		else
			eb.addField(magia.getNome().toUpperCase(), magia.getNivel() + "º nível de " + magia.getEscola().toString().toLowerCase(), false);
		
		eb.addField("Classes: ", magia.getClasses().toString().toLowerCase(), false);
		eb.addField("Tempo de Conjuração: ", magia.getTempoDeConjuracao(), false);
		eb.addField("Alcance: ", magia.getAlcance(), false);
		
		if (magia.getMaterial() != null) 
			eb.addField("Componentes: ", magia.getComponentes().toString() + " (" + magia.getMaterial() + ")", false);	
		else 
			eb.addField("Componentes: ", magia.getComponentes().toString(), false);

		if (magia.isConcentracao()) 
			eb.addField("Duração: ", "Concentração, até " + magia.getDuracao(), false);
		else 
			eb.addField("Duração: ", magia.getDuracao(), false);

		for (int i = 0; i < magia.getDescricao().size(); i++) 
			eb.addField("", magia.getDescricao().get(i), false);
		
		if (magia.getNiveisAcima().size() > 0) {
			eb.addField("Em Níveis Superiores. ", magia.getNiveisAcima().get(0), false);
			for (int i = 1; i < magia.getNiveisAcima().size(); i++) 
				eb.addField("", magia.getNiveisAcima().get(i), false);
		}
		
		return eb.build();
		
	}

}
