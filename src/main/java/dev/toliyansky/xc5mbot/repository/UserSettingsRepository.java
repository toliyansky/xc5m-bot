package dev.toliyansky.xc5mbot.repository;

import dev.toliyansky.xc5mbot.entity.UserSettingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserSettingsRepository extends JpaRepository<UserSettingsEntity, UUID> {
    UserSettingsEntity findByTelegramId(Long telegramId);
}
