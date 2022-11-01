package dev.toliyansky.xc5mbot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "UserSettings")
public class UserSettingsEntity {
    @Id
    private UUID uuid;
    @Column(name = "`telegramId`")
    private Long telegramId;
    @Column(name = "`showAuthor`")
    private Boolean showAuthor;
    @Column(name = "`created`")
    private Instant created;
}
