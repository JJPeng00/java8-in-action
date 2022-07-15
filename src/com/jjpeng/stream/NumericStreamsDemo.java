package com.jjpeng.stream;

import java.util.List;
import java.util.OptionalInt;
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

        //与上面的sum方法包含一个默认0值不同的是，max不能有默认值，可以使用特化的Optional来接收该值
        OptionalInt max = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        System.out.println(max.orElse(2));
    }
}
