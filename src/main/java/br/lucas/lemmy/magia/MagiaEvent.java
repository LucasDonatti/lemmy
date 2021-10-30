package br.lucas.lemmy.magia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.lucas.lemmy.Bot;
import br.lucas.lemmy.common.APIReferenceList;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Component
public class MagiaEvent extends ListenerAdapter {
	
	@Autowired
	private MagiaService service;
	@Autowired
	private Bot bot;
	
	private Magia magia;
	private APIReferenceList magias;
	
	public void onMessageReceived(MessageReceivedEvent evento) {
		try {
			String msg = evento.getMessage().getContentRaw();
			if(msg.startsWith(bot.getPrefixo())) {
				msg = msg.substring(bot.getPrefixoTam()).trim();
				
				// P E L O   I N D I C E
				magia = service.getMagiaPeloIndice(msg);
				if(magia != null) {
					MagiaEmbed me = new MagiaEmbed();
					evento.getChannel().sendMessageEmbeds(me.criarMagiaEmbed(magia)).queue();
				} else {
					// P E L O   N O M E
					magias = service.getMagiasPeloNome(msg);
					if(magias.getCount().equals(1)) {
						magia = service.getMagiaPeloIndice(magias.getResults().get(0).getIndex());
						
						MagiaEmbed me = new MagiaEmbed();
						evento.getChannel().sendMessageEmbeds(me.criarMagiaEmbed(magia)).queue();
						
					} else if(magias.getCount() > 1) {
						MagiaEmbed me = new MagiaEmbed();
						evento.getChannel().sendMessageEmbeds(me.criarListaMagiaEmbed(magias)).queue();
					}
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
