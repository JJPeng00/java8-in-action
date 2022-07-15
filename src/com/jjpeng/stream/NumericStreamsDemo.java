package com.jjpeng.stream;

import java.util.List;
import java.util.stream.IntStream;

public class NumericStreamsDemo {

    public static void main(String[] args) {
        List<Dish> menu = Dish.buildList();
        //转换为一个数值流
        IntStream intStream = menu.stream()
                .mapToInt(Dish::getCalories);
        int sum = intStream.sum();
        System.out.println(sum);
    }
}
