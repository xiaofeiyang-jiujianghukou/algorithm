package com.study.oneWeekChallenge.day1;

import java.util.HashMap;
import java.util.Map;

/**
 * 阶乘后的零
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 *
 * 进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？
 */
public class Day1_2_LeetCode172 {

    public int trailingZeroes(int n) {
        if (n < 5) {
            return 0;
        }
        int count = 0;
        while (n >= 5) {
            count = n / 5;
            n /= 5;
        }
        return count;
    }
}


