package com.jjpeng.stream;

import java.util.List;

public class DishCountReduceDemo {
    public static void main(String[] args) {
        List<Dish> menu = Dish.buildList();
        System.out.println(menu.stream()
                .map(d -> 1)
                .reduce(0, Integer::sum));

        System.out.println(menu.stream().count());

        System.out.println((long) menu.size());

    }
}
