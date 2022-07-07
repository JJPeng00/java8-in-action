package com.jjpeng;

import com.jjpeng.predicate.GreenColorPredicate;
import com.jjpeng.predicate.HeavyWeightPredicate;
import com.jjpeng.predicate.Predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = initInventory();

        System.out.println(filter(inventory, new HeavyWeightPredicate()));
        System.out.println(filter(inventory, new GreenColorPredicate()));

        //使用匿名内部类，免去创建一个新的实现类的麻烦
        System.out.println(filter(inventory, new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 100;
            }
        }));

        //使用Lambda表达式
        System.out.println(filter(inventory, apple -> apple.getWeight() > 100));

        List<Integer> integers = Arrays.asList(1, 2, 4, 5, 6);
        System.out.println(filter(integers, i -> i % 2 == 0));
    }

    private static List<Apple> initInventory() {
        return Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
    }

    public static <T> List<T> filter(List<T> inventory, Predicate<T> predicate) {
        ArrayList<T> result = new ArrayList<>();
        for (T t : inventory) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

}
