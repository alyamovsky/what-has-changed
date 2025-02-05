package com.alyamovsky.whathaschanged.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.Date;

@Getter
@Entity(name = "steam_apps")
public class SteamApp {
    @Id
    @Column(name = "app_id", nullable = false)
    private Short appId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "added_at", nullable = false)
    private Date addedAt;
    @Column(name = "updated_at")
    private Date updatedAt;
}
