package com.jjpeng.stream;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreamsDemo {

    public static void main(String[] args) {
        List<Dish> menu = Dish.buildList();
        //转换为一个数值流
        IntStream intStream = menu.stream()
                .mapToInt(Dish::getCalories);
        int sum = intStream.sum();
        System.out.println(sum);

        //将数值流重新装箱为对象流（一般流）
        IntStream unboxedStream = menu.stream()
                .mapToInt(Dish::getCalories);
        Stream<Integer> boxed = unboxedStream.boxed();
    }
}
