package com.alyamovsky.whathaschanged.entity;

import com.alyamovsky.whathaschanged.Views;
import com.fasterxml.jackson.annotation.JsonView;
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
    private Integer appId;
    @Column(name = "name", nullable = false)
    @JsonView({Views.SearchResultApp.class})
    private String name;
    @Column(name = "added_at", nullable = false)
    private Date addedAt;
    @Column(name = "updated_at")
    private Date updatedAt;
}
