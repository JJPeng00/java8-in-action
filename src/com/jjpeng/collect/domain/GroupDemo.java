package com.jjpeng.collect.domain;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupDemo {
    enum CaloricLevel {DIET, NORMAL, FAT}

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

        //根据类型分组后再根据卡路里等级多级分组
        System.out.println(dishes.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(it -> {
            if (it.getCalories() <= 400) return CaloricLevel.DIET;
            else if (it.getCalories() <= 700) return CaloricLevel.NORMAL;
            else return CaloricLevel.FAT;
        }))));

        //对分组后的数据进行收集
        System.out.println("-------collect after group");
        System.out.println(dishes.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting())));

        //Collectors.maxBy将返回Optional，但在这里Optional可能用处不大，对于不存在的类型直接返回null即可，即需要将收集后的结果转换为另一种类型
        System.out.println(dishes.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)))));

        //将分组后收集的结果再转换成另一种类型
        System.out.println(dishes.stream().collect(Collectors.groupingBy(Dish::getType,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get))));

        System.out.println(dishes.stream().collect(Collectors.toMap(Dish::getType, Function.identity(), BinaryOperator.maxBy(Comparator.comparingInt(Dish::getCalories)))));


        //分组并指定分组的收集器（默认的分组收集器是toList()）
        System.out.println(
                dishes.stream().collect(
                        Collectors.groupingBy(Dish::getType,
                                Collectors.groupingBy(it -> {
                                            if (it.getCalories() <= 400) return CaloricLevel.DIET;
                                            else if (it.getCalories() <= 700) return CaloricLevel.NORMAL;
                                            else return CaloricLevel.FAT;
                                        },
                                        Collectors.toCollection(HashSet::new)))));
    }
}
