package com.google.ClonGoogle.controllers;

import com.google.ClonGoogle.entities.WebPage;
import com.google.ClonGoogle.services.SearchService;
import com.google.ClonGoogle.services.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SearchController {
    @Autowired
    private SearchService service;

    @Autowired
    private SpiderService spiderService;

    @RequestMapping(value = "api/search", method = RequestMethod.GET)
    public List<WebPage> search(@RequestParam Map<String, String> params) {
        String query = params.get("query");
        return service.search(query);

    }

    @RequestMapping(value = "api/test", method = RequestMethod.GET)
    public void test() {
        spiderService.indexWebPages();

    }
}
