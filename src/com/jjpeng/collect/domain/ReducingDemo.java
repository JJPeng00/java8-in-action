package com.jjpeng.collect.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ReducingDemo {

    public static void main(String[] args) {
        List<Dish> dishes = Dish.buildList();

        System.out.println("--------sum--------");
        System.out.println(dishes.stream().collect(Collectors.reducing(0, Dish::getCalories, (a, b) -> a + b)));
        System.out.println(dishes.stream().map(Dish::getCalories).reduce(0, (a, b) -> a + b));
        System.out.println(dishes.stream().map(Dish::getCalories).reduce(0, Integer::sum));

        System.out.println("--------max--------");
        System.out.println(dishes.stream().collect(Collectors.reducing((a, b) -> a.getCalories() > b.getCalories() ? a : b)));
        System.out.println(dishes.stream().reduce((a, b) -> a.getCalories() > b.getCalories() ? a : b));

        System.out.println("------name join--");
        System.out.println(dishes.stream().collect(Collectors.reducing("", Dish::getName, (a, b) -> a + b)));
        System.out.println(dishes.stream().map(Dish::getName).reduce("", (a, b) -> a + b));
        System.out.println(dishes.stream().map(Dish::getName).collect(Collectors.joining()));
        System.out.println(dishes.stream().map(Dish::getName).collect(Collectors.joining(",")));

    }
}
