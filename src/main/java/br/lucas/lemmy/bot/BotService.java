package br.lucas.lemmy.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

@Service
public class BotService {
	
	@Autowired
	private Bot bot;
	
	public String buscarMsgComPrefixo(GuildMessageReceivedEvent evento) {
		String msg = evento.getMessage().getContentRaw();
		if (msg.startsWith(bot.getPrefixo()))
			msg = msg.substring(bot.getTamanhoDoPrefixo()).trim();
		else
			return null;
		return msg;
	}
	
}
