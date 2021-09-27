package com.study.oneWeekChallenge.day1;

/**
 * 最大矩形
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * 示例 2：
 *
 * 输入：matrix = []
 * 输出：0
 * 示例 3：
 *
 * 输入：matrix = [["0"]]
 * 输出：0
 * 示例 4：
 *
 * 输入：matrix = [["1"]]
 * 输出：1
 * 示例 5：
 *
 * 输入：matrix = [["0","0"]]
 * 输出：0
 *
 * 作者：字节校园
 * 链接：https://leetcode-cn.com/leetbook/read/bytedance-c01/eik5p2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Day1_4_LeetCode85 {

    public static int maximalRectangle(char[][] matrix) {
        int rowlen = matrix.length;
        if (rowlen == 0) return 0;
        int collen = matrix[0].length;
        if (collen == 0) return 0;
        int[][] field = new int[rowlen][collen];
        for (int i = 0; i < rowlen; i++) {
            int temp = 0;
            for (int j = 0; j < collen; j++) {
                if (matrix[i][j] == '1') {
                    field[i][j] = ++temp;
                } else {
                    temp = 0;
                }
            }
        }
        int answer = 0;
        for (int j = 0; j < collen; j++) {
            for (int i = 0; i < rowlen; i++) {
                int area = 0, minval = field[i][j], m = i;
                while (m >= 0 && field[m][j] > 0) {
                    minval = Math.min(minval, field[m][j]);
                    area = Math.max(area, minval * (i - m + 1));
                    m--;
                }
                answer = Math.max(answer, area);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        //char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char[][] matrix = {{'1'}};
        int i = maximalRectangle(matrix);
        System.out.println(i);
    }
}


