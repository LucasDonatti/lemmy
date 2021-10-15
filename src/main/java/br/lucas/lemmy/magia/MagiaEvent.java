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
			evento.getChannel().sendMessage(msg + " hou, lets go!").queue();
		}
		if(msg.equals("cc8da2d1-0ea6-4490-9024-f1fda937a28b")) {
			Magia magia = service.getPeloId(msg);
			evento.getChannel()
			.sendMessage(magia.getNome())
			.queue();
		}
	}
	
}

