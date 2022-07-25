package com.jjpeng.collect.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupDemo {
    enum CaloricLevel { DIET, NORMAL, FAT }

    public static void main(String[] args) {
        List<Dish> dishes = Dish.buildList();
        System.out.println("-------groupByType");
        //根据现有函数（规则）
        System.out.println(dishes.stream().collect(Collectors.groupingBy(Dish::getType)));

        //自定义规则分组
        Map<CaloricLevel, List<Dish>> groupByCaloricLevel = dishes.stream().collect(Collectors.groupingBy(it -> {
            if (it.getCalories() <= 400) return CaloricLevel.DIET;
            else if (it.getCalories() <= 700) return CaloricLevel.NORMAL;
            else return CaloricLevel.FAT;
        }));
        System.out.println("-------groupByCaloricLevel");
        System.out.println(groupByCaloricLevel);
    }
}
