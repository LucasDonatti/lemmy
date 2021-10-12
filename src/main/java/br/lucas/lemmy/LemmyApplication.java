package br.lucas.lemmy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.lucas.lemmy.events.HelloEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

@SpringBootApplication
public class LemmyApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(LemmyApplication.class, args);
		
        JDA jda = JDABuilder.createDefault("ODk0NjIwNjM3MDQ0MzAxODY2.YVsqZQ.VMf7tVxHqU13ChxMUlupxc639Ww").build();
        //You can also add event listeners to the already built JDA instance
        // Note that some events may not be received if the listener is added after calling build()
        // This includes events such as the ReadyEvent
        jda.addEventListener(new HelloEvent());
	}

}
