package com.jjpeng.stream;

import java.util.Arrays;
import java.util.List;

public class DistinctDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 1, 4, 5, 3);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }
}
