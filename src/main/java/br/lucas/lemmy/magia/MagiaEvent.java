package br.lucas.lemmy.magia;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MagiaEvent extends ListenerAdapter {
	
	public void onMessageReceived(MessageReceivedEvent evento) {
		String msg = evento.getMessage().getContentRaw();
		if(msg.equals("!hell")) {
			evento.getChannel().sendMessage("yeah!").queue();
		}
	}
	
}

