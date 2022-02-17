package br.lucas.lemmy.magia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Component
public class MagiaEvent extends ListenerAdapter {

	@Autowired
	private MagiaService magiaService;
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent evento) {
		String msg = buscarMsgComPrefixo(evento);
		if(msg != null) {
			Magia magia = magiaService.buscarMagiaPorNome(msg);
			evento.getChannel().sendMessageEmbeds(magiaService.criarEmbed(magia)).queue();
		}
		
	}
	
	public String buscarMsgComPrefixo(GuildMessageReceivedEvent evento) {
		String prefixo = "!lm";
		String msg = evento.getMessage().getContentRaw();
		
		if (msg.startsWith(prefixo))
			msg = msg.substring(prefixo.length()).trim();
		else
			return null;
		return msg;
	}

}