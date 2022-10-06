package com.idevtier.dolordomumbackend.telegram.boudnaries.impl;

import com.idevtier.dolordomumbackend.telegram.TelegramConfiguration;
import com.idevtier.dolordomumbackend.telegram.boudnaries.TelegramMessageSender;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.net.URI;

@Service
@AllArgsConstructor
public class RestTemplateTelegramMessageSender implements TelegramMessageSender {

    private final RestTemplate restTemplate;
    private final TelegramConfiguration configuration;

    @PostConstruct
    public void init() {
        System.out.println(configuration);
    }

    @Override
    public void send(String message) {
        var formattedMessage = message
                .replace(" ", "%20")
                .replace("\n", "%0A");
        for (Long toChatId : configuration.getToChatIds()) {
            restTemplate.postForObject(getUri(toChatId, formattedMessage), null, Object.class);
        }
    }

    @SneakyThrows
    private URI getUri(Long toChatId, String formattedMessage) {
        return new URI("https://api.telegram.org/bot"
                + configuration.getBotToken()
                + "/sendMessage?chat_id=" + toChatId
                + "&text=" + formattedMessage);
    }
}
