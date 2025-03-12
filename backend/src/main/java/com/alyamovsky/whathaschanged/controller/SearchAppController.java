package com.alyamovsky.whathaschanged.controller;

import com.alyamovsky.whathaschanged.Views;
import com.alyamovsky.whathaschanged.entity.SteamApp;
import com.alyamovsky.whathaschanged.repository.SteamAppRepository;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class SearchAppController {
    private final SteamAppRepository repository;

    public SearchAppController(SteamAppRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/frontend/steam-apps")
    @JsonView(Views.SearchResultApp.class)
    public List<SteamApp> search(@RequestParam String namePart) {
        return repository.findByNameContainingIgnoreCase(namePart);
    }
}
