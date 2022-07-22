package com.jjpeng.collect.domain;

import java.util.List;
import java.util.stream.Collectors;

public class JoiningDemo {

    public static void main(String[] args) {
        List<Dish> menu = Dish.buildList();

        System.out.println(menu.stream().map(Dish::getName).collect(Collectors.joining()));
        System.out.println(menu.stream().map(Dish::getName).collect(Collectors.joining(",")));
    }
}
