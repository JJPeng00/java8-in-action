package com.jjpeng.predicate;

import com.jjpeng.Apple;

public interface Predicate<T> {
    boolean test(T t);
}
