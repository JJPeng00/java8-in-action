package com.jjpeng.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 6, 2);
        System.out.println(sumByForEach(numbers));
        System.out.println(sumByReduce(numbers));

        System.out.println(mclByForEach(numbers));
        System.out.println(mclByReduce(numbers));

        Optional<Integer> optional = sumByReduceOptional(new ArrayList<>());
        System.out.println(optional.orElse(0));

    }

    private static int sumByForEach(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    //归约操作（将流归约成一个值）,用函数式编程语言的术语来说，这称为折叠（fold）
    private static Integer sumByReduce(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    private static int mclByForEach(List<Integer> numbers) {
        int result = 1;
        for (Integer number : numbers) {
            result *= number;
        }
        return result;
    }

    private static Integer mclByReduce(List<Integer> numbers) {
        return numbers.stream()
                .reduce(1, (a, b) -> a * b);
    }

    //规约，无初始值
    private static Optional<Integer> sumByReduceOptional(List<Integer> numbers) {
        return numbers.stream()
                .reduce(Integer::sum);
    }
    
}
