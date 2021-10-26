package br.lucas.lemmy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.lucas.lemmy.dnd5eapi.MagiaExternaEvent;
import br.lucas.lemmy.magia.MagiaEvent;
import net.dv8tion.jda.api.JDABuilder;

@SpringBootApplication	
public class LemmyApplication implements CommandLineRunner {

	@Autowired
	private MagiaEvent magia;
	@Autowired
	private MagiaExternaEvent magiaExterna;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(LemmyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	    JDABuilder builder = JDABuilder.createDefault("ODk0NjIwNjM3MDQ0MzAxODY2.YVsqZQ.ivfnyhLwXx8bR1lFDuFu3moNy4I");
	    builder.addEventListeners(magia);
	    builder.addEventListeners(magiaExterna);
	    builder.build();

	}

}
