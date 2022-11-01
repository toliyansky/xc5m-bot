package dev.toliyansky.xc5mbot.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.response.BaseResponse;
import dev.toliyansky.xc5mbot.service.update.UpdateHandlingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class TelegramBotService {

    private final String botApiKey;
    private final UpdateHandlingService updateHandlingService;
    private TelegramBot telegramBot;

    public TelegramBotService(@Value("${bot.api-key}") String botApiKey,
                              @Lazy UpdateHandlingService updateHandlingService) {
        this.botApiKey = botApiKey;
        this.updateHandlingService = updateHandlingService;
    }

    @PostConstruct
    public void init() {
        telegramBot = new TelegramBot(botApiKey);

        telegramBot.setUpdatesListener(updates -> {
                    updates.forEach(updateHandlingService::handle);
                    return UpdatesListener.CONFIRMED_UPDATES_ALL;
                },
                telegramException -> log.error("Telegram exception", telegramException));
    }

    public <T extends BaseRequest<T, R>, R extends BaseResponse> R execute(BaseRequest<T, R> request) {
        return telegramBot.execute(request);
    }
}
