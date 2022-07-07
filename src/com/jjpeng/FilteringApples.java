package com.jjpeng;

import com.jjpeng.predicate.AppleHeavyWeightPredicate;
import com.jjpeng.predicate.ApplePredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = initInventory();

        System.out.println(filterApples(inventory, new AppleHeavyWeightPredicate()));
        System.out.println(filterApples(inventory, new AppleHeavyWeightPredicate()));

        //使用匿名内部类，免去创建一个新的实现类的麻烦
        System.out.println(filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 100;
            }
        }));
    }

    private static List<Apple> initInventory() {
        return Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

}
