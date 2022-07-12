package com.jjpeng.stream;

import java.util.List;

public class MatchDemo {

    public static void main(String[] args) {
        List<Dish> menu = Dish.buildList();
        System.out.println(anyMatchVegetarian(menu));

        System.out.println(allMatchCaloriesLower(menu));

        System.out.println(nonMatchCaloriesGreater(menu));
    }

    //匹配，是否至少有一个菜是素菜
    private static boolean anyMatchVegetarian(List<Dish> menu) {
        return menu.stream()
                .anyMatch(Dish::isVegetarian);
    }

    //匹配，是否所有的菜的卡路里都低于1000
    private static boolean allMatchCaloriesLower(List<Dish> menu) {
        return menu.stream()
                .allMatch(d -> d.getCalories() <= 1000);
    }

    //匹配，是否所有的菜的卡路里都不高于1000
    private static boolean nonMatchCaloriesGreater(List<Dish> menu) {
        return menu.stream()
                .noneMatch(d -> d.getCalories() > 1000);
    }
}
