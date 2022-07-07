package com.jjpeng.usingfunctionalinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<String, Integer> function = (String s) -> s.length();
        List<String> strings = Arrays.asList("", "hello", "world");
        System.out.println(map(strings, function));
        System.out.println(map(strings, String::length));
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }
}
