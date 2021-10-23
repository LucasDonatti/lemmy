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
				if(service.getMagiaExternaPeloNome(msg) != null) {
					evento.getChannel().sendMessage("existe").queue();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
