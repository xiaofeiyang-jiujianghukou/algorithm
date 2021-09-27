package com.study.oneWeekChallenge.day2;

/**
 * 放置盒子
 有一个立方体房间，其长度、宽度和高度都等于 n 个单位。请你在房间里放置 n 个盒子，每个盒子都是一个单位边长的立方体。放置规则如下：

 你可以把盒子放在地板上的任何地方。
 如果盒子 x 需要放置在盒子 y 的顶部，那么盒子 y 竖直的四个侧面都 必须 与另一个盒子或墙相邻。
 给你一个整数 n ，返回接触地面的盒子的 最少 可能数量。

 作者：字节校园
 链接：https://leetcode-cn.com/leetbook/read/bytedance-c01/eikfoc/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Day2_1_LeetCode1739 {

    public static int minimumBoxes(int n) {
        int k = 1, sum = 0;
        //最多能够填满的完整层数
        while (sum + k * (k+1) / 2 <= n) {
            sum += k * (k+1) / 2;
            k++;
        }
        int answer = k * (k-1) / 2;
        k = 1;
        //对剩余的方块沿着底层放，放第k个的贡献度是k
        while (sum < n) {
            sum += k;
            k++;
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 4;
        int i = minimumBoxes(n);
        System.out.println(i);
    }
}


