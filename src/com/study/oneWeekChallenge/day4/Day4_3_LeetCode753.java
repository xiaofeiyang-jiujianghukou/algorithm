package com.study.oneWeekChallenge.day4;

import java.util.HashSet;
import java.util.Set;

/**
 * 破解保险箱
 * 有一个需要密码才能打开的保险箱。密码是 n 位数, 密码的每一位是 k 位序列 0, 1, ..., k-1 中的一个 。
 *
 * 你可以随意输入密码，保险箱会自动记住最后 n 位输入，如果匹配，则能够打开保险箱。
 *
 * 举个例子，假设密码是 "345"，你可以输入 "012345" 来打开它，只是你输入了 6 个字符.
 *
 * 请返回一个能打开保险箱的最短字符串。
 *
 * 示例1:
 *
 * 输入: n = 1, k = 2
 * 输出: "01"
 * 说明: "10"也可以打开保险箱。
 *
 * 示例2:
 *
 * 输入: n = 2, k = 2
 * 输出: "00110"
 * 说明: "01100", "10011", "11001" 也能打开保险箱。
 *
 * 提示：
 *
 * n 的范围是[1, 4]。
 * k 的范围是[1, 10]。
 * k^n 最大可能为4096。
 *
 * 作者：字节校园
 * 链接：https://leetcode-cn.com/leetbook/read/bytedance-c01/eiz49e/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Day4_3_LeetCode753 {

    private static String res = "";

    public static void recursive(int n, int k, String str, HashSet set) {
        if (!res.isEmpty()) return;
        if (set.size() == Math.pow(n, k)) {
            res = str;
        }
        for (int i = 0; i < k; i++) {
            String next = str + i;
            if (next.length() < n)
                recursive(n, k, next, set);
            else {
                String tmp = next.substring(next.length() - n);
                if (!set.contains(tmp)) {
                    set.add(tmp);
                    recursive(n, k, next,set);
                    set.remove(tmp);
                }
            }
        }
    }

    public static String crackSafe(int n, int k) {
        recursive(n, k, "", new HashSet<>());
        return res;
    }

    public static void main(String[] args) {
        String s = crackSafe(1, 1);
        System.out.println(s);
    }

}
