package br.lucas.lemmy.magia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Component
public class MagiaEvent extends ListenerAdapter {
	
	@Autowired
	private MagiaService service;
	
	private String prefixo = "!lm";
	private int prefixoTam = prefixo.length();
	private String msg;
	
	public void onMessageReceived(MessageReceivedEvent evento) {
		msg = evento.getMessage().getContentRaw();
		if(msg.startsWith(prefixo)) {
			msg = msg.substring(prefixoTam).trim();
			if(msg.equals("hey")) {
				evento.getChannel().sendMessage(msg + " ho, lets go!").queue();
			}
			/*if(service.getPeloId(msg) != null) {
				Magia magia = service.getPeloId(msg);
				evento.getChannel().sendMessage(magia.getNome().toUpperCase() + "\n" + magia.getDescricao()).queue();
			}*/
			if(service.getPeloNome(msg) != null) {
				Magia magia = service.getPeloNome(msg);
				
				// R I T U A L   E   C O N C E N T R A Ç Ã O
				if(magia.isRitual() && magia.isConcentracao()) {
					evento.getChannel()
					.sendMessageFormat("%s\n"
							+ "%dº Nível de -escola- (ritual)\n"
							+ "Tempo de Conjuração: %s\n"
							+ "Alcance: %s\n"
							+ "Componentes: %s\n"
							+ "Duração: Concentração, até %s\n\n"
							+ "%s\n\n"
							+ "Em Níveis Superiores. %s"
							, magia.getNome().toUpperCase()
							, magia.getNivel()
							, magia.getTempoConjuracao()
							, magia.getAlcance()
							, magia.getComponentes()
							, magia.getDuracao()
							, magia.getDescricao()
							, magia.getNiveisAcima()
							)
					.queue();
				} else {
					
					// N E N H U M   D O S   D O I S
					if(!magia.isRitual() && !magia.isConcentracao()) {
						evento.getChannel()
						.sendMessageFormat("%s\n"
								+ "%dº Nível de -escola-\n"
								+ "Tempo de Conjuração: %s\n"
								+ "Alcance: %s\n"
								+ "Componentes: %s\n"
								+ "Duração: %s\n\n"
								+ "%s\n\n"
								+ "Em Níveis Superiores. %s"
								, magia.getNome().toUpperCase()
								, magia.getNivel()
								, magia.getTempoConjuracao()
								, magia.getAlcance()
								, magia.getComponentes()
								, magia.getDuracao()
								, magia.getDescricao()
								, magia.getNiveisAcima()
								)
						.queue();
					} else {
						
						// R I T U A L
						if(magia.isRitual()) {
							evento.getChannel()
							.sendMessageFormat("%s\n"
									+ "%dº Nível de -escola- (ritual)\n"
									+ "Tempo de Conjuração: %s\n"
									+ "Alcance: %s\n"
									+ "Componentes: %s\n"
									+ "Duração: %s\n\n"
									+ "%s\n\n"
									+ "Em Níveis Superiores. %s"
									, magia.getNome().toUpperCase()
									, magia.getNivel()
									, magia.getTempoConjuracao()
									, magia.getAlcance()
									, magia.getComponentes()
									, magia.getDuracao()
									, magia.getDescricao()
									, magia.getNiveisAcima()
									)
							.queue();
						} else {
							
							// C O N C E N T R A Ç Ã O
							if(magia.isConcentracao()) {
								evento.getChannel()
								.sendMessageFormat("%s\n"
										+ "%dº Nível de -escola-\n"
										+ "Tempo de Conjuração: %s\n"
										+ "Alcance: %s\n"
										+ "Componentes: %s\n"
										+ "Duração: Concentração, até %s\n\n"
										+ "%s\n\n"
										+ "Em Níveis Superiores. %s"
										, magia.getNome().toUpperCase()
										, magia.getNivel()
										, magia.getTempoConjuracao()
										, magia.getAlcance()
										, magia.getComponentes()
										, magia.getDuracao()
										, magia.getDescricao()
										, magia.getNiveisAcima()
										)
								.queue();
							}
						}
					}
				}
			}
		}
	}
	
}

