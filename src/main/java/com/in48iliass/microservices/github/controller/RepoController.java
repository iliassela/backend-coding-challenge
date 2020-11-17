package com.in48iliass.microservices.github.controller;

import com.in48iliass.microservices.github.entity.Item;
import com.in48iliass.microservices.github.entity.LangugesRepo;
import com.in48iliass.microservices.github.entity.Repo;

import com.in48iliass.microservices.github.service.IRepoService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RepoController {
@Autowired
private IRepoService repoService;
@GetMapping("/repo/{date}")
public Repo getRepo(@PathVariable String date){


return repoService.getFromGitUrl(date);
}
    @GetMapping("/repo/{date}/items")
    public List<Item> getRepos(@PathVariable String date){
    return repoService.getAllItems(date);
    }
    @GetMapping("/repo/{date}/languages")
     public List<String> getListLanguages(@PathVariable String date){
    return removeDuplicates(repoService.getAllLanguages(date));
}
    @GetMapping("/repo/{date}/languages/{language}")
public LangugesRepo getDetailsforLanguage(@PathVariable String date, @PathVariable String language){

        List<Item> trendingItems = repoService.getAllItems(date);
trendingItems=trendingItems.stream().filter(repository -> repository.getLanguage().toLowerCase().equals(language.toLowerCase())).collect(Collectors.toList());
return new LangugesRepo(trendingItems.size(),trendingItems);


}
    public static  ArrayList<String> removeDuplicates(List<String> list)
    {
        ArrayList<String> newList = new ArrayList<>();
        for (String element : list) {
            if (!newList.contains(element) && element != null) {
                newList.add(element);
            } }
        return newList;
    }

}
