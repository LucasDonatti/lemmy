package br.lucas.lemmy.magia;

import org.springframework.stereotype.Component;

import br.lucas.lemmy.common.APIReferenceList;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

@Component
public class MagiaEmbed {
	
	public MessageEmbed criarMagiaEmbed(Magia magia) {
		EmbedBuilder eb = new EmbedBuilder();
		
		if(magia.getLevel().equals(0))
			eb.addField(magia.getName(), magia.getSchool().getName() + " cantrip", false);
		else if(magia.getLevel().equals(1))
			eb.addField(magia.getName(), magia.getLevel() + "st level " + magia.getSchool().getName().toLowerCase(), false);
		else if(magia.getLevel().equals(2))
			eb.addField(magia.getName(), magia.getLevel() + "nd level " + magia.getSchool().getName().toLowerCase(), false);
		else if(magia.getLevel().equals(3))
			eb.addField(magia.getName(), magia.getLevel() + "rd level " + magia.getSchool().getName().toLowerCase(), false);
		else
			eb.addField(magia.getName(), magia.getLevel() + "th level " + magia.getSchool().getName().toLowerCase(), false);
		
		eb.addField("Casting Time: ", magia.getCasting_time(), false);
		eb.addField("Range: ", magia.getRange(), false);
		
		if(magia.getMaterial() != null)
			eb.addField("Components: ", magia.getComponents().toString() + " " + magia.getMaterial(), false);
		else
			eb.addField("Components: ", magia.getComponents().toString(), false);
		
		if(magia.isConcentration())
			eb.addField("Duration: ", "Concentration, up to " + magia.getDuration(), false);
		else
			eb.addField("Duration: ", magia.getDuration(), false);
		
		for(int i = 0; i < magia.getDesc().size(); i++) {
			if(i == 0)
				eb.addField("Description: ", magia.getDesc().get(i), false);
			else
				eb.addField("", magia.getDesc().get(i), false);
		}
		
		if(magia.getHigher_level() != null) {
			for(int i = 0; i < magia.getHigher_level().size(); i++) {
				if(i == 0)
					eb.addField("\nAt Higher Levels.", magia.getHigher_level().get(i), false);
				else
					eb.addField("", magia.getHigher_level().get(i), false);
			}
		}
		
		return eb.build();
	}
	
	public MessageEmbed criarListaMagiaEmbed(APIReferenceList magias) {
		
		EmbedBuilder eb = new EmbedBuilder();
		
		for(int i = 0; i < magias.getCount(); i++) {
			if(i == 0)
				eb.addField("Magias", "[" + (i+1)+ "]" + " - " + magias.getResults().get(i).getName(), false);
			else
				eb.addField("", "[" + (i+1)+ "]" + " - " + magias.getResults().get(i).getName(), false);
		}
		return eb.build();
	}
	
}
