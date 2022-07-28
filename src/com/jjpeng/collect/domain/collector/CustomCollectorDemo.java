package com.jjpeng.collect.domain.collector;

import com.jjpeng.collect.domain.Dish;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomCollectorDemo {

    public static void main(String[] args) {
        List<Dish> dishes = Dish.buildList();

        //使用自定义收集器
        System.out.println(dishes.stream().collect(new ToListCollector<>()));
        System.out.println(dishes.stream().collect(Collectors.toList()));

        //自定义收集方式，而无需自定义收集器
        List<Dish> list1 = dishes.stream().collect(
                ArrayList::new, //创建保存结果的容器
                List::add, //累加器，将元素添加到结果容器中
                List::addAll //组合器，当并行处理一个流时，将各个子流产生的结果容器合并起来（将各容器的结果组合起来）
        );
        List<Dish> list2 = dishes.stream().collect(
                LinkedList::new, //创建保存结果的容器
                List::add, //累加器，将元素添加到结果容器中
                List::addAll //组合器，当并行处理一个流时，将各个子流产生的结果容器合并起来（将各容器的结果组合起来）
        );
        System.out.println(list1);
        System.out.println(list2);
    }
}
