package br.lucas.lemmy.dnd5eapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.lucas.lemmy.Bot;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Component
public class MagiaExternaEvent extends ListenerAdapter {
	
	@Autowired
	private MagiaExternaService service;
	@Autowired
	private Bot bot;
	
	public void onMessageReceived(MessageReceivedEvent evento) {
		try {
			String msg = evento.getMessage().getContentRaw();
			if(msg.startsWith(bot.getPrefixo())) {
				msg = msg.substring(bot.getPrefixoTam()).trim();
				MagiaExterna magiaExterna = service.getMagiaExternaPeloNome(msg);
				if(magiaExterna != null) {
					evento.getChannel().sendMessageFormat("%s\n"
														+ "%dº Nível\n"
														, magiaExterna.getName().toUpperCase()
														, magiaExterna.getLevel()
							).queue();
					for (String desc : magiaExterna.getDesc()) {
						evento.getChannel().sendMessage(desc).queue();
					}
					if(magiaExterna.getHigher_level() != null) {
						evento.getChannel().sendMessage("EM NÍVEIS SUPERIORES. ").queue();
						for (String higher_level : magiaExterna.getHigher_level()) {
							evento.getChannel().sendMessage(higher_level).queue();
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
