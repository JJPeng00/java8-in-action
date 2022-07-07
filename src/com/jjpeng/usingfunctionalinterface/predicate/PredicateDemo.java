package com.jjpeng.usingfunctionalinterface.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("", "hello", "world");
        Predicate<String> nonEmptyStringPredicate = s -> !s.isEmpty();
        System.out.println(filter(strings, nonEmptyStringPredicate));
    }

    public static <T> List<T> filter(List<T> list, Predicate p) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
}
