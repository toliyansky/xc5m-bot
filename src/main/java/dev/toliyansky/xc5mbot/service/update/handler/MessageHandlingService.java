package dev.toliyansky.xc5mbot.service.update.handler;

import com.pengrad.telegrambot.model.Update;
import dev.toliyansky.xc5mbot.repository.TelegramUserRepository;
import dev.toliyansky.xc5mbot.repository.UserSettingsRepository;
import dev.toliyansky.xc5mbot.service.TelegramBotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageHandlingService {

    private final TelegramUserRepository telegramUserRepository;
    private final TelegramBotService telegramBotService;
    private final UserSettingsRepository userSettingsRepository;

    private final Long xc5mGroupId;

    MessageHandlingService(TelegramUserRepository telegramUserRepository,
                           TelegramBotService telegramBotService,
                           UserSettingsRepository userSettingsRepository,
                           @Value("${bot.xc5m-group-id}") Long xc5mGroupId) {
        this.telegramUserRepository = telegramUserRepository;
        this.telegramBotService = telegramBotService;
        this.userSettingsRepository = userSettingsRepository;
        this.xc5mGroupId = xc5mGroupId;
    }

    public void handle(Update update) {
        var message = update.message();
        if (message != null) {
            var chatId = message.chat().id();
            if (chatId.equals(message.from().id())) {
//                handlePersonalMessage(message); // PM with Bot
            } else if (chatId.equals(xc5mGroupId)) {
//                handleXc5mGroupMessage(message); // XC5M group
            } else {
                log.debug("Message from unknown chat {}", chatId);
            }
        }
    }
}
