package com.alyamovsky.whathaschanged.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Entity
public class SteamApp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    //@JdbcTypeCode(SqlTypes.UUID)
    @Getter
    private UUID id;

    @Column(name = "app_id", nullable = false)
    @Getter
    private Short appId;
}
