package com.jjpeng.collect.domain.collector;

import com.jjpeng.collect.domain.Dish;

import java.util.List;
import java.util.stream.Collectors;

public class CustomCollectorDemo {

    public static void main(String[] args) {
        List<Dish> dishes = Dish.buildList();

        //使用自定义收集器
        System.out.println(dishes.stream().collect(new ToListCollector<>()));
        System.out.println(dishes.stream().collect(Collectors.toList()));
    }
}
