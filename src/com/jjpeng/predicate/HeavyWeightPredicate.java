package com.jjpeng.predicate;

import com.jjpeng.Apple;

public class HeavyWeightPredicate implements Predicate<Apple> {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
