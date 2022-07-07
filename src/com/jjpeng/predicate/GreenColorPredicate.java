package com.jjpeng.predicate;

import com.jjpeng.Apple;

public class GreenColorPredicate implements Predicate<Apple> {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
