package com.jjpeng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = initInventory();

        System.out.println(filterGreenApples(inventory));
        System.out.println(filterApples(inventory, FilteringApples::isGreenApple));
        System.out.println(filterApples(inventory, (apple -> "green".equals(apple.getColor()))));

        System.out.println(filterHeavyApples(inventory));
        System.out.println(filterApples(inventory, FilteringApples::isHeavyApple));
        System.out.println(filterApples(inventory, apple -> apple.getWeight() > 150));
        //stream 串行
        System.out.println(inventory.stream().filter(apple -> apple.getWeight() > 150).collect(Collectors.toList()));
        //stream 并行
        System.out.println(inventory.parallelStream().filter(apple -> apple.getWeight() > 150).collect(Collectors.toList()));

        System.out.println(filterApples(inventory, apple -> "red".equals(apple.getColor()) || apple.getWeight() > 80));

        System.out.println(filterApplesByColor(inventory, "red"));

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

    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

}
