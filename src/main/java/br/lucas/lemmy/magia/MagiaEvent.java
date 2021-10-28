package br.lucas.lemmy.magia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.lucas.lemmy.Bot;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Component
public class MagiaEvent extends ListenerAdapter {
	
	@Autowired
	private MagiaService service;
	@Autowired
	private Bot bot;
	
	public void onMessageReceived(MessageReceivedEvent evento) {
		try {
			String msg = evento.getMessage().getContentRaw();
			if(msg.startsWith(bot.getPrefixo())) {
				msg = msg.substring(bot.getPrefixoTam()).trim();
				
				// P E L O   I N D I C E
				Magia magia = service.getMagiaPeloIndice(msg);
				if(magia != null) {
					evento.getChannel().sendMessageFormat("%s\n"
														+ "%dº nível"
														, magia.getName()
														, magia.getLevel())
					.queue();
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
