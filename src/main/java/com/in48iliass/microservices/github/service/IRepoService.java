package com.in48iliass.microservices.github.service;

import com.in48iliass.microservices.github.entity.Item;
import com.in48iliass.microservices.github.entity.Repo;

import java.util.List;

public interface IRepoService {
Repo getFromGitUrl(String date);
List<String> getAllLanguages(String date);
List<Item> getAllItems(String date);
}
