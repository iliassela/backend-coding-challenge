package com.in48iliass.microservices.github.service;

import com.in48iliass.microservices.github.entity.Item;
import com.in48iliass.microservices.github.entity.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RepoService implements IRepoService {
    @Autowired
    RestTemplate restTemplateWithErrorHandler;
    public <T> ResponseEntity consume(String url, Class<T> responseType, Map<String,String> uriVariables) {
        return restTemplateWithErrorHandler.getForEntity(url, responseType, uriVariables);
    }

    @Override
    public Repo getFromGitUrl(String date) {
        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("date",date);
        ResponseEntity<Repo> repoResponseEntity = consume(
                "https://api.github.com/search/repositories?q=created:>{date}&sort=stars&order=desc",
                Repo.class,
                uriVariables);
        Repo   repo  = repoResponseEntity.getBody();
        return repo;
    }
    @Override
    public List<Item> getAllItems(String date) {
        Repo repo= getFromGitUrl(date);
        List<Item> trendingItems = repo.getItems().stream().limit(100).collect(Collectors.toList());
        trendingItems=trendingItems.stream().filter(repository -> repository.getLanguage() != null).collect(Collectors.toList());
        return trendingItems; }

    @Override
    public List<String> getAllLanguages(String date) {
        List<Item> trendingItems = getAllItems(date);
        List<String> languages = new ArrayList<>();
        for(Item item:trendingItems) languages.add(item.getLanguage());
        return languages;
    }


}
