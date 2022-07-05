package com.jjpeng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = initInventory();

        System.out.println(filterGreenApples(inventory));
        System.out.println(filterApples(inventory, FilteringApples::isGreenApple));

        System.out.println(filterHeavyApples(inventory));
        System.out.println(filterApples(inventory, FilteringApples::isHeavyApple));
    }

    private static List<Apple> initInventory() {
        return Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
    }

    //Java8之前过滤green苹果的写法
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (isGreenApple(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    private static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (isHeavyApple(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    private static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

}
