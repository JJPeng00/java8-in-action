package com.jjpeng.stream;

import java.util.List;
import java.util.stream.Collectors;

public class LimitDemo {
    public static void main(String[] args) {
        List<Dish> menu = Dish.buildList();
        List<Dish> collect = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
