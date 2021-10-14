package br.lucas.lemmy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.lucas.lemmy.magia.MagiaEvent;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

@SpringBootApplication	
public class LemmyApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(LemmyApplication.class, args);
		
	    JDABuilder builder = JDABuilder.createDefault("ODk0NjIwNjM3MDQ0MzAxODY2.YVsqZQ.delzYNfWh7QfwhTj0g8nNTDeqOM");
	    
	    // Disable parts of the cache
	    builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
	    // Enable the bulk delete event
	    builder.setBulkDeleteSplittingEnabled(false);
	    // Disable compression (not recommended)
	    builder.setCompression(Compression.NONE);
	    // Set activity (like "playing Something")
	    builder.setActivity(Activity.watching("TV"));
	    builder.addEventListeners(new MagiaEvent());
	    
	    builder.build();
		
	}

}
