package br.lucas.lemmy.magia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.lucas.lemmy.Bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Component
public class MagiaEvent extends ListenerAdapter {
	
	@Autowired
	private MagiaService service;
	
	@Autowired
	private Bot bot;

	public void onGuildMessageReceived(GuildMessageReceivedEvent evento) {
		try {
			String msg = evento.getMessage().getContentRaw();
			if(msg.startsWith(bot.getPrefixo())) {
				
				msg = msg.substring(bot.getPrefixoTam()).trim();
				try {
					
					Magia magia = service.buscarMagiaPorNome(msg);
					
					EmbedBuilder eb = new EmbedBuilder();
					
					if(magia.getNivel().equals(0)) {
						eb.addField(magia.getNome().toUpperCase(), "Truque de " + magia.getEscola().toString().toLowerCase(), false);
					} else {
						if(magia.isRitual()) {
							eb.addField(magia.getNome().toUpperCase(), magia.getNivel() + "º nível de " + magia.getEscola().toString().toLowerCase() + " (ritual)", false);
						} else {
							eb.addField(magia.getNome().toUpperCase(), magia.getNivel() + "º nível de " + magia.getEscola().toString().toLowerCase(), false);
						}
					}
					
					eb.addField("Classes: ", magia.getClasses().toString().toLowerCase(), false);
					eb.addField("Tempo de Conjuração: ", magia.getTempoDeConjuracao(), false);
					eb.addField("Alcance: ", magia.getAlcance(), false);
					if(magia.getMaterial() != null) {
						eb.addField("Componentes: ", magia.getComponentes().toString() + " (" + magia.getMaterial() + ")", false);
					} else {
						eb.addField("Componentes: ", magia.getComponentes().toString(), false);
					}
					
					if(magia.isConcentracao()) {
						eb.addField("Duração: ", "Concentração, até " + magia.getDuracao(), false);
					} else {
						eb.addField("Duração: ", magia.getDuracao(), false);
					}
					
					for(int i = 0; i < magia.getDescricao().size(); i++) {
						eb.addField("", magia.getDescricao().get(i), false);
					}
					
					if(magia.getNiveisAcima() != null) {
						for(int i = 0; i < magia.getNiveisAcima().size(); i++) {
							eb.addField("", magia.getNiveisAcima().get(i), false);
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