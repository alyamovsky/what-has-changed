package com.alyamovsky.whathaschanged.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SteamAppList {
    @JsonProperty("applist")
    public AppList appList;

    public static class AppList {
        @JsonProperty("apps")
        public List<SteamApp> apps;
    }
}