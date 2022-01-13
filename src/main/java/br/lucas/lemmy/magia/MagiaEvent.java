package br.lucas.lemmy.magia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.lucas.lemmy.bot.BotService;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Component
public class MagiaEvent extends ListenerAdapter {

	@Autowired
	private MagiaService magiaService;

	@Autowired
	private BotService botService;

	public void onGuildMessageReceived(GuildMessageReceivedEvent evento) {
		try {
			Magia magia = magiaService.buscarMagiaPorNome(botService.buscarMsgComPrefixo(evento));
			evento.getChannel().sendMessageEmbeds(magiaService.criarEmbed(magia)).queue();
		} catch (Exception e) {

		}
	}

}