package dev.toliyansky.xc5mbot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TelegramUser")
public class TelegramUserEntity {
    @Id
    private UUID uuid;
    @Column(name = "`userId`")
    private Long userId;
    @Column(name = "`nickname`")
    private String nickname;
    @Column(name = "`banned`")
    private Boolean banned;
}
