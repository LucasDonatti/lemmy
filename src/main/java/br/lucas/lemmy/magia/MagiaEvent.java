package br.lucas.lemmy.magia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.lucas.lemmy.Bot;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Component
public class MagiaEvent extends ListenerAdapter {
	
	@Autowired
	private Bot bot;

	public void onGuildMessageReceived(GuildMessageReceivedEvent evento) {
		try {
			String msg = evento.getMessage().getContentRaw();
			if(msg.startsWith(bot.getPrefixo())) {
				
				msg = msg.substring(bot.getPrefixoTam()).trim();
				if(msg.equals("ola")) {
					evento.getChannel().sendMessage("mundo").queue();
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}