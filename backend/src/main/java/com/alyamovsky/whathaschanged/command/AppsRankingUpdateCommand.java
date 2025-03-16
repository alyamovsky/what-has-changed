package com.alyamovsky.whathaschanged.command;

import com.alyamovsky.whathaschanged.dto.SteamApp;
import com.alyamovsky.whathaschanged.dto.SteamAppList;
import com.alyamovsky.whathaschanged.repository.SteamAppRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;

import java.util.List;

@ShellComponent
public class AppsRankingUpdateCommand {
    @Value("${application.ranking-url}")
    private String $url;

    @Transactional
    @ShellMethod(key = "update-ranking", value = "Update steam apps ranking")
    public void fetchSteamApps(
    ) throws JsonProcessingException {
        System.out.println($url);
    }
}
