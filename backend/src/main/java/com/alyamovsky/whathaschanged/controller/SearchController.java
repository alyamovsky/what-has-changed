package com.alyamovsky.whathaschanged.controller;

public class SearchController {
    public List<SearchResultApp> search(String query) {
        return searchService.search(query);
    }
}
