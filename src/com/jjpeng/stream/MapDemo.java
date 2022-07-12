package com.jjpeng.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MapDemo {
    public static void main(String[] args) {
        map();
        mapMap();
        flatMap();
    }

    private static void map() {
        List<String> strings = Arrays.asList("hello", "world");
        Stream<String[]> stream = strings.stream()
                //s.split("") 将一个单词分割成一个字符组成的数组
                .map(s -> s.split(""));
    }

    private static void mapMap() {
        List<String> strings = Arrays.asList("hello", "world");
        Stream<Stream<String>> streamStream = strings.stream()
                //s.split("") 将一个单词分割成一个字符组成的数组
                .map(s -> s.split(""))
                //将每个数组转分别装换成一个对应的流
                .map(Arrays::stream);
    }

    private static void flatMap() {
        List<String> strings = Arrays.asList("hello", "world");
        Stream<String> stringStream = strings.stream()
                //s.split("") 将一个单词分割成一个字符组成的数组
                .map(s -> s.split(""))
                //将所有的数组映射（合并）为同一个流
                .flatMap(Arrays::stream);
    }
}
