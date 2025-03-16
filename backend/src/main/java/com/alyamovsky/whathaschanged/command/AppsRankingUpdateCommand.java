package com.alyamovsky.whathaschanged.command;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.transaction.annotation.Transactional;

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
