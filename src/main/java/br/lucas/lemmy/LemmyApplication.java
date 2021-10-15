package br.lucas.lemmy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.lucas.lemmy.magia.MagiaEvent;
import net.dv8tion.jda.api.JDABuilder;

@SpringBootApplication	
public class LemmyApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(LemmyApplication.class, args);
		
	    JDABuilder builder = JDABuilder.createDefault("ODk0NjIwNjM3MDQ0MzAxODY2.YVsqZQ.dKZccXxiRsy5ZuNIWfayGGbkecY");
	    builder.addEventListeners(new MagiaEvent());
	    builder.build();
		
	}

}
