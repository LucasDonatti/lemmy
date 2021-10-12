package br.lucas.lemmy.events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HelloEvent extends ListenerAdapter {
	
	public void aoReceberMsgNoDiscord(GuildMessageReceivedEvent evento) {
		String msg = evento.getMessage().getContentRaw();
		if(msg.equalsIgnoreCase("hell")) {
			evento.getChannel().sendMessage("yeah!").queue();
		}
	}
	
}
