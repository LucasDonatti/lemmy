package br.lucas.lemmy.magia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Component
public class MagiaEvent extends ListenerAdapter {
	
	@Autowired
	private MagiaService service;
	
	public void onMessageReceived(MessageReceivedEvent evento) {
		String msg = evento.getMessage().getContentRaw();
		if(msg.equals("!hey")) {
			evento.getChannel().sendMessage(msg + " ho, lets go!").queue();
		}
//		if(service.getPeloId(msg) != null) {
//			Magia magia = service.getPeloId(msg);
//			evento.getChannel().sendMessage(magia.getNome().toUpperCase() + "\n" + magia.getDescricao()).queue();
//		}
		if(service.getPeloNome(msg) != null) {
			Magia magia = service.getPeloNome(msg);
			evento.getChannel().sendMessage(magia.getNome().toUpperCase() + "\n" + magia.getDescricao()).queue();
		}
	}
	
}

