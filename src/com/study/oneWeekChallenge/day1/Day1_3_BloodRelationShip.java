package com.study.oneWeekChallenge.day1;

import java.util.Scanner;

/**
 * DNA 是由 ACGT 四种核苷酸组成，例如 AAAGTCTGAC，假定自然环境下 DNA 发生异变的情况有：
 *
 * 基因缺失一个核苷酸
 * 基因新增一个核苷酸
 * 基因替换一个核苷酸
 * 且发生概率相同。
 * 古生物学家 Sam 得到了若干条相似 DNA 序列，Sam 认为一个 DNA 序列向另外一个 DNA 序列转变所需的最小异变情况数可以代表其物种血缘相近程度，异变情况数越少，血缘越相近，请帮助 Sam 实现获取两条 DNA 序列的最小异变情况数的算法。
 *
 * 格式：
 * 输入：
 * - 每个样例只有一行，两个 DNA 序列字符串以英文逗号“,”分割
 * 输出：
 * - 输出转变所需的最少情况数，类型是数字
 *
 * 示例：
 * 输入：ACT,AGCT
 * 输出：1
 *
 * 提示：
 * 每个 DNA 序列不超过 100 个字符
 */
public class Day1_3_BloodRelationShip {

    public static int minNum(String pre, String cur) {
        int prelen = pre.length(), curlen = cur.length();
        if (prelen == 0 || curlen == 0) {
            return prelen == 0 ? curlen : prelen;
        }
        int[][] dp = new int[prelen + 1][ curlen + 1];
        dp[0][0] = 0;
        for (int i = 0; i <= prelen; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= curlen; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= prelen; i++) {
            for (int j = 1; j <= curlen; j++) {
                if (pre.charAt(i - 1) != cur.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]) + 1);
                }
            }
        }
        return dp[prelen][curlen];
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String input = "";
        if (scan.hasNext()) {
            input = scan.nextLine();
        }
        scan.close();
        String[] array = input.split(",");
        System.out.println(minNum(array[0] , array[1]));
    }
}


