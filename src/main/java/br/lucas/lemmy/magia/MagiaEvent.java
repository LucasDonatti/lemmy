package br.lucas.lemmy.magia;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.lucas.lemmy.Bot;
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
					evento.getChannel().sendMessage("magia: " + magia.getNome()).queue();
					evento.getChannel().sendMessage("nivel: " + magia.getNivel()).queue();
					evento.getChannel().sendMessage("escola: " + magia.getEscola()).queue();
					
					List<String> descricao = repo.buscarMagiaDescricao(magia.getId());
					for(int i = 0; i < descricao.size(); i++) {
						evento.getChannel().sendMessage("descricao[" + i + "]: " + descricao.get(i)).queue();
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}