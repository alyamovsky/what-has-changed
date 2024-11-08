package com.alyamovsky.whathaschanged.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class SteamApp {
    @JsonProperty("appid")
    public int appId;
    @JsonProperty("name")
    public String name;
}
