package com.jjpeng.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        List<Dish> menu = Dish.buildList();

        System.out.println(filterVegetarian(menu));
    }

    private static List<Dish> filterVegetarian(List<Dish> menu) {
        return menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
    }

}
