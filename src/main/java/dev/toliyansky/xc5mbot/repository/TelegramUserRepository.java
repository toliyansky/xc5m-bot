package dev.toliyansky.xc5mbot.repository;

import dev.toliyansky.xc5mbot.entity.TelegramUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TelegramUserRepository extends JpaRepository<TelegramUserEntity, UUID> {
    TelegramUserEntity findByUserId(long userId);
}
