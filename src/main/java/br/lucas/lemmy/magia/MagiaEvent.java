package br.lucas.lemmy.magia;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.lucas.lemmy.Bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Component
public class MagiaEvent extends ListenerAdapter {
	
	@Autowired
	private MagiaRepository repo;
	
	@Autowired
	private Bot bot;

	public void onGuildMessageReceived(GuildMessageReceivedEvent evento) {
		try {
			String msg = evento.getMessage().getContentRaw();
			if(msg.startsWith(bot.getPrefixo())) {
				
				msg = msg.substring(bot.getPrefixoTam()).trim();
				try {
					
					Magia magia = repo.buscarMagiaPorNome(msg);
					List<String> descricao = repo.buscarMagiaDescricao(magia.getId());
					List<String> componentes = repo.buscarMagiaComponentes(magia.getId());
					List<String> niveis_acima = repo.buscarMagiaNiveisAcima(magia.getId());
					List<Classe> classes = repo.buscarMagiaClasses(magia.getId());
					
					EmbedBuilder eb = new EmbedBuilder();
					eb.setTitle(magia.getNome());
					
					if(magia.getNivel().equals(0))
						eb.setDescription("Truque de " + magia.getEscola().toString().toLowerCase());
					
					evento.getChannel().sendMessageEmbeds(eb.build()).queue();
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}