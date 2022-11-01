package dev.toliyansky.xc5mbot.service.update.handler;

import com.pengrad.telegrambot.model.Update;
import dev.toliyansky.xc5mbot.repository.UserSettingsRepository;
import dev.toliyansky.xc5mbot.service.TelegramBotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CallbackQueryHandlingService {

    private final UserSettingsRepository userSettingsRepository;
    private final TelegramBotService telegramBotService;

    private final Long xc5mGroupId;
    private final Long xc5mChannelId;
    private final Long xc5mBotId;
    private final Boolean allowVoteYourself;

    public CallbackQueryHandlingService(UserSettingsRepository userSettingsRepository,
                                        TelegramBotService telegramBotService,
                                        @Value("${bot.xc5m-group-id}") Long xc5mGroupId,
                                        @Value("${bot.xc5m-channel-id}") Long xc5mChannelId,
                                        @Value("${bot.xc5m-bot-id}") Long xc5mBotId,
                                        @Value("${bot.allowVoteYourself}") Boolean allowVoteYourself) {
        this.userSettingsRepository = userSettingsRepository;
        this.telegramBotService = telegramBotService;
        this.xc5mGroupId = xc5mGroupId;
        this.xc5mChannelId = xc5mChannelId;
        this.xc5mBotId = xc5mBotId;
        this.allowVoteYourself = allowVoteYourself;
    }

    public void handle(Update update) {
        var callbackQuery = update.callbackQuery();
        if (callbackQuery != null) {
            var callbackQueryMessage = callbackQuery.message();
            if (callbackQueryMessage != null) {
                if (callbackQueryMessage.chat().id().equals(xc5mGroupId)) {
//                    handleFromXc5mGroup(callbackQuery);
                } else if (callbackQueryMessage.chat().id().equals(xc5mChannelId)) {
//                    handleFromXc5mChannel(callbackQuery);
                } else if (callbackQueryMessage.from().id().equals(xc5mBotId)) {
//                    handleFromAuthor(callbackQuery);
                } else {
                    log.info("Unknown chat id in callback query message");
                }
            }
        }
    }
}
