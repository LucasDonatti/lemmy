package br.lucas.lemmy.magia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.lucas.lemmy.Bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Component
public class MagiaEvent extends ListenerAdapter {
	
	@Autowired
	private MagiaService service;
	@Autowired
	private Bot bot;
	
	public void onMessageReceived(MessageReceivedEvent evento) {
		try {
			String msg = evento.getMessage().getContentRaw();
			if(msg.startsWith(bot.getPrefixo())) {
				msg = msg.substring(bot.getPrefixoTam()).trim();
				
				// P E L O   I N D I C E
				Magia magia = service.getMagiaPeloIndice(msg);
				if(magia != null) {
					EmbedBuilder eb = new EmbedBuilder();
					eb.setTitle(magia.getName());
					
					if(magia.getLevel().equals(0))
						eb.addField("cantrip", "", false);
					else if(magia.getLevel().equals(1))
						eb.addField(magia.getLevel() + "st level", "", false);
					else if(magia.getLevel().equals(2))
						eb.addField(magia.getLevel() + "nd level", "", false);
					else if(magia.getLevel().equals(3))
						eb.addField(magia.getLevel() + "rd level", "", false);
					else
						eb.addField(magia.getLevel() + "th level", "", false);
					
					eb.addField("Casting Time: ", magia.getCasting_time(), true);
					eb.addField("Range: ", magia.getRange(), true);
					
					if(magia.getMaterial() != null)
						eb.addField("Components: ", magia.getComponents().toString()
												  + "\n" + magia.getMaterial(), true);
					else
						eb.addField("Components: ", magia.getComponents().toString(), true);
					
					if(magia.isConcentration())
						eb.addField("Duration: ", "Concentration, up to " + magia.getDuration(), true);
					else
						eb.addField("Duration: ", magia.getDuration(), true);
					
					for(int i = 0; i < magia.getDesc().size(); i++) {
						if(i == 0)
							eb.addField("Description: ", magia.getDesc().get(i), false);
						else
							eb.addField("", magia.getDesc().get(i), false);
					}
					
					if(magia.getHigher_level() != null) {
						for(int i = 0; i < magia.getHigher_level().size(); i++) {
							if(i == 0)
								eb.addField("At Higher Levels.", magia.getHigher_level().get(i), false);
							else
								eb.addField("", magia.getHigher_level().get(i), false);
						}
					}
					
					evento.getChannel().sendMessageEmbeds(eb.build()).queue();
					
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
