package com.alyamovsky.whathaschanged.command;

import com.alyamovsky.whathaschanged.dto.SteamApp;
import com.alyamovsky.whathaschanged.dto.SteamAppList;
import com.alyamovsky.whathaschanged.repository.SteamAppRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@ShellComponent
public class SteamImportCommand {
    public static final String STEAM_APPS_URL = "https://api.steampowered.com/ISteamApps/GetAppList/v0002/?format=json";
    private final RestClient restClient;
    private final SteamAppRepository steamAppRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public SteamImportCommand(RestClient restClient, SteamAppRepository steamAppRepository) {
        this.restClient = restClient;
        this.steamAppRepository = steamAppRepository;
    }

    @Transactional
    @ShellMethod(key = "fetch-apps", value = "Fetch Steam apps")
    public void fetchSteamApps(
    ) throws JsonProcessingException {
        var result = restClient.get().uri(STEAM_APPS_URL).retrieve().body(String.class);

        SteamAppList steamAppList = objectMapper.readValue(result, SteamAppList.class);
        List<SteamApp> apps = steamAppList.appList.apps;

        for (SteamApp steamApp : apps) {
            steamAppRepository.saveOrUpdate(steamApp.appId, steamApp.name);
        }
    }
}
