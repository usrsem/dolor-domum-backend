package com.idevtier.dolordomumbackend.telegram;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "telegram")
@Data
public class TelegramConfiguration {
    private List<Long> toChatIds;
    private String botToken;
}
