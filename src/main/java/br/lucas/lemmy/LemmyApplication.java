package br.lucas.lemmy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class LemmyApplication {

	public static void main(String[] args) {
		SpringApplication.run(LemmyApplication.class, args);
		
		DiscordClient client = DiscordClient.create("ODk0NjIwNjM3MDQ0MzAxODY2.YVsqZQ.uokveGoLkPFmojtWHWGFkiZIabM");
		
		Mono<Void> login = client.withGateway((GatewayDiscordClient gateway) -> {
			
			Mono<Void> handlePingCommand = gateway.on(MessageCreateEvent.class, event -> {
					Message msg = event.getMessage();
					
					if (msg.getContent().equalsIgnoreCase("!ping")) {
						return msg.getChannel().flatMap(channel -> channel.createMessage("Pong!"));
					}
					
					return Mono.empty();
				}).then();
			
			return handlePingCommand;
			
		});
		
		login.block();
		
	}

}
