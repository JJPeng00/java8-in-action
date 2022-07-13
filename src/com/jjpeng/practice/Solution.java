package com.jjpeng.practice;

import com.jjpeng.practice.domain.Trader;
import com.jjpeng.practice.domain.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //Question:
        //找出2011年发生的所有交易，并按交易额排序（从低到高）
        List<Transaction> result1 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println("找出2011年发生的所有交易，并按交易额排序（从低到高）:");
        System.out.println(result1);

        //交易员都在哪些不同的城市工作过？
        List<String> result2 = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        Set<String> result3 = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .collect(Collectors.toSet());
        System.out.println("交易员都在哪些不同的城市工作过:");
        System.out.println(result2);
        System.out.println(result3);

        //todo: 查找所有来自于剑桥的交易员，并按姓名排序
        //todo: 返回所有交易员的姓名字符串，按字母顺序排序
        //todo: 有没有交易员是在米兰工作的？
        //todo: 打印生活在剑桥的交易员的所有交易额
        //todo: 所有交易中，最高的交易额是多少？
        //todo: 找到交易额最小的交易

    }
}
