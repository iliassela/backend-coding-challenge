package com.in48iliass.microservices.github.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LangugesRepo {

    private int numbers_of_repos;
    private List<Item> items;
}
