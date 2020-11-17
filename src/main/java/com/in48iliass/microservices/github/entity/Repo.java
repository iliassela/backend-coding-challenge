package com.in48iliass.microservices.github.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repo {
    private Long total_count;
    private Boolean incomplete_results;
    private List<Item> items;


}
