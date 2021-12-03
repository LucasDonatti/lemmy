package br.lucas.lemmy.magia;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.lucas.lemmy.Bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Component
public class MagiaEvent extends ListenerAdapter {
	
	@Autowired
	private MagiaRepository repo;
	
	@Autowired
	private Bot bot;

	public void onGuildMessageReceived(GuildMessageReceivedEvent evento) {
		try {
			String msg = evento.getMessage().getContentRaw();
			if(msg.startsWith(bot.getPrefixo())) {
				
				msg = msg.substring(bot.getPrefixoTam()).trim();
				try {
					
					Magia magia = repo.buscarMagiaPorNome(msg);
					List<String> descricao = repo.buscarMagiaDescricao(magia.getId());
					List<String> componentes = repo.buscarMagiaComponentes(magia.getId());
					List<String> niveis_acima = repo.buscarMagiaNiveisAcima(magia.getId());
					List<Classe> classes = repo.buscarMagiaClasses(magia.getId());
					
					EmbedBuilder eb = new EmbedBuilder();
					
					if(magia.getNivel().equals(0)) {
						eb.addField(magia.getNome(), "Truque de " + magia.getEscola().toString().toLowerCase(), false);
					} else {
						if(magia.isRitual()) {
							eb.addField(magia.getNome(), magia.getNivel() + "º nível de " + magia.getEscola().toString().toLowerCase() + " (ritual)", false);
						} else {
							eb.addField(magia.getNome(), magia.getNivel() + "º nível de " + magia.getEscola().toString().toLowerCase(), false);
						}
					}
					
					eb.addField("Classes: ", classes.toString().toLowerCase(), false);
					eb.addField("Tempo de Conjuração: ", magia.getTempoDeConjuracao(), false);
					eb.addField("Alcance: ", magia.getAlcance(), false);
					if(magia.getMaterial() != null) {
						eb.addField("Componentes: ", componentes.toString() + " (" + magia.getMaterial() + ")", false);
					} else {
						eb.addField("Componentes: ", componentes.toString(), false);
					}
					
					if(magia.isConcentracao()) {
						eb.addField("Duração: ", "Concentração, até " + magia.getDuracao(), false);
					} else {
						eb.addField("Duração: ", magia.getDuracao(), false);
					}
					
					for(int i = 0; i < descricao.size(); i++) {
						eb.addField("", descricao.get(i), false);
					}
					
					if(niveis_acima != null) {
						for(int i = 0; i < niveis_acima.size(); i++) {
							eb.addField("", niveis_acima.get(i), false);
						}
					}
					
					evento.getChannel().sendMessageEmbeds(eb.build()).queue();
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}