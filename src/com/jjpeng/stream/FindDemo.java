package com.jjpeng.stream;

import java.util.List;
import java.util.Optional;

public class FindDemo {
    public static void main(String[] args) {
        List<Dish> menu = Dish.buildList();

        Optional<Dish> anyVegetarian = findAnyVegetarian(menu);
        anyVegetarian.ifPresent(d -> System.out.println(d.getName()));

        Optional<Dish> firstVegetarian = findFirstVegetarian(menu);
        firstVegetarian.ifPresent(d -> System.out.println(d.getName()));
    }

    //返回任意一道素菜
    private static Optional<Dish> findAnyVegetarian(List<Dish> menu) {
        return menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
    }

    //返回第一道素菜；相比于findAny，findFirst有更多的并行局限性（findAny更有利于并行）
    private static Optional<Dish> findFirstVegetarian(List<Dish> menu) {
        return menu.stream()
                .filter(Dish::isVegetarian)
                .findFirst();
    }
}
