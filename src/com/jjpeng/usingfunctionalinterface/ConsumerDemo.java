package com.jjpeng.usingfunctionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args) {
        Consumer<Integer> consumer = i -> System.out.println(i);
        forEach(Arrays.asList(1,2,3,4), consumer);
        forEach(Arrays.asList(1,2,3,4), System.out::println);
    }

    public static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }

}
