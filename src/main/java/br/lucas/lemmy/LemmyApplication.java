package br.lucas.lemmy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.lucas.lemmy.magia.MagiaEvent;
import net.dv8tion.jda.api.JDABuilder;

@SpringBootApplication
public class LemmyApplication implements CommandLineRunner {

	@Autowired
	private MagiaEvent magiaEvento;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(LemmyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	    JDABuilder jdaConstrutor = JDABuilder.createDefault("ODk0NjIwNjM3MDQ0MzAxODY2.YVsqZQ.4vZ6lEy5DLp4Z6JNo8JFomDv-hQ");
	    jdaConstrutor.addEventListeners(magiaEvento);
	    jdaConstrutor.build();

	}

}
