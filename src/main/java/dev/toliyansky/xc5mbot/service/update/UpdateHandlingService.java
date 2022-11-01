package dev.toliyansky.xc5mbot.service.update;

import com.pengrad.telegrambot.model.Update;
import dev.toliyansky.xc5mbot.service.update.handler.CallbackQueryHandlingService;
import dev.toliyansky.xc5mbot.service.update.handler.MessageHandlingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UpdateHandlingService {

    private final CallbackQueryHandlingService callbackQueryHandlingService;
    private final MessageHandlingService messageHandlingService;

    UpdateHandlingService(MessageHandlingService messageHandlingService,
                          CallbackQueryHandlingService callbackQueryHandlingService) {
        this.callbackQueryHandlingService = callbackQueryHandlingService;
        this.messageHandlingService = messageHandlingService;
    }

    public void handle(Update update) {
        try {
            log.debug("Processing update: {}", update);

            callbackQueryHandlingService.handle(update);
            messageHandlingService.handle(update);
        } catch (Exception e) {
            log.error("Error update handling", e);
            // send message to admin
        }
    }
}
