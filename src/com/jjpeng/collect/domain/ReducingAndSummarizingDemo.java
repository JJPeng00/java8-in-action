package com.jjpeng.collect.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReducingAndSummarizingDemo {

    public static void main(String[] args) {
        List<Dish> menu = Dish.buildList();

        System.out.println("-------count--------");
        System.out.println(menu.stream().collect(Collectors.counting()));
        System.out.println(menu.stream().count());
        System.out.println(menu.size());

        System.out.println("-------max----------");
        System.out.println(menu.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories))));
        System.out.println(menu.stream().max(Comparator.comparing(Dish::getCalories)));

        System.out.println("-------min----------");
        System.out.println(menu.stream().collect(Collectors.minBy(Comparator.comparing(Dish::getCalories))));
        System.out.println(menu.stream().min(Comparator.comparing(Dish::getCalories)));

        System.out.println("-------sum----------");
        System.out.println(menu.stream().collect(Collectors.summingInt(Dish::getCalories)));
        System.out.println(menu.stream().mapToInt(Dish::getCalories).sum());

        System.out.println("-------average----------");
        System.out.println(menu.stream().collect(Collectors.averagingInt(Dish::getCalories)));

        System.out.println("-------summarizing----------");
        System.out.println(menu.stream().collect(Collectors.summarizingInt(Dish::getCalories)));
    }
}
